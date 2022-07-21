package com.shangma.common.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BOGEY
 * 2022/7/19  21:25
 */
@Data
public class PageParam implements Serializable {

    private static final long serialVersionUID = 12345678908L;

    private int pageNum;
    private int pageSize;

}
