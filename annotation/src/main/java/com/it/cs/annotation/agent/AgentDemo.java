package com.it.cs.annotation.agent;

/**
 * @Description 代理设计模式
 * @Author cuishuai
 * @Date 2019/12/20 10:29
 */

/**
 * 什么是代理设计模式: 中介 通过代理控制对象得访问 可以详细访问某个对象得方法  在这个方法调用处理 或调用后处理  即aop实现
 *
 * springAop 里面有 前置通知：方法之前通知 和后置通知：方法之后通知  打印日志  权限判断(控制层中打印请求响应)
 *
 * springAop 优点 可以控制安全性
 *
 * 代理分类： 静态代理 ：    静态代理需要自己去实现代理类
 *          动态代理 ：    jdk动态代理 cgkib  jdk动态代理  通过反射机制实现 执行效率不高
 *                       cglib区别： asm框架实现  执行效率高 asm其实就是java字节码控制
 */
public class AgentDemo {
}
