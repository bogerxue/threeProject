package com.shangma.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shangma.entity.User;
import com.shangma.service.base.MyBaseService;

import java.util.List;
import java.util.Map;

/**
 * @author BOGEY
 * 2022/7/14  21:20
 */
public interface UserService extends MyBaseService<User> {

    List<Map> findUserAndAll();

    boolean isAdmin(String currentUser);

    boolean isPermission(String currentUser);

    List<User> searchObject(LambdaQueryWrapper<User> wrapper);
}
