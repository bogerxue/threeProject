package com.shangma.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("a_user")
public class User {

  private long id;
  private String userLoginName;
  private String userName;
  private String userPassword;
  private String userDepartment;
  private long userSex;
  private long userStatus;
  private String userJob;
  private String userPhone;
  private String userEmail;
  private String userIp;
  private long userRole;
  private String descOne;
  private String descTwo;
  private String descThree;
  private String descFore;
  private String descFive;
  private String createUser;
  private LocalDateTime createTime;
  private String updateUser;
  private LocalDateTime loginTime;

  //一对一
  private Role role;

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserLoginName() {
    return userLoginName;
  }

  public void setUserLoginName(String userLoginName) {
    this.userLoginName = userLoginName;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserDepartment() {
    return userDepartment;
  }

  public void setUserDepartment(String userDepartment) {
    this.userDepartment = userDepartment;
  }


  public long getUserSex() {
    return userSex;
  }

  public void setUserSex(long userSex) {
    this.userSex = userSex;
  }


  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }


  public String getUserJob() {
    return userJob;
  }

  public void setUserJob(String userJob) {
    this.userJob = userJob;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserIp() {
    return userIp;
  }

  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }


  public long getUserRole() {
    return userRole;
  }

  public void setUserRole(long userRole) {
    this.userRole = userRole;
  }


  public String getDescOne() {
    return descOne;
  }

  public void setDescOne(String descOne) {
    this.descOne = descOne;
  }


  public String getDescTwo() {
    return descTwo;
  }

  public void setDescTwo(String descTwo) {
    this.descTwo = descTwo;
  }


  public String getDescThree() {
    return descThree;
  }

  public void setDescThree(String descThree) {
    this.descThree = descThree;
  }


  public String getDescFore() {
    return descFore;
  }

  public void setDescFore(String descFore) {
    this.descFore = descFore;
  }


  public String getDescFive() {
    return descFive;
  }

  public void setDescFive(String descFive) {
    this.descFive = descFive;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(LocalDateTime loginTime) {
    this.loginTime = loginTime;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userLoginName='" + userLoginName + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userDepartment='" + userDepartment + '\'' +
            ", userSex=" + userSex +
            ", userStatus=" + userStatus +
            ", userJob='" + userJob + '\'' +
            ", userPhone='" + userPhone + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userIp='" + userIp + '\'' +
            ", userRole=" + userRole +
            ", descOne='" + descOne + '\'' +
            ", descTwo='" + descTwo + '\'' +
            ", descThree='" + descThree + '\'' +
            ", descFore='" + descFore + '\'' +
            ", descFive='" + descFive + '\'' +
            ", createUser='" + createUser + '\'' +
            ", createTime=" + createTime +
            ", updateUser='" + updateUser + '\'' +
            ", loginTime=" + loginTime +
            ", role=" + role +
            '}';
  }
}
