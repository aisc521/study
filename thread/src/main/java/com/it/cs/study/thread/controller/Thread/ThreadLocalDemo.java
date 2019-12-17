package com.it.cs.study.thread.controller.Thread;

/**
 * @Description threadLocal  本地线程
 * @Author cuishuai
 * @Date 2019/12/17 16:08
 */

/**
 * 问题
 * 1.  ThreadLocal 提高一个线程的 局部变量  访问某个线程拥有自己的局部变量
 * 2. set()设置当前线程的线程局部变量的值
 *    get()获取当前现所对应的线程局部变量的值
 *    remove()将当前局部变量的值删除
 *    initialValue()返回该线程局部变量的初始值
 *
 *
 * 3.ThreadLocal底层实现原理
 *   通过map集合  map.put("当前线程","值")
 */

/**
 * 创建三个线程 每个线程生成自己独立的序列号
 */

//生成订单号
class ResNo {
  /*  private int count = 0;*/
    /**
     * 设置本地局部变量 和其他线程局部变量分开 互不影响
     */
  private ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
      @Override
      protected Integer initialValue() {
          //设置当前线程局部变量的初始化值
          return 0;
      }
  };
    public int getNumber() {
        Integer count = this.count.get() + 1;
        this.count.set(count);
        return count;
    }
}

class threadLocalThread extends  Thread{
    private ResNo resNo;
    public threadLocalThread(ResNo resNo){
        this.resNo = resNo;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "----i-" + i + "number:" + resNo.getNumber());
        }
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ResNo resNo = new ResNo();
        threadLocalThread t1  = new threadLocalThread(resNo);
        threadLocalThread t2  = new threadLocalThread(resNo);
        threadLocalThread t3  = new threadLocalThread(resNo);
        t1.start();
        t2.start();
        t3.start();
    }

}
