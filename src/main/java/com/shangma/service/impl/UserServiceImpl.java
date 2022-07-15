package com.shangma.service.impl;

import com.shangma.entity.User;
import com.shangma.mapper.UserMapper;
import com.shangma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:
 * @description:
 * @className:
 * @date: 2022/7/15 10:03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUserAndRole() {
        return userMapper.findAllUserAndRole();
    }
}
