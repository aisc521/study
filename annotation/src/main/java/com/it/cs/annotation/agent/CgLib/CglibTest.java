package com.it.cs.annotation.agent.CgLib;

import com.it.cs.annotation.agent.House;
import com.it.cs.annotation.agent.XiaoMing;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import javax.jws.Oneway;
import java.lang.reflect.Method;

/**
 * @Description cglib
 * @Author cuishuai
 * @Date 2019/12/20 10:59
 */
public class CglibTest implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] arr, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是房产中介，使用动态代理技术开始监听你了");
        Object o1 = methodProxy.invokeSuper(o,arr);
        System.out.println("我是房产中介，使用动态代理技术结束监听你了");
        return o1;
    }

    public static void main(String[] args) {
        CglibTest cglibTest = new CglibTest();
        //使用asm框架 生成代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoMing.class);
        enhancer.setCallback(cglibTest);
        House create = (House) enhancer.create();
        create.mai();
    }
}
