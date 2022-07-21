package com.shangma.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangma.entity.PermissionRole;
import com.shangma.entity.User;
import com.shangma.mapper.PermissionRoleMapper;
import com.shangma.mapper.UserMapper;
import com.shangma.service.UserService;
import com.shangma.service.base.impl.MyBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author BOGEY
 * 2022/7/15  9:48
 */
@Service
@Transactional
public class UserServiceImpl extends MyBaseServiceImpl<User> implements UserService {

    private String[] admins = {"admin", "ponyMa"};

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionRoleMapper pRoleMapper;


    @Override
    public List<Map> findUserAndAll() {
        return userMapper.findUserAndAll();
    }

    @Override
    public boolean isAdmin(String name) {
        return Arrays.asList(admins).contains(name);
    }

    @Override
    public List<User> searchObject(QueryWrapper<User> queryWrapper) {
        return super.searchObject(queryWrapper);
    }

    @Override
    public boolean isPermission(String loginName) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //根据登录名查询用户权限
        wrapper.like(User::getUserLoginName, loginName);
        List<User> users = userMapper.selectList(wrapper);
        User user = users.get(0);
        LambdaQueryWrapper<PermissionRole> wrapperpr = new LambdaQueryWrapper<>();
        wrapperpr.like(PermissionRole::getRoleId, user.getUserRole());
        List<PermissionRole> permissionRoles = pRoleMapper.selectList(wrapperpr);
        if (permissionRoles != null) {
            for (PermissionRole p : permissionRoles) {
                // 权限ID
                Long permissionId = 11L;
                boolean equals = (p.getPermissionId() == permissionId);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<User> searchObject(LambdaQueryWrapper<User> wrapper) {
        return userMapper.selectList(wrapper);
    }


}
