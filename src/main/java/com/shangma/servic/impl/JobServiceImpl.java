package com.shangma.servic.impl;

import com.shangma.entity.Job;
import com.shangma.mapper.JobMapper;
import com.shangma.servic.JobService;
import com.shangma.servic.base.impl.MyBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wenbo
 * 2022/7/17
 */
@Service
public class JobServiceImpl extends MyBaseServiceImpl<Job> implements JobService {

    @Autowired
    private JobMapper jobMapper;
    /**
     * 查询所有职务和其权限
     * @return 集合
     */
    @Override
    public List<Map> selectJobAndPermission() {
        return jobMapper.selectJobAndPermission();
    }
}
