package com.hjh.h5citymanage.pojo;

import lombok.Data;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-12 9:32
 */
@Data
public class User {

    private int id;
    private String name;
    private String password;
    private String loginTime;
    private int role;
}
