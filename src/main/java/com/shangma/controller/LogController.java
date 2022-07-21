package com.shangma.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.page.PageBean;
import com.shangma.common.page.PageParam;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.LogEntity;
import com.shangma.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/21  10:56
 */
@RestController
@RequestMapping("log")
public class LogController extends MyBaseController {

    @Autowired
    private LogService logService;


    @GetMapping
    public AxiosResult<PageBean<LogEntity>> findAll(PageParam pageParam) {
        Page page = PageHelper.startPage(pageParam);
        List<LogEntity> logEntities = logService.findAll();
        PageBean<LogEntity> pageBean = PageBean.initData(page.getTotal(), logEntities);
        return AxiosResult.getInstance(pageBean, AxiosStatus.OK);
    }

    @GetMapping("{id}")
    public AxiosResult<LogEntity> findById(@PathVariable Long id) {
        return AxiosResult.getInstance(logService.findObjectById(id), AxiosStatus.OK);
    }

    @PostMapping
    public AxiosResult addLogEntity(@RequestBody LogEntity logEntity) {
        return toResult(logService.addObject(logEntity), AxiosStatus.ADDUSER_ERROR);
    }

    @PutMapping
    private AxiosResult updateLogEntity(@RequestBody LogEntity logEntity) {
        return toResult(logService.updateObject(logEntity), AxiosStatus.UPDATE_ERROR);
    }

    @DeleteMapping("{id}")
    private AxiosResult deleteLogEntity(@PathVariable Long id) {
        return toResult(logService.deleteObjectById(id), AxiosStatus.DELETE_ERROR);
    }
}
