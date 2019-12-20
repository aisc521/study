package com.it.cs.webrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * web开发入门
 * 软件架构体系：
 *           cs体系：属于桌面应用程序 qq 迅雷 yy
 *                  弊端：需要安装一些软件 维护难 占空间 升级
 *                  优点：速度快体验效果好  占宽带小 减轻服务器端的压力
 *           bs体系：属于网站应用程序 淘宝 腾讯网
 *                  弊端：必须使用浏览器进行访问  兼容性差  服务器压力大 安全性差（抓包）
 *                  优点：不需要安装直接可以访问  不用更新
 * 目前 主流bs体系 移动app 嵌入h5页面 混合开发
 * 什么是服务器：为别人提供服务 其实服务器就是一台pc电脑 如果要将pc电脑做成服务器 配置一定要高 而且内存足
 * 服务器分类：1.数据库服务器 处理数据的服务器 oracle  mysql db2  sqlserver
 *           2.邮件服务器 163  qq alibab 处理邮件操作的服务器
 *           3.web服务器: 安装一些web服务器软件进行运行  tomcat jboss  jetty weblogic
 * web服务器的作用:把本地的数据资源共享到外部访问
 * tomcat 不支持  ejb  和rmi
 *
 *
 *
 * URL:统一资源占位符（路径）http://协议---socket tcp协议
 *                       localhost 本地域名----ip地址127.0.0.1
 *                       /itmayidu/ 项目名称
 *                       index.html  资源名称
 *
 *
 * 什么是DNS 解析 ： 将域名转换成ip地址
 * DNS解析域名过程:使用域名转换IP
 *
 * 浏览器输入地址 先读取本地host文件  如果本地host文件有dns解析配置 先用本地host配置进行解析
 * 如果本地host文件没有解析配置   到当前的你现在用的宽带进行dns解析
 *
 *
 *
 * 外网映射工具：常用的 有 ngrok（免费）  花生壳（收费）
 *
 * 1,下载windows版本的客户端，解压到你喜欢的目录
 2,在命令行下进入到path/to/windows_386/下
 3,执行 ngrok -config=ngrok.cfg -subdomain xxx 80

 //(xxx 是你自定义的域名前缀)
 4,如果开启成功 你就可以使用 xxx.tunnel.qydev.com 来访问你本机的 127.0.0.1:80 的服务啦
 5,如果你自己有顶级域名，想通过自己的域名来访问本机的项目，那么先将自己的顶级域名解析到123.57.165.240(域名需要已备案哦)，然后执行./ngrok -config=ngrok.cfg -hostname xxx.xxx.xxx 80 //(xxx.xxx.xxx是你自定义的顶级域名)
 6，如果开启成功 你就可以使用你的顶级域名来访问你本机的 127.0.0.1:80 的服务啦
 7,如果失败 就加下交流群 反馈下问题 本屌会看看什么原因....吧

 *
 */
@SpringBootApplication
public class WebrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebrmApplication.class, args);
	}

}
