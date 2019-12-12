package com.it.cs.study.thread.controller;

/**
 * 继承Thread
 */
class CreateThread extends Thread{
    @Override
    public void run() {
        /*
        主要操作：执行 需要线程执行的任务,代码。
         */
        for(int i = 0; i < 100; i++){
            System.out.println("run() i:" + i);
        }

    }
}

/**
 * 实现Runnable 接口 重写run方法
 */
class createRunnable implements Runnable{

    @Override
    public void run() {
        /*
        需要执行的任务，代码
         */
        for(int i = 0; i < 200; i++){
            System.out.println("RunnableRun() i:" + i);
        }
    }
}
/**
 * sleep  run方法里面不能直接 抛出异常 只能try catch
 */
class sleepThread extends Thread{
    @Override
    public void run() {
        /*
        主要操作：执行 需要线程执行的任务,代码。
         */
        for(int i = 0; i < 10; i++){

            //里面传的是毫秒数
            try {
                Thread.sleep(1000);
                Long  threadId = getId();//获取线程的ID  ID是多线程随机进行分配不重复的主键
                System.out.println("Thread.getId:" + threadId);
                //获取线程名称
                String thraedName = getName();
                System.out.println("Thread.getName:" + thraedName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i:" + i);

        }

    }
}
class sleepThread1 implements Runnable{

    @Override
    public void run() {
   /*
        主要操作：执行 需要线程执行的任务,代码。
         */
        for(int i = 0; i < 10; i++){

            //里面传的是毫秒数
            try {
                Thread.sleep(1000);
                Long  threadId = Thread.currentThread().getId();//获取线程的ID  ID是多线程随机进行分配不重复的主键
                System.out.println("Thread.getId:" + threadId);
                //获取线程名称
                //currentThread 获取当前线程对象
                String thraedName = Thread.currentThread().getName();
                System.out.println("Thread.getName:" + thraedName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i:" + i);

        }
    }
}


/**
 * @Description 创建多线程  多线程基础知识
 * @Author cuishuai
 * @Date 2019/12/11 11:39
 */

/**
 * 创建线程 三种方式
 * 1.继承Thread类 创建线程
 * 2.实现Runnable 接口 重写run方法
 * 3.使用匿名内部类方式
 */
/**
 * 问题
 * 1.为什么 启动一个线程 调用 star方法 不调用 run方法 调用  run方法 相当于 还是在主线程执行的
 * 2.方法1  抛出异常  挂了   方法2  不会 出问题 单个线程 挂了 不会影响到其他线程
 * 3.注意 使用多线程情况 代码不会从上往下进行执行 ，会同时并行执行
 * 4.使用 继承Thread类 还是 使用 实现Runnable 接口 创建线程好？  实现Runnable接口较好  原因实现了接口还可以继续继承 继承了类不能在继承
 * 5.线程中怎么处理捕获异常   run方法中 不能直接抛出异常 只能  try catch
 * 6.sleep作用： 让当前线程从运行状态 变为休眠状态  如果时间到期了 又会变成运行状态  线程并没有死 没有停掉
 * 7.sleep 不能释放锁（多线程之间实现同步） wait 可以释放锁
 * 8.多线程运行状态
 *   1）新建状态  没有 start 只是 new 了
 *   2）就绪状态  启动了  start  等待cpu分配 调用了 start 不一定 运行
 *   3）阻塞状态  调用 sleep方法/线程调用一个在I/O上被阻塞的操作，即改操作在输入输出操作完成之前不会返回到它的调用者/线程试图得到一个锁，而该锁正在被其他线程持有/线程在等待某个触发条件
 *   4）运行状态  线程 在执行 run方法
 *   5）死亡状态  run方法 代码走完了 线程就会被停止掉  或者  调用 stop方法 也会停止/一个未捕获的异常终止了run方法 使得线程猝死
 * 9.什么是进程： 进程就是一个应用程序，进程是所有线程的集合
 * 10.什么是线程： 线程其实就是一条执行路径
 * 11.main  是主线程  如果是自己创建的线程 是子线程
 * 12.gc线程 ： 垃圾回收机制  专门回收垃圾
 */
public class ThreadChildrenController {
    public static void main(String[] args) {
        /**
         * 继承Thread类创建线程
         */
        //=============================================================================================================
       /* System.out.println("创建线程开始");
        CreateThread createThread = new CreateThread();
        createThread.start();
        System.out.println("线程已经开始启动 main");
        for(int i = 0; i < 100; i++){
            System.out.println("main() i:" + i);
        }*/
        /**
         *实现Runnable 接口创建线程
         */
       //==============================================================================================================
        /*System.out.println("创建线程开始");
        createRunnable createThread = new createRunnable();
        Thread thread = new Thread(createThread);
        thread.start();
        System.out.println("线程已经开始启动 main");
        for(int i = 0; i < 200; i++){
            System.out.println("main() i:" + i);
        }*/
        /**
         * 使用匿名内部类 创建线程
         */
        //=============================================================================================================
        /*System.out.println("创建线程成功");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.println("run() i:" + i);
                }
            }
        }).start();
        System.out.println("创建线程结束");
        //thread.start();
        for(int i = 0; i < 100; i++){
            System.out.println("main() i:" + i);
        }*/
        //=============================================================================================================
        /**
         * 获取线程对象 已经名称  属性 常用线程api
         */
        //sleep
        //new sleepThread().start();
        //自定义线程名称
        /*sleepThread sleepThread = new sleepThread();
        sleepThread.setName("线程1");
        sleepThread.start();*/
        //获取当前线程对象
        sleepThread1 sleepThread1 = new sleepThread1();
        new Thread(sleepThread1).start();
    }
}
