package com.it.cs.study.thread.controller.Thread;

/**
 * @Description 多线程之间实现同步
 * @Author cuishuai
 * @Date 2019/12/11 17:23
 */

/**
 * 问题
 * 1.线程安全
 *   1）什么是线程安全：当多个线程同时共享，同一个全局变量或者静态变量，做写的操作时，可能会发生数据冲突问题，也就是线程安全问题。做读操作是不会发生数据冲突问题
 * 2.synchronized 用法  使用 注意问题  只包括可能出现线程安全问题的代码  不要包含全部的代码  会变成单线程结果
 *
 * 3.多线程死锁
 *   1)什么是死锁
 *     数据库死锁
 *     线程死锁
 *     行锁
 *     表锁
 *     同步中嵌套同步，导致锁无法释放
 * 4.线程安全怎么解决
 *   1）使用synchronized
 *      1.1 同步代码块 将可能会发生线程安全的问题 给包括起来  synchronized (同一个数据)  包裹起来的代码 只能让当前一个线程进行执行
 *      1.2 同步函数
 *      1.3 静态同步函数
 *   2）jdk1.5 并发包  lock
 *
 * 5.分布式 不能用  synchronized 关键字解决线程安全问题
 * 6.同步函数 使用this锁
 * 7.静态同步函数 用的锁 不是this锁
 * 8.static 关键字：如果修饰的方法  类名.方法 不在是一个 实例了  当class文件也是字节码文件被加载时，才会被初始化 static  一般在方法区 永久区 不会被修改的
 * 使用的锁 类.class  当前线程类
 */

/**
 * Synchronized
 */
class ThreadTrainSynchronized implements Runnable{

    private int count = 100;
    private Object oj = new Object();
    @Override
    public void run() {
        while (count > 0){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (oj){
                if(count > 0){
                    System.out.println(Thread.currentThread().getName() + "," + "出售第" + (100 - count + 1) + "张票");
                    count--;
                }
            }

        }
    }
}


/**
 * 同步函数
 */
class ThreadTrainTbHanShuSynchronized implements Runnable{

    private int count = 100;
    @Override
    public void run() {
        while (count > 0) {
            show();
        }

    }

    public synchronized void show(){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count > 0){
                System.out.println(Thread.currentThread().getName() + "," + "出售第" + (100 - count + 1) + "张票");
                count--;
            }
        }
}

/**
 *静态同步函数
 */

class ThreadTrainTbHanShuJingTaiSynchronized implements Runnable{

    private static int count = 100;
    @Override
    public void run() {
        while (count > 0) {
            show();
        }

    }

    public static synchronized void show(){
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(count > 0){
            System.out.println(Thread.currentThread().getName() + "," + "出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }
}


public class ThreadSafeController {

    public static void main(String[] args) {
        /**
         * Synchronized
         */
        /*ThreadTrainSynchronized threadTrain = new ThreadTrainSynchronized();
        Thread thread1 = new Thread(threadTrain);
        Thread thread2 = new Thread(threadTrain);
        thread1.start();
        thread2.start();*/

        /**
         * 同步函数
         */
        /*ThreadTrainTbHanShuSynchronized threadTrainTbHanShuSynchronized = new ThreadTrainTbHanShuSynchronized();
        Thread thread1 = new Thread(threadTrainTbHanShuSynchronized);
        Thread thread2 = new Thread(threadTrainTbHanShuSynchronized);
        thread1.start();
        thread2.start();*/
        /**
         * 静态同步函数
         */
        ThreadTrainTbHanShuJingTaiSynchronized threadTrainTbHanShuSynchronized = new ThreadTrainTbHanShuJingTaiSynchronized();
        Thread thread1 = new Thread(threadTrainTbHanShuSynchronized);
        Thread thread2 = new Thread(threadTrainTbHanShuSynchronized);
        thread1.start();
        thread2.start();
    }
}
