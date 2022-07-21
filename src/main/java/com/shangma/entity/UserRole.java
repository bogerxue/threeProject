package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JAVASM
 */

@Data
@TableName("a_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 12345678907L;


    @TableId(type = IdType.AUTO)
    private long id;
    private long userId;
    private String userName;
    private long roleId;
    private String roleName;

}
