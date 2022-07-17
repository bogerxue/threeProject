package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.shangma.entity.base.MyBaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author BOGEY
 * 2022/7/14  21:19
 */

@Data
@TableName("a_job")
public class Job extends MyBaseEntity {

    private static final long serialVersionUID = 12345678902L;


    private String jobName;
    private String jobDesc;
    private Integer jobParentId;
    private List<Permission> permissions;

}
