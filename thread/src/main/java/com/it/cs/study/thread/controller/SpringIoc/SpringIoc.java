package com.it.cs.study.thread.controller.SpringIoc;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/18 10:50
 */

/**
 * 什么是 Spring: 把每个bean和bean之间的关系 都交给了 第三方容器(Spring)管理  我们使用spring的时候 对象不需要new。原理就是反射+ dom4j
 *
 *
 * spring加载过程  或者 springioc实现原理
 * 1.读取xml配置文件
 * 2.获取到每个bean配置  获取class地址
 * 3.拿到class地址 进行反射实例化对象，使用反射api 为私有属性赋值
 */
public class SpringIoc {
}
