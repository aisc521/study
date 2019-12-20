package com.it.cs.annotation.designPattern2;

/**
 * @Description 设计模式
 * @Author cuishuai
 * @Date 2019/12/19 15:45
 */

/**
 * 设计模式
 * 1.为什么要用到设计模式：提高代码的复用 代码健壮性 面向对象
 * 代理：请求响应  代理设计模式 打印日志
 * 工厂 ：负责初始化一些bean
 * 模板方法：baseController 重载方法
 * 观察者： 事件监听
 * 单例：****
 * 策略设计模式
 * 设计模式 一共有23种
 *
 * 2.单例模式：
 * new User() 会在堆内存中有一个内存地址
 * 什么是单例：单证在一个jvm当中只能有一个实例（不是在多个jvm中）
 * 单例其实有7中写法  面试只需要 懒汉式 饿汉式
 * 懒汉式和饿汉式区别：
 *    懒汉式 线程不安全
 *    饿汉式 天生线程安全 当class文件被加载的时候 被初始化
 */

/**
 *单例 懒汉式
 */
class Singleton{
    private static Singleton singleton;
    /**
     * 反射也不能初始化了
     */
    private Singleton(){

    }
    /**
     * 懒汉式 当你需要的时候 我才会被实例化 之后都是用一个实例
     * 懒汉式线程不安全 所以要加上 同步synchronized
     * @return
     */
    public static Singleton getSingleton(){
        //
        if(singleton == null){
            synchronized(Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

/**
 * 单例 饿汉式
 * 是当class文件被加载的时候 就会被初始化  天生安全
 *
 */
class Singleton1{
    //finall 初始化一次不能被更改
    private static  final Singleton1 singleton1 = new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getSingleton1(){
        return singleton1;
    }
}


/**
 * 懒汉式 当你需要的时候 才会初始化 之后都是用同一个实例（）
 * 饿汉式 当class 文件加载的时候就会被 初始化
 * 相比来说 懒汉式 节约内存 但是懒汉式 线程不安全  代码执行效率低  因为加了同步synchronized
 */
public class DesignDemo {
    /**
     * 单例设计模式
     * 懒汉式
     */
    public static void main(String[] args) {
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        System.out.println(s1 = s2);


        Singleton1 s3 = Singleton1.getSingleton1();
    }

}
