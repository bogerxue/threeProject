package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wenbo
 */
@Data
@TableName("a_job_permission")
public class JobPermission {

  private long id;
  private long jobId;
  private long permissionId;

}
