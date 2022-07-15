package com.shangma.service;

import com.shangma.entity.User;

import java.util.List;

/**
 * @author:
 * @description:
 * @className:
 * @date: 2022/7/15 10:02
 */
public interface UserService {

    List<User> findAllUserAndRole();
}
