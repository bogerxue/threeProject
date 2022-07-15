package com.shangma.web;

import com.shangma.entity.User;
import com.shangma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:
 * @description:
 * @className:
 * @date: 2022/7/15 10:05
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAllUserAndRole")
    public List<User> findAllUserAndRole(){
        return userService.findAllUserAndRole();
    }
}
