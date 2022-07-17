package com.shangma.controller;


import com.shangma.common.http.ResultCode;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.Permission;
import com.shangma.servic.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenbo
 * 2022/7/17
 */
@RestController
@RequestMapping("Permission")
public class PermissionController extends MyBaseController {

    @Autowired
    public PermissionService permissionService;

    @GetMapping
    public ResultCode<List<Permission>> findAll(){
        return ResultCode.success(permissionService.findAll());
    }

}
