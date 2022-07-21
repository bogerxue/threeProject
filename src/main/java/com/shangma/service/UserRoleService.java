package com.shangma.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shangma.entity.UserRole;
import com.shangma.service.base.MyBaseService;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/20  21:39
 */
public interface UserRoleService extends MyBaseService<UserRole> {
    /**
     *  根据条件搜索
     * @param wrapper
     * @return
     */
    List<UserRole> searchObject(LambdaQueryWrapper<UserRole> wrapper);

}
