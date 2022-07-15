package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("a_role")
public class Role {

  private long id;
  private String roleCode;
  private String roleName;
  private String roleDesc;
  private long roleStatue;
  private String rolePart;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }


  public long getRoleStatue() {
    return roleStatue;
  }

  public void setRoleStatue(long roleStatue) {
    this.roleStatue = roleStatue;
  }


  public String getRolePart() {
    return rolePart;
  }

  public void setRolePart(String rolePart) {
    this.rolePart = rolePart;
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", roleCode='" + roleCode + '\'' +
            ", roleName='" + roleName + '\'' +
            ", roleDesc='" + roleDesc + '\'' +
            ", roleStatue=" + roleStatue +
            ", rolePart='" + rolePart + '\'' +
            '}';
  }
}
