package com.it.cs.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 静态资源和动态资源区别
 *   静态资源就是源代码不会发生改变
 *   动态资源 代码随时发生改变
 *
 * Servlet  其实就是动态资源开发技术 （java）
 */
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
