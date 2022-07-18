package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * @author BOGEY
 * 2022/7/14  21:19
 */

@Data
@TableName("a_job")
public class Job{

    private static final long serialVersionUID = 12345678902L;

    /**
     * mybatisplus 主键自动增加
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String jobName;
    private String jobDesc;
    private Long jobParentId;
    /**
     *字段是否为数据库字段
     */
    @TableField(exist = false)
    private List<Permission> permissionList = new ArrayList<>();
}
