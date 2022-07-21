package com.shangma.service;

import com.shangma.entity.Role;
import com.shangma.service.base.MyBaseService;

import java.util.List;
import java.util.Map;

/**
 * @author wenbo
 * 2022/7/17
 */
public interface RoleService extends MyBaseService<Role> {

    /**
     * 查询所有职务和其权限
     * @return
     */
    List<Map> selectPermissionAndRole();
}
