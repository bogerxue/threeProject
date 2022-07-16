package com.shangma.controller;

import com.shangma.common.http.ResultCode;
import com.shangma.common.http.StatusCode;
import com.shangma.entity.User;
import com.shangma.servic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenbo
 * 2022/7/16
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public ResultCode<User> findAll(){
        List<User> userList = userService.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
        ResultCode resultCode =new ResultCode();
        if (userList.isEmpty()){

            resultCode.setStatusCode(StatusCode.ERROR);
        }else {
            resultCode.setData(userList);
            resultCode.setStatusCode(StatusCode.OK);
        }
        return resultCode;
    }


}
