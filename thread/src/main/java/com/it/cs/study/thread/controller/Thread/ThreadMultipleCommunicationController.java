package com.it.cs.study.thread.controller.Thread;

/**
 * @Description 多线程之间通讯
 * @Author cuishuai
 * @Date 2019/12/12 10:23
 */

/**
 * 共享资源
 */
class Res {
    public String name;
    public String sex;
    //flag true表示 out线程未读取值
    public boolean flag = false;
}

/**
 * 写入线程
 */
class InputThread extends Thread{
    public Res res;
    public  InputThread(Res res){
        this.res = res;
    }
    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (res){
                if(res.flag){
                    //等于true  已经赋完值 还没有取
                    try{
                        //当前线程等待，  当前线程 从运行状态变成 休眠状态 类似于sleep  wait是使用在多线程之间同步得 和synchronized 一起使用   wait可以释放锁 sleep不能释放锁
                        res.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(count == 0){
                    res.name = "崔帅";
                    res.sex = "男";
                }else{
                    res.name = "小红";
                    res.sex = "女";
                }
                //实现奇数和偶数
                count = (count + 1) % 2;
                res.flag = true;
                //wait一起使用 唤醒 另一个线程  从 阻塞状态变成运行状态
                res.notify();
            }
        }
    }
}

/**
 * 读取线程
 */
class OutThread extends Thread{
    public Res res;
    public  OutThread(Res res){
        this.res = res;
    }
    @Override
    public void run() {
        while (true){
            synchronized (res){
                if(!res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + "======================" + res.sex);
                res.flag = false;
                //唤醒线程
                res.notify();
            }
        }
    }
}
/**
 * 问题
 *
 * 什么是多线程之间通讯？：多线程之间通讯 就是多个线程在操作同一个资源，但是操作的动作不同
 *
 * 1.wait
 *
 * 2.notify
 *
 * 3.notifyAll
 */
public class ThreadMultipleCommunicationController {
    public static void main(String[] args) {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutThread outThread = new OutThread(res);
        inputThread.start();
        outThread.start();
    }

}
