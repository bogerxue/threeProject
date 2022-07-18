package com.shangma.servic;

import com.shangma.entity.Job;
import com.shangma.servic.base.MyBaseService;

import java.util.List;
import java.util.Map;

/**
 * @author wenbo
 * 2022/7/17
 */
public interface JobService extends MyBaseService<Job> {

    /**
     * 查询所有职务和其权限
     * @return
     */
    List<Map> selectJobAndPermission();
}
