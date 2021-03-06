package com.it.cs.study.thread.controller.Thread;

/**
 * @Description java 内存模型
 * @Author cuishuai
 * @Date 2019/12/16 14:10
 */

/**
 * 问题
 * 1.线程的三大特性
 *   1）原子性：即一个操作活者多个操作，要不全部执行并且执行的过程中不会被任何因素打算，要么就都不执行（转账例子） --其实就是保证数据的一致性 数据安全的一部分
 *   2）可见性：当多个线程当问同一个变量时，一个线程修改了这个变量的值 其他线程能够立即看到修改的值
 *            若两个线程在不同的cpu 那么线程1改变了i的值还每刷新到主存，线程2又使用了i，那么这个i值肯定还是之前的，线程1对变量的修改线程没看到这就是可见性问题
 *   3）有序性：程序执行的顺序按照代码的先后顺序执行
 *
 * 2.java内存模型（JMM）
 *   1）堆、栈、方法区 不是Java内存模型  是jvm的内存结构
 *   2）内存模型是关于多线程相关的
 *   3）内存模型简称jmm jmm决定一个线程对共享变量的写入时，能对另一个线程可见。从抽象的角度看，jmm定义了线程和主内存之间的抽象关系，线程之间的共享变量存储在主内存中
 *      每一个线程都有一个私有的本地内存，本地内存中存储了该线程以读/写共享变量副本。本地内存是jmm的一个抽象概念，并不真实存在。它涵盖了缓存，写缓冲区，
 *      寄存器以及其他的硬件和编译器优化
 *    总结：什么是java内存模型 java内存模型简称jmm 定义了一个线程对另一个线程可见，共享变量存在主内存中，每个线程都有自己本地内存，当多个线程同事访问一个数据的时候。
 *         可能本地内存没有即时刷新到主内存，所以就会发生线程安全问题。
 *
 */
public class ThreadDemo {
}
