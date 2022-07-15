package com.shangma.common.page;

import lombok.Data;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/15  11:04
 */
@Data
public class PageBean<T> {
    private long total;

    private List<T> data;

    private PageBean(long total,List<T> data){
        this.total = total;
        this.data = data;
    }

    public static <T> PageBean<T> initData(long total,List<T> data){
        return new PageBean<T>(total,data);
    }
}
