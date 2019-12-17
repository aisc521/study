package com.it.cs.study.thread.controller.Thread;

/**
 * @Description 守护线程
 * @Author cuishuai
 * @Date 2019/12/16 11:46
 */

/**
 * 问题
 * 1.java中有两种线程 一种是用户线程  一种是守护线程 当进程不存在或者主线程被停止 守护线程也回被停止 使用setDaemon(true)方法 设置值为守护线程
 * 2.什么是用户线程 ：前台线程  主线程
 * 3.什么是守护线程 ：后台线程  主线程或jvm挂了  守护线程也回被停止掉 gc也是守护线程
 * 4.多线程之间不受影响  多个不同执行路径 大多数情况 主线程先执行完  子线程后执行完
 */
public class GuardThreadController {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println("我是子线程:" + i);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 30; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是主线程:" + i);
        }
        System.out.println("主线程执行完毕=================");
    }
}
