package com.shangma.controller;

import com.shangma.common.http.ResultCode;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.Job;
import com.shangma.servic.JobService;
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
@RequestMapping("job")
public class JobController extends MyBaseController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResultCode<List<Job>> findAll(){
        return ResultCode.success(jobService.findAll());
    }
}
