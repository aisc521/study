package com.it.cs.study.thread.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/11 16:47
 */
@Data
public class UserEntity {
    /**
     * 用户userId
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String mobile;

    public UserEntity(String userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }
}
