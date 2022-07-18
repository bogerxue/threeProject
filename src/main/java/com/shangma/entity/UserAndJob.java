package com.shangma.entity;

import com.shangma.entity.base.MyBaseEntity;
import lombok.Data;

/**
 * @author wenbo
 * 2022/7/18
 */
@Data
public class UserAndJob extends MyBaseEntity {

    private String userName;
    private long userJob;
    private String userEmail;
    private String userPassword;
    private Job job;
}
