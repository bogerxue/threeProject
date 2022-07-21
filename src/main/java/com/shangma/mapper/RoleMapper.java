package com.shangma.mapper;

import com.shangma.entity.Role;
import com.shangma.mapper.base.MyBaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author wenbo
 * 2022/7/17
 */
public interface RoleMapper extends MyBaseMapper<Role> {
    /**
     * 查询所有职务和其权限
     *
     * @return
     */
    List<Map> selectPermissionAndRole();
}
