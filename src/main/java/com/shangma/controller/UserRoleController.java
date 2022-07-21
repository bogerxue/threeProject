package com.shangma.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.page.PageBean;
import com.shangma.common.page.PageParam;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.UserRole;
import com.shangma.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author BOGEY
 * 2022/7/21  11:01
 */
@RestController
@RequestMapping("ur")
public class UserRoleController extends MyBaseController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public AxiosResult<PageBean<UserRole>> findAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(PageBean.initData(page.getTotal(), userRoleService.findAll()), AxiosStatus.OK);
    }

    @GetMapping("{id}")
    public AxiosResult<UserRole> findById(@PathVariable Long id) {
        return AxiosResult.getInstance(userRoleService.findObjectById(id), AxiosStatus.OK);
    }

    @PostMapping
    public AxiosResult addUserRole(@RequestBody UserRole userRole) {
        return toResult(userRoleService.addObject(userRole), AxiosStatus.ADDUSER_ERROR);
    }

    @PutMapping
    private AxiosResult updateUserRole(@RequestBody UserRole userRole) {
        return toResult(userRoleService.updateObject(userRole), AxiosStatus.UPDATE_ERROR);
    }

    @DeleteMapping("{id}")
    private AxiosResult deleteUserRole(@PathVariable Long id) {
        return toResult(userRoleService.deleteObjectById(id), AxiosStatus.DELETE_ERROR);
    }

}
