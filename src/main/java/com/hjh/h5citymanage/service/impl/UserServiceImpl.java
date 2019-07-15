package com.hjh.h5citymanage.service.impl;

import com.hjh.h5citymanage.mapper.UserMapper;
import com.hjh.h5citymanage.pojo.User;
import com.hjh.h5citymanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-06-28 21:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

//    @Override
//    public int add(User user) {
//        return userMapper.add(user);
//    }
//
//    @Override
//    public void delete(int id) {
//        userMapper.delete(id);
//    }
//
//    @Override
//    public User get(int id) {
//        return userMapper.get(id);
//    }
//
//    @Override
//    public int update(User user) {
//        return userMapper.update(user);
//    }
//
//    @Override
//    public List<User> list() {
//        return userMapper.list();
//    }


    @Override
    public User loginValidate(User user) {
        return userMapper.loginValidate(user);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
