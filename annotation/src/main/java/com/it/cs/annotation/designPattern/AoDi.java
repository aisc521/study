package com.it.cs.annotation.designPattern;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/19 17:11
 */
public class AoDi implements Car {
    @Override
    public void run() {
        System.out.println("我是奥迪");
    }
}
