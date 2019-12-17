package com.it.cs.study.thread.controller.Thread;

/**
 * @Description volatile
 * @Author cuishuai
 * @Date 2019/12/17 9:35
 */

import java.lang.Thread;

/**
 * 问题
 * 1.volatile 关键字的作用是变量在多个线程之间可见  ====  把结果 马上刷新到 主内存中去  但是不能解决并发问题的
 * 2.volatile非原子性  ： 不能保证数据的原子性
 */
class ThreadVolatileDemo extends Thread{
    public volatile boolean flag = true;
    @Override
    public void run() {
        System.out.println("子线程开始...");
        while (flag){
           //System.out.println("循环");
        }
        System.out.println("子线程结束...");
    }
    public void isRun(boolean flag){
        this.flag = flag;
    }
}
public class ThreadVolatile {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(300);
        System.out.println("");
        threadVolatileDemo.isRun(false);
        System.out.println("flag:" + threadVolatileDemo.flag);
    }
}
