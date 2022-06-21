package com.seres.module.jackson.config;

import lombok.Data;


@Data
public class DictConfig {
    /**
     * 字典值code
     */
    private String  entryValue;
    /**
     * 字典值text
     */
    private String  entryMeaning;
    /**
     * 扩展字段1
     */
    private String  extendField1;
    /**
     * 扩展字段2
     */
    private String  extendField2;
    /**
     * 扩展字典3
     */
    private String  extendField3;

}
