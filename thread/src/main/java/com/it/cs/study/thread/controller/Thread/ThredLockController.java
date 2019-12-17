package com.it.cs.study.thread.controller.Thread;

/**
 * @Description Lock锁
 * @Author cuishuai
 * @Date 2019/12/16 10:16
 */

/**
 * 问题
 * 1.synchronized  线程安全的缺点：不能手动的开锁 和 解锁
 * 2.并发包  jdk1.5以后 ： lock \线程池框架Executor  \Condition
 * 3.企业实际中 怎么停止线程 线程池管理
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源
 */
class ResLock {
    public String name;
    public String sex;
    //flag true表示 out线程未读取值
    public boolean flag = false;
    public Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
}
/**
 * 写入线程
 */
class InputThreadLock extends Thread{
    public ResLock res;
    public  InputThreadLock(ResLock res){
        this.res = res;
    }
    @Override
    public void run() {
        int count = 0;
        while (true){
            //获取锁的资源
            try {
                res.lock.lock();
                if(res.flag){
                    try {
                        res.condition.await();
                    } catch (InterruptedException e) {
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
                res.condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }


        }
    }
}

/**
 * 读取线程
 */
class OutThreadLock extends Thread{
    public ResLock res;
    public  OutThreadLock(ResLock res){
        this.res = res;
    }
    @Override
    public void run() {
        while (true){
            try {
                res.lock.lock();
                if(!res.flag){
                    res.condition.await();
                }
                System.out.println(res.name + "======================" + res.sex);
                res.flag = false;
                res.condition.signal();


            }catch (Exception e){
                e.printStackTrace();
            }finally {
                res.lock.unlock();
            }



        }
    }
}
public class ThredLockController {

    public static void main(String[] args) {
        ResLock res = new ResLock();
        InputThreadLock inputThread = new InputThreadLock(res);
        OutThreadLock outThread = new OutThreadLock(res);
        inputThread.start();
        outThread.start();
    }

}
