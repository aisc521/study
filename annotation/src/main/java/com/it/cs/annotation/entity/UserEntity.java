package com.it.cs.annotation.entity;

/**
 * @Description
 * @Author cuishuai
 * @Date 2019/12/19 13:58
 */

import java.util.ArrayList;
import java.util.Date;

/**
 * 任何类的父类是  Object类
 * object类中有那些方法
 */
public class UserEntity extends Object{
    //@Override  标识 子类重写父类  校验 检查
    @Override
    public String toString() {
        return super.toString();
    }

    //@Deprecated   过时的 标识

    @Deprecated
    public  static void add(){
    }

    public static void main(String[] args) {
        add();
        //@SuppressWarnings("rawtypes")消除警告
        //@SuppressWarnings("all")去除全部警告
        ArrayList arrayList = new ArrayList();
    }
}
