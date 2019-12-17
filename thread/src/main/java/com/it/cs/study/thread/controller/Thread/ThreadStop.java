package com.it.cs.study.thread.controller.Thread;

/**
 * @Description 停止线程
 * @Author cuishuai
 * @Date 2019/12/16 11:18
 */
class stopThread extends Thread{
    //flag 未true 表示线程开始
    public  boolean flag = true;
    @Override
    public synchronized void run() {
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                stopThread();
            }
            System.out.println(Thread.currentThread().getName() + "我是子线程");
        }
    }
    public void stopThread(){

        flag = false;
        System.out.println(getName() + "被停止");
    }
}
public class ThreadStop {
    public static void main(String[] args) {
        stopThread stopThread = new stopThread();
        stopThread stopThread2 = new stopThread();
        stopThread.start();
        stopThread2.start();
        for(int i = 0; i < 30; i++){
            try {
                Thread.sleep(10);
            }catch (Exception e){

            }
            System.out.println("main.......-" + i);
            if(i == 29){
                /*stopThread.stopThread();
                stopThread2.stopThread();*/
                stopThread.interrupt();
                stopThread2.interrupt();
            }
        }

    }
}
