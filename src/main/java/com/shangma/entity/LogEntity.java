package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.shangma.entity.base.MyBaseEntity;
import lombok.Data;

/**
 * @author JAVASM
 */
@Data
@TableName("a_log")
public class LogEntity extends MyBaseEntity {

    private static final long serialVersionUID = 12345678905L;

    private String logName;
    private String logLevel;
    private String logIp;
    private String logPort;
    private long logUserId;
    private String logDesc;

}
