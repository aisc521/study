package com.it.cs.wangluocode.Controller;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/20 11:11
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 1.java socket 就是两个设备之间进行数据交换格式
 * 2.sokcet 分为两种协议  tcp：安全  效率低 面向连接 对方必须 三次握手才可以通讯
 *                    udp：面向无连接  丢包情况  udp不安全 效率高
 * 3.域名和IP地址：如果是域名 通过dns 进行解析
 * 3.网络模型：应用层   http协议
 *           传输层   tcp协议
 *           网络层   ip
 *           链路层   以太网协议
 * 4.http协议其实就是客户端与服务器端的传输协议
 * 5.什么是socket： socket就是为网络服务提供的一种机制
 *                 通讯的两端都有socket
 *                 网络通讯其实就是socket之间的通讯
 *                 数据在两个socket间通过io传输
 * 6.udp: 面向无连接 将数据以及源的封装成数据包中，不需要建立连接
 *        每个数据包的大小限制在64k内
 *        因无连接 是不可靠协议
 *        不需要建立连接速度快
 *   tcp：建立连接 行程传输数据的通道
 *        在连接中进行大数据量传输 以字节流方式
 *        通过三次握手完成连接  是可靠协议
 *        必须建立连接 效率会降低
 *
 *
 *        发送数据之前建立三次握手  握手成功 才发送数据
 *        第一次握手：请求通讯
 *        第二次握手：收到第二次握手 客户端收到服务器端消息
 *        第三次握手：发送确认消息
 *        四次分手:关闭连接 udp ：qq / http协议tcp
 *
 */
public class SocketDemo {
    public static void main(String[] args) throws SocketException {

    }
}
