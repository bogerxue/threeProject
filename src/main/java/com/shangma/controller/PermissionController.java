package com.shangma.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.page.PageBean;
import com.shangma.common.page.PageParam;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.Permission;
import com.shangma.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenbo
 * 2022/7/17
 */
@RestController
@RequestMapping("/p")
public class PermissionController extends MyBaseController {

    @Autowired
    public PermissionService permissionService;

    @GetMapping
    public AxiosResult<PageBean<Permission>> findAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        return AxiosResult.getInstance(PageBean.initData(page.getTotal(), permissionService.findAll()), AxiosStatus.OK);
    }

    @GetMapping("/{id}")
    public AxiosResult<Permission> findById(@PathVariable Long id) {
        return AxiosResult.getInstance(permissionService.findObjectById(id), AxiosStatus.OK);
    }

    @PostMapping
    public AxiosResult addPermission(@RequestBody Permission permission) {
        return toResult(permissionService.addObject(permission), AxiosStatus.ADDUSER_ERROR);
    }

    @PutMapping
    private AxiosResult updatePermission(@RequestBody Permission permission) {
        return toResult(permissionService.updateObject(permission), AxiosStatus.UPDATE_ERROR);
    }

    @DeleteMapping("/{id}")
    private AxiosResult deletePermission(@PathVariable Long id) {
        return toResult(permissionService.deleteObjectById(id), AxiosStatus.DELETE_ERROR);
    }


}
