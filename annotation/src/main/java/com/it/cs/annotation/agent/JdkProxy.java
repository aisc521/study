package com.it.cs.annotation.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description jdk动态代理类
 * @Author cuishuai
 * @Date 2019/12/20 10:49
 */
public class JdkProxy implements InvocationHandler{
    public Object target;
    public JdkProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是房产中介....开始使用jdk动态代理，开始监听");
        Object in = method.invoke(target,args);
        System.out.println("我是房产中介....开始使用jdk动态代理，结束监听");
        return in;
    }

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        JdkProxy jdkProxy = new JdkProxy(xiaoMing);
        House house = (House) Proxy.newProxyInstance(xiaoMing.getClass().getClassLoader(),xiaoMing.getClass().getInterfaces(),jdkProxy);
        house.mai();
    }
}
