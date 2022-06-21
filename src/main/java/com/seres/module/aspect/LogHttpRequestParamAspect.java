package com.seres.module.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Objects;


@Slf4j
@Aspect
@ConditionalOnProperty(name = "log.request.param.enabled", matchIfMissing = true, havingValue = "true")
public class LogHttpRequestParamAspect {

	@Pointcut("(@annotation(org.springframework.web.bind.annotation.DeleteMapping)"
			+ "||@annotation(org.springframework.web.bind.annotation.GetMapping)"
			+ "||@annotation(org.springframework.web.bind.annotation.PatchMapping)"
			+ "||@annotation(org.springframework.web.bind.annotation.PostMapping)"
			+ "||@annotation(org.springframework.web.bind.annotation.PutMapping)"
			+ "||@annotation(org.springframework.web.bind.annotation.RequestMapping))"
			+ "&&execution(public * com.seres..*Controller.*(..))")
	public void requestMapping() {
		//Do Nothing
	}

	@Before("requestMapping()")
	public void printRequest(JoinPoint joinPoint) {
		String servletPath = "路径获取失败!";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			if (Objects.nonNull(requestAttributes)) {
				servletPath = requestAttributes.getRequest().getMethod() + " "
						+ requestAttributes.getRequest().getServletPath();
			}
			String param = getJoinPointArgs(joinPoint);
			log.info("\n\t【{}】监控到接口请求，请求路径[{}]，接口：[{}]\n\t请求参数：{}\n", Thread.currentThread().toString(), servletPath,
					joinPoint.getSignature().toString(), param);
		} catch (Exception e) {
			log.error("【{}】接口请求参数打印失败！接口路径[{}]", Thread.currentThread().toString(), servletPath);
		}
	}

	@AfterReturning(returning = "result", pointcut = "requestMapping()||@annotation(org.springframework.web.bind.annotation.ExceptionHandler)")
	public void printResult(Object result) {
		try {
			log.info("\n\t【{}】接口返回成功！\n\t返回参数:\n\t\t{}\n", Thread.currentThread().toString(),
					JSON.toJSONString(result));
		} catch (Exception e) {
			log.error("【{}】接口响应参数打印失败！", Thread.currentThread().toString());
		}
	}

	/**
	 * 获取joinPoint 里面的参数信息，转换为String
	 *
	 * @param joinPoint 切点
	 * @return 结果
	 */
	public static String getJoinPointArgs(JoinPoint joinPoint) {
		StringBuilder param = new StringBuilder();
		try {
			for (int i = 0; i < joinPoint.getArgs().length; i++) {
				String str = null;

				Object arg = joinPoint.getArgs()[i];
				if (arg instanceof ServletRequest) {
					str = "ServletRequest";
				} else if (arg instanceof ServletResponse) {
					str = "ServletResponse";
				} else {
					str = JSON.toJSONString(arg);
				}
				param.append("\n\t\t参数[").append(i + 1).append("]的值为：").append(str);
			}
		} catch (Exception e) {
			log.error("参数读取失败:{}", e);
		}
		return param.toString();
	}
}
