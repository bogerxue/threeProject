package com.shangma.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangma.annotation.PrivAnno;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.page.PageBean;
import com.shangma.common.page.PageParam;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.User;
import com.shangma.enums.PrivEnum;
import com.shangma.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wenbo
 * 2022/7/16
 * Slf4j 直接使用log快速调用
 */
@Slf4j
@RestController
@RequestMapping("u")
public class UserController extends MyBaseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public AxiosResult<PageBean<User>> findAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(PageBean.initData(page.getTotal(), userService.findAll()), AxiosStatus.OK);
    }

    @GetMapping("{id}")
    public AxiosResult<User> findById(@PathVariable Long id) {
        return AxiosResult.getInstance(userService.findObjectById(id), AxiosStatus.OK);
    }

    @GetMapping("userAll")
    @PrivAnno(PrivEnum.ADMIN)
    public AxiosResult<PageBean<Map>> userAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(
                PageBean.initData(
                        page.getTotal(),
                        userService.findUserAndAll()),
                AxiosStatus.OK);
    }

    @PostMapping
    public AxiosResult addUser(@RequestBody User user) {
        return toResult(userService.addObject(user),
                AxiosStatus.ADDUSER_ERROR);
    }

    @PutMapping
    public AxiosResult editUser(@RequestBody User user) {
        return toResult(userService.updateObject(user),
                AxiosStatus.UPDATE_ERROR);
    }

    @DeleteMapping("{id}")
    public AxiosResult deleteUser(@PathVariable Long id) {
        return toResult(userService.deleteObjectById(id),
                AxiosStatus.DELETE_ERROR);
    }

}
