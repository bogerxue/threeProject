package com.shangma.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.page.PageBean;
import com.shangma.common.page.PageParam;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.PermissionRole;
import com.shangma.service.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenbo
 * 2022/7/18
 */
@RestController
@RequestMapping("pr")
public class PermissionRoleController extends MyBaseController {
    @Autowired
    private PermissionRoleService permissionRoleService;

    @GetMapping
    public AxiosResult<PageBean<PermissionRole>> findAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(PageBean.initData(page.getTotal(), permissionRoleService.findAll()), AxiosStatus.OK);
    }

    @GetMapping("{id}")
    public AxiosResult<PermissionRole> findById(@PathVariable Long id) {
        return AxiosResult.getInstance(permissionRoleService.findObjectById(id), AxiosStatus.OK);
    }

    @PostMapping
    public AxiosResult addPermissionRole(@RequestBody PermissionRole permissionRole) {
        return toResult(permissionRoleService.addObject(permissionRole), AxiosStatus.ADDUSER_ERROR);
    }

    @PutMapping
    private AxiosResult updatePermissionRole(@RequestBody PermissionRole permissionRole) {
        return toResult(permissionRoleService.updateObject(permissionRole), AxiosStatus.UPDATE_ERROR);
    }

    @DeleteMapping("{id}")
    private AxiosResult deletePermissionRole(@PathVariable Long id) {
        return toResult(permissionRoleService.deleteObjectById(id), AxiosStatus.DELETE_ERROR);
    }

}
