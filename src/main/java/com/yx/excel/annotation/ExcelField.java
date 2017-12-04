package com.yx.excel.annotation;

import java.lang.annotation.*;

/**
 * 列属性信息
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelField {

    /**
     * 列名称
     *
     * @return
     */
    String name() default "";

}
