package com.shangma.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangma.entity.User;

import java.util.List;

/**
 * @author:
 * @description:
 * @className:
 * @date: 2022/7/14 22:26
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAllUserAndRole();
}
