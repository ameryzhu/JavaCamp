package com.mason.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao  dao;

    @Override
    public void save(User use) {
        dao.save(use);
    }
}
