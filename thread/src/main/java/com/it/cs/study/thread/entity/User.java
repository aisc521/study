package com.it.cs.study.thread.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/18 9:59
 */
@Data
public class User {
    private String userId;
    private String userName;
    public User(){
        System.out.println("使用反射技术，执行午餐参数构造函数");
    }
    public User(String userId){
        System.out.println("userId:" + userId);
    }
}
