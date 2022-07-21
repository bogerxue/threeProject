package com.shangma.service.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/15  9:43
 */
public interface MyBaseService<T> {

    /**
     * 根据id查询
     * @param id 实例id
     * @return 实例
     */
    T findObjectById(Long id);

    /**
     * 根据条件查询
     * @param queryWrapper 查询条件
     * @return 实例集合
     */
    List<T> searchObject(QueryWrapper<T> queryWrapper);

    /**
     * 查询所有
     * @return 集合
     */
    List<T> findAll();

    /**
     * 添加
     * @param t 实例
     * @return 状态码
     */
    Integer addObject(T t);

    /**
     * 修改
     * @param t 实例
     * @return 状态码
     */
    Integer updateObject(T t);

    /**
     * 根据id删除
     * @param id 实例id
     * @return 状态码
     */
    Integer deleteObjectById(Long id);

    /**
     * 根据id批量删除
     * @param ids 实例id集合
     * @return 状态码
     */
    Integer batchDeleteObject(List<Long> ids);

}
