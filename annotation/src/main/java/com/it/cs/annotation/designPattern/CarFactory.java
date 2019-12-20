package com.it.cs.annotation.designPattern;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/19 17:13
 */
public class CarFactory {
    public static Car  createCar(String carType){
        Car car = null;
        switch (carType){
            case "奥迪":
                car = new AoDi();
            break;
            case "奔驰":
                car = new BenChi();
                break;
            default:
                break;
        }
        return car;
    }
}
