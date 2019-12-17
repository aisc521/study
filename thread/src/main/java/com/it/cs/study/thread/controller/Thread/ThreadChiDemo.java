package com.it.cs.study.thread.controller.Thread;

/**
 * @Description 线程池
 * @Author cuishuai
 * @Date 2019/12/17 16:36
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 问题:
 * 1.线程池作用:
 * 2.为什么使用线程池   通过线程池来管理线程 因为启动加载停止一个线程非常耗资源 所以将线程交给线程池来管理  能够节约内存 一般在企业开发当中都使用线程池  spring整合线程池  异步注解
 * 3.jdk1.5并发包 Executors
 * 4.线程池为无限大  当执行第二个任务时 第一个任务已经完成  会重复执行第一个任务的线程 而不会重新创建线程
 *
 */
public class ThreadChiDemo {
    public static void main(String[] args) {
      /*  //创建可缓存线程池 用的最多的
        ExecutorService executors = Executors.newCachedThreadPool();
        //表示创建了线程 类似start
        for (int i = 0; i < 10; i++) {
            int index = i;
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "=====" + index);
                    if(index == 9){
                        //关闭线程池
                        executors.shutdown();
                    }
                }
            });
        }
*/


        /**
         * 创建 固定长度线程池  每次最多只能执行 三个 其他线程在等待执行
         */
        /*ExecutorService executors1  = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            executors1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "=====" + index);
                    if(index == 9){
                        //关闭线程池
                        executors1.shutdown();
                    }
                }
            });
        }*/

        /**
         * 做定时的线程池  执行定时任务线程池
         */
      /*  ScheduledExecutorService executors2  = Executors.newScheduledThreadPool(5);
            executors2.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是3秒钟之后执行.................");
                }
            },3, TimeUnit.SECONDS);*/
        /**
         * 单线程池  其实就是单线程
         */
        ExecutorService executors3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executors3.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "=====" + index);
                    if(index == 9){
                        //关闭线程池
                        executors3.shutdown();
                    }
                }
            });
        }
    }
}
