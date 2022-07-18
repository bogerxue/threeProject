package com.shangma.servic;

import com.shangma.entity.User;
import com.shangma.entity.UserAndJob;
import com.shangma.servic.base.MyBaseService;

import java.util.List;
import java.util.Map;

/**
 * @author BOGEY
 * 2022/7/14  21:20
 */
public interface UserService extends MyBaseService<User> {

    /**
     * 查询用户包含职务
     * @param id
     * @return
     */
    UserAndJob findUserAndJobById(Long id);

    /**
     * 查询用户和其职务
     * @return
     */
    List<Map> findUserAndJob();
}
