package com.hjh.h5citymanage.service;

import com.hjh.h5citymanage.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:50
 */
public interface UserService {
//    public int add(User user);
//
//    public void delete(int id);
//
//    public User get(int id);
//
//    public int update(User user);
//
//    public List<User> list();

    public User loginValidate(User user);

    public User getUserByName(String name);
}
