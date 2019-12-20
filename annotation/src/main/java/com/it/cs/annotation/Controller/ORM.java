package com.it.cs.annotation.Controller;

/**
 * @Description orm框架 对象关系映射
 * @Author cuishuai
 * @Date 2019/12/19 14:33
 */

import com.it.cs.annotation.annotation.SetProperty;
import com.it.cs.annotation.annotation.SetTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 */
public class ORM {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.项目中使用注解  肯定会使用到反射  反射应用场景 jdbc  springIoc  常用框架 一些注解实现

       Class<?> forName =  Class.forName("com.it.cs.annotation.entity.UserEntityAnn");
       //getAnnotations() 当前该类上用到了哪些注解
        Annotation[] annotations = forName.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
        Field[] fields = forName.getDeclaredFields();//拿到属性数组
        StringBuffer sf = new StringBuffer();
        sf.append(" select ");
        for(int i = 0; i < fields.length; i++){
            SetProperty setProperty = fields[i].getAnnotation(SetProperty.class);
            String pro = setProperty.name();
            System.out.println(pro);
            sf.append(pro);
            if(i == fields.length - 1){
                sf.append(" from ");
            }else{
                sf.append(" , ");
            }
        }
        //获取某个注解对象
        SetTable setTable = forName.getAnnotation(SetTable.class);
        //表名称
        String tableName = setTable.value();
        sf.append(" " + tableName);
        System.out.println(setTable.value());

        //生成orm框架 sql语句
        System.out.println("sql:" + sf.toString());
    }
}
