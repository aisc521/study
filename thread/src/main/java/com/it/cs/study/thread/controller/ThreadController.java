package com.it.cs.study.thread.controller;

/**
 * @Description 多线程 分批处理数据
 * @Author cuishuai
 * @Date 2019/12/11 11:33
 */

/**
 * 多线程分批发送数据
 *
 */

import com.it.cs.study.thread.entity.UserEntity;
import com.it.cs.study.thread.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;


class UserThread extends Thread{
    /**
     * 每个线程分批多少数据
     */
    private List<UserEntity> listUser;
    public UserThread(List<UserEntity> listUser){
        this.listUser = listUser;
    }
    @Override
    public void run() {
        for(UserEntity userEntity : listUser){
            System.out.println("执行线程ID:" + getId() + "执行线程名称:" + getName() + "发送短信:" + userEntity.toString());
        }
    }
}

/**
 * 问题
 * 1.每开一个线程都要占用cpu资源 要合理开线程数量  根据服务器的配置 来开具体线程数量/cpu 核数  和硬盘大小没有关系
 * 2.List装太多数据 会报内存溢出错误
 * 3.能分几页  就几个线程
 */
public class ThreadController {
    public static void main(String[] args) {
        /**
         * 1.初始化用户信息
         * 2.定义每个线程 最多跑多少数据
         * 3.定义线程数量 根据用户数量进行增长 并且定义每个线程跑哪些数据
         * 4.真正让子线程进行分批异步处理数据
         */
        List<UserEntity> initUser = initUser();
        int userCount = 2;
        List<List<UserEntity>> userList =  ListUtils.splitList(initUser,userCount);
        for(int i = 0; i < userList.size(); i++){
           List<UserEntity> userEntityList = userList.get(i);
            new UserThread(userEntityList).start();

        }
    }

    /**
     * 初始化用户信息
     * @return
     */
    public static List<UserEntity> initUser(){
        List<UserEntity> listUser = new ArrayList<>();
        for (int i = 0; i < 11; i++){
            listUser.add(new UserEntity("userId:" + i,"userName:" + i));
        }
        return listUser;
    }
}
