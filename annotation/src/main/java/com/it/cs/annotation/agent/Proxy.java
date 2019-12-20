package com.it.cs.annotation.agent;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/20 10:43
 */

/**
 * 中介
 */
public class Proxy implements House{

    private XiaoMing xiaoMing;
    public Proxy(XiaoMing xiaoMing){
        this.xiaoMing = xiaoMing;
    }
    @Override
    public void mai() {
        System.out.println("我是中介,你买房得操作我开始监听了!!!!!!!!!");
        xiaoMing.mai();
        System.out.println("我是中介,你买房得操作我结束监听了!!!!!!!!!");

    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new XiaoMing());
        proxy.mai();
    }
}
