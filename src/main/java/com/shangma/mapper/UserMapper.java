package com.shangma.mapper;


import com.shangma.entity.User;
import com.shangma.mapper.base.MyBaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author BOGEY
 * 2022/7/14  21:18
 */
public interface UserMapper extends MyBaseMapper<User> {


    /**
     * 查询用户和职务的集合
     * @return
     */
    List<Map> findUserAndAll();
}
