package com.it.cs.annotation.Controller;

import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 定义注解 使用  @interface
 * @Retention  表示允许反射获取信息
 * @Target  定义注解使用范围
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationTest {
    //传入的值
    String value() default "";
    int classId() default 0;
    String[] array();
}


class AnnDemo{
    private String name;
    @AnnotationTest(value = "崔帅自学",classId = 1,array = {"11","22"})
    public void add(){

    }
}

