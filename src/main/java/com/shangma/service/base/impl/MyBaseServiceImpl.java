package com.shangma.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangma.mapper.base.MyBaseMapper;
import com.shangma.service.base.MyBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/15  10:16
 */
public class MyBaseServiceImpl<T> implements MyBaseService<T> {

    @Autowired(required = false)
    private MyBaseMapper<T> myBaseMapper;

    @Override
    public T findObjectById(Long id) {
        return myBaseMapper.selectById(id);
    }

    @Override
    public List<T> searchObject(QueryWrapper<T> queryWrapper) {
        return myBaseMapper.selectList(queryWrapper);
    }

    @Override
    public List<T> findAll() {
        return myBaseMapper.selectList(null);
    }

    @Override
    public Integer addObject(T t) {
        return myBaseMapper.insert(t);
    }

    @Override
    public Integer updateObject(T t) {
        return myBaseMapper.updateById(t);
    }

    @Override
    public Integer deleteObjectById(Long id) {
        return myBaseMapper.deleteById(id);
    }

    @Override
    public Integer batchDeleteObject(List<Long> ids) {
        return myBaseMapper.deleteBatchIds(ids);
    }
}
