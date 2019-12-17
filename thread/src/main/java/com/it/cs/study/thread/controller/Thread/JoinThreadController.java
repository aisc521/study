package com.it.cs.study.thread.controller.Thread;

/**
 * @Description join demo
 * @Author cuishuai
 * @Date 2019/12/16 13:55
 */

class joinThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 40; i++){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "----" + i);
        }
    }
}
public class JoinThreadController {
    public static void main(String[] args) throws InterruptedException {
        joinThread joinThread1 = new joinThread();
        joinThread joinThread2 = new joinThread();
        joinThread1.start();
        joinThread1.join();//让其他线程等待 只有当前线程执行完毕 才释放资格
        joinThread2.start();
        for (int i = 0; i < 40; i++) {
            System.out.println("main----" + i);
        }
    }
}

