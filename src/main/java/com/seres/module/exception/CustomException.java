package com.seres.module.exception;

import lombok.Data;


@Data
public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 5904162846209394137L;

    /**
     * 异常状态码
     */
    private String code;

    /**
     * 异常信息
     */
    private String msg;

    public CustomException(String message) {
        super(message);
        this.msg = message;
    }

    public CustomException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }
}
