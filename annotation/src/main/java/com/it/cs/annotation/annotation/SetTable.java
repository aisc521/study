package com.it.cs.annotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description 表的别名
 * @Author cuishuai
 * @Date 2019/12/19 14:37
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
    String value();
}

