package com.it.cs.annotation.entity;

import com.it.cs.annotation.annotation.SetProperty;
import com.it.cs.annotation.annotation.SetTable;
import lombok.Data;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/19 14:42
 */
@SetTable("user_table")
@Data
public class UserEntityAnn{
    @SetProperty(name = "user_name",leng = 10)
    private String userName;
    @SetProperty(name = "user_age",leng = 10)
    private Integer userAge;
}
