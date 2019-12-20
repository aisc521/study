package com.it.cs.annotation.designPattern2;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/19 17:22
 */

/**
 * 奥迪工厂
 */
public class AoDiFactory {
    public static Car creat(){
        return new AoDi();
    }
}
