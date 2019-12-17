package com.it.cs.study.thread.controller.Thread;

/**
 * @Description VolatileNoAtomic 修饰不具有原子性（不具有同步性）
 * @Author cuishuai
 * @Date 2019/12/17 10:49
 */


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 问题
 * 1.AtomicInteger  java并发包
 * 2.仅靠Volatile不能保证线程的安全性（原子性）
 *   Volatile轻量级 只能修饰变量  suncyronized重量级 还可以修饰方法
 *   Volatile 只能保证数据的可见性 不能用来同步 因为多个线程并发访问Volatile修饰的变量不会阻塞
 *   suncyronized 不仅保证可见性 还可以保证原子性
 * 3.线程安全问题 包括两个方面 1  可见性  2  原子性
 */
class VolatileNoAtomic extends Thread{
    //private static volatile int count = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //count++;
            atomicInteger.incrementAndGet();//count++
        }
        System.out.println(getName() + "=====================" + atomicInteger);
    }
}
public class VolatileNoAtomicDemo {

    public static void main(String[] args) {
        VolatileNoAtomic[] volatileNoAtomic = new VolatileNoAtomic[10];
        for (int i = 0; i < volatileNoAtomic.length; i++) {
            //创建每一个线程
            volatileNoAtomic[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < volatileNoAtomic.length; i++) {
            //启动每一个线程
            volatileNoAtomic[i].start();
        }
    }
}
