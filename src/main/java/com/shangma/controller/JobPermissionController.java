package com.shangma.controller;

import com.shangma.common.http.ResultCode;
import com.shangma.entity.JobPermission;
import com.shangma.servic.JobPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenbo
 * 2022/7/18
 */
@RestController
@RequestMapping("jp")
public class JobPermissionController {
    @Autowired
    private JobPermissionService jobPermissionService;

    @GetMapping
    public ResultCode<List<JobPermission>> findAll(){
        return ResultCode.success(jobPermissionService.findAll());
    }
    //权限增删改查
    //todo
}
