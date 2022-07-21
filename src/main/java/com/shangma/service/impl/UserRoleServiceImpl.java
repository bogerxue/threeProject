package com.shangma.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shangma.entity.UserRole;
import com.shangma.mapper.UserRoleMapper;
import com.shangma.service.UserRoleService;
import com.shangma.service.base.impl.MyBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/20  21:40
 */
@Service
@Transactional
public class UserRoleServiceImpl extends MyBaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> searchObject(LambdaQueryWrapper<UserRole> wrapper) {

        return userRoleMapper.selectList(wrapper);
    }

}
