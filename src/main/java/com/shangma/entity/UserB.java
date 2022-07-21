package com.shangma.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shangma.entity.base.MyBaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author BOGEY
 * 2022/7/21  16:48
 */
@Data
@TableName("a_user")
public class UserB extends MyBaseEntity {

    private static final long serialVersionUID = 12345678909L;

    private String userLoginName;
    private String userName;
    private String userPassword;
    private String userDepartment;
    private long userSex;
    private long userStatus;
    private String userPhone;
    private String userEmail;
    private String userIp;
    private long userRole;
    private String descOne;
    private String descTwo;

    private LocalDateTime loginTime;

    @TableField(exist = false)
    private Role role =new Role();

}
