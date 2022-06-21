package com.seres.module.annotation;

import com.seres.module.aspect.LogHttpRequestParamAspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({LogHttpRequestParamAspect.class})
@EnableAspectJAutoProxy
public @interface EnableParamLog {
}
