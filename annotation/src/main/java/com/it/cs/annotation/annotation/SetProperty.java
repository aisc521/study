package com.it.cs.annotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 属性注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {
    String name();
    int leng();
}
