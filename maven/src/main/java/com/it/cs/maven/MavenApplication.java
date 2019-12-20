package com.it.cs.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * mavem :跨平台项目管理工具
 * jdk1.6以上 才能用maven
 * maven -v 检查maven 是否安装成功
 * 
 *
 */
@SpringBootApplication
public class MavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenApplication.class, args);
	}

}
