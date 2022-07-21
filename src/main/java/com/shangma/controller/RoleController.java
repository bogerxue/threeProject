package com.shangma.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.page.PageBean;
import com.shangma.common.page.PageParam;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.Role;
import com.shangma.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wenbo
 * 2022/7/18
 */
@RestController
@RequestMapping("r")
public class RoleController extends MyBaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public AxiosResult<PageBean<Role>> findAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(PageBean.initData(page.getTotal(), roleService.findAll()), AxiosStatus.OK);
    }

    @GetMapping("{id}")
    public AxiosResult<Role> findRoleById(@PathVariable Long id) {
        return AxiosResult.getInstance(roleService.findObjectById(id), AxiosStatus.OK);
    }

    @GetMapping("andPermission")
    public AxiosResult<PageBean<Map>> selectJobAndPermission(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(PageBean.initData(page.getTotal(), roleService.selectPermissionAndRole()), AxiosStatus.OK);
    }

    @PostMapping
    public AxiosResult addRole(@RequestBody Role role) {
        return toResult(roleService.addObject(role), AxiosStatus.ADDUSER_ERROR);
    }

    @PutMapping
    public AxiosResult updateRole(@RequestBody Role role) {
        return toResult(roleService.updateObject(role), AxiosStatus.UPDATE_ERROR);
    }

    @DeleteMapping("{id}")
    public AxiosResult deleteRole(@PathVariable Long id) {
        return toResult(roleService.deleteObjectById(id), AxiosStatus.DELETE_ERROR);
    }


}
