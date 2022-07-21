package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wenbo
 */
@Data
@TableName("a_permission_role")
public class PermissionRole implements Serializable {

  private static final long serialVersionUID = 12345678906L;

  private long id;
  private long roleId;
  private long permissionId;

}
