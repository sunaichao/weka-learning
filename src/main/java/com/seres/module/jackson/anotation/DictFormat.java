package com.seres.module.jackson.anotation;

import java.lang.annotation.*;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictFormat {

    /**
     * 字典名称编码, 默认为当前属性的名称
     */
    String dictKey() default "";

    /**
     * 新的目标属性，默认为 原始属性名称+"Name"
     */
    String targetFiled() default "";

    /**
     * 是否需要扩展字段，默认不需要
     */
    boolean requiredExtend() default false;

    /**
     * 扩展属性1
     */
    String extendFiled1() default "extendFiled1";

    /**
     * 扩展属性2
     */
    String extendFiled2() default "extendFiled2";

    /**
     * 扩展属性3
     */
    String extendFiled3() default "extendFiled3";

    /**
     * 默认值，当值是转换后的值是null的时候显示的默认值
     */
    String defaultNullValue() default "";
}
