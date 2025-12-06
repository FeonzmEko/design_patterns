package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("userDao被创建了。。。");
    }

    @Override
    public void add() {
        System.out.println("UserDao...");
    }
}
