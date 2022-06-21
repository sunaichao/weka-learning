/*
 *  Copyright (C) HAND Enterprise Solutions Company Ltd.
 *  All Rights Reserved
 */

package com.seres.module.data;

import lombok.Data;

import javax.validation.Valid;


@Data
public class PageRequestData<T> {

    /**
     * 页大小
     */
    private int pageSize = 10;
    /**
     * 当前页
     */
    private int current = 0;

    /**
     * 具体参数
     */
    @Valid
    private T params;
}
