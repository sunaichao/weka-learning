/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

package com.seres.module.data;


public enum MessageEnum {

    /**
     * 系统相关
     */
    NONE("NONE"),
    SUCCESS("成功"),
    NO_SMS_CHANNEL("该验证码通道不存在"),
    NOT_SUPPORT_FUNCTION("功能不支持"),
    INTERNAL_ERROR("系统繁忙，请稍后再试"),
    REQUEST_ALL_SUBMIT("请输入所有的必填字段!"),
    AT_LEAST_ONE_PARAMETER("至少输入一个参数!"),
    NO_VALUE_CHANGED("没有字段被更改"),
    LOGIN_FORBID("不支持此登录方式"),
    ENTRY_NOT_EXIST("数据不存在"),
    ENTRY_EXIST("数据已经存在！"),
    PRIORITY_REPETITION("优先级重复"),
    INSERT_FAILED("插入失败!"),
    ERROR_PARAM("参数错误！"),
    INSUFFICIENT_PERMISSIONS("权限不足!"),
    CANNOT_LOGIN("用户无法登录!"),
    CANNOT_DELETE("无法删除!"),
    REDIS_OPS_ERROR("Redis 操作异常!");

    private String message;

    public String getMessage() {
        return message;
    }

    MessageEnum(String message) {
        this.message = message;
    }

}
