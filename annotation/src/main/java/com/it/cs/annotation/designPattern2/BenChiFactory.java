package com.it.cs.annotation.designPattern2;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/19 17:23
 */
public class BenChiFactory {
    public static Car createCar(){
        return new BenChi();
    }
}
