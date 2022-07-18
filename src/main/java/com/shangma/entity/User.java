package com.shangma.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shangma.entity.base.MyBaseEntity;
import lombok.Data;

/**
 * @author BOGEY
 * 2022/7/14  21:19
 */
@Data
@TableName("a_user")
public class User extends MyBaseEntity {

    private static final long serialVersionUID = 12345678903L;

    private String userName;
    private String userEmail;
    private String userPassword;
    private long userJob;

}
