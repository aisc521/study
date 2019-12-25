package com.it.cs.servlet.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Description 转发不暴露真实地址 转发主要在tomcat内部跳转 重定向 返回客户端302请求request 也会被丢失掉 重定向地址发生改变 而且转发作用域的值全部失效 所以重定向效率低
 * @Author cuishuai
 * @Date 2019/12/20 16:29
 */
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("我是动态资源,Date:" + new Date());
    }
}
