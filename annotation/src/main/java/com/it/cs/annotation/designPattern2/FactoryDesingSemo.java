package com.it.cs.annotation.designPattern2;

/**
 * @Description 工厂设计模式
 * @Author cuishuai
 * @Date 2019/12/19 17:06
 */


/**
 *
 */
public class FactoryDesingSemo {
    public static void main(String[] args) {
        AoDi aoDi = new AoDi();
        BenChi benChi = new BenChi();
        aoDi.run();
        benChi.run();
        Car car1 = CarFactory.createCar("奥迪");
        Car car2 = CarFactory.createCar("奔驰");
        car1.run();
        car2.run();



        Car aodi = AoDiFactory.creat();
        Car benchi = BenChiFactory.createCar();
        aodi.run();
        benchi.run();
    }
}
