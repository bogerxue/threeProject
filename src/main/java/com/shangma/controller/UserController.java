package com.shangma.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangma.common.http.ResultCode;
import com.shangma.common.http.StatusCode;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.User;
import com.shangma.servic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wenbo
 * 2022/7/16
 */
@RestController
@RequestMapping("user")
public class UserController extends MyBaseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResultCode<List<User>> findAll(){
        return ResultCode.success(userService.findAll());
    }

    @GetMapping("{id}")
    public ResultCode<User> findById(@PathVariable Long id){
        return ResultCode.success(userService.findObjectById(id));
    }

    @GetMapping("{userName}")
    public ResultCode<List<User>> findByTerm(@RequestBody String userName ){
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("userName",userName);
        return ResultCode.success(userService.searchObject(queryWrapper));
    }

    @PostMapping
    public ResultCode addUser(@RequestBody User user ){
        return toResult(userService.addObject(user),StatusCode.ADDUSER_ERROR);
    }

    @PutMapping
    public ResultCode editUser(@RequestBody User user){
        return toResult(userService.updateObject(user));
    }

    @DeleteMapping("{id}")
    public ResultCode deleteUser(@PathVariable Long id){
        return toResult(userService.deleteObjectById(id));
    }



}
