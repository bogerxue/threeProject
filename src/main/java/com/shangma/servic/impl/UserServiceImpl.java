package com.shangma.servic.impl;

import com.shangma.entity.User;
import com.shangma.entity.UserAndJob;
import com.shangma.mapper.UserMapper;
import com.shangma.servic.UserService;
import com.shangma.servic.base.impl.MyBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author BOGEY
 * 2022/7/15  9:48
 */
@Service
public class UserServiceImpl extends MyBaseServiceImpl<User> implements UserService {



    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户包含职务
     * @param id
     * @return
     */
    @Override
    public UserAndJob findUserAndJobById(Long id) {
        return userMapper.findUserAndJobById(id);
    }

    /**
     * 查询用户和其职务
     *
     * @return
     */
    @Override
    public List<Map> findUserAndJob() {
        return userMapper.findUserAndJob();
    }


}
