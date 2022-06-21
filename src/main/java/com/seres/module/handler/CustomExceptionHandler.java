package com.seres.module.handler;

import com.seres.module.data.MessageEnum;
import com.seres.module.data.ResponseData;
import com.seres.module.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {ResponseStatusException.class})
    public ResponseData<Object> handle(ResponseStatusException ex) {
        log.error("response status exception:{}", ex);
        return ResponseData.fail(MessageEnum.INTERNAL_ERROR);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<Object> handle(RuntimeException ex) {
        log.error("runtime exception:{}", ex);
        return ResponseData.fail(MessageEnum.INTERNAL_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseData<Object> handle(CustomException e) {
        log.error("CustomException exception:{}", e);
        return new ResponseData<>(e.getCode()!=null?e.getCode():"500", e.getMessage(),false);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<Object> handle(Exception ex) {
        log.error("exception:{}", ex);
        return ResponseData.fail(MessageEnum.INTERNAL_ERROR);
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<Object> handle(Throwable throwable) {
        ResponseData<Object> result = new ResponseData<>(false);
        if (throwable instanceof CustomException) {
            result = handle((CustomException) throwable);
        } else if (throwable instanceof RuntimeException) {
            result = handle((RuntimeException) throwable);
        } else if (throwable instanceof ResponseStatusException) {
            result = handle((ResponseStatusException) throwable);
        }else if (throwable instanceof Exception) {
            result = handle((Exception) throwable);
        }
        return result;
    }
}
