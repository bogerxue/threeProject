package com.shangma.service.impl;

import com.shangma.entity.Role;
import com.shangma.mapper.RoleMapper;
import com.shangma.service.RoleService;
import com.shangma.service.base.impl.MyBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author wenbo
 * 2022/7/17
 */
@Service
@Transactional
public class RoleServiceImpl extends MyBaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有职务和其权限
     *
     * @return 集合
     */
    @Override
    public List<Map> selectPermissionAndRole() {
        return roleMapper.selectPermissionAndRole();
    }
}
