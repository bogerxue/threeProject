package com.shangma.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author BOGEY
 * 2022/7/15  11:04
 */
@Getter
@AllArgsConstructor
public enum AxiosStatus {
    /**
     * 成功
     * 失败
     */
    OK(20000, "成功"),
    ERROR(50000, "失败"),
    ADDUSER_ERROR(50003, "添加失败"),
    MAIL_ERROR(50002,"邮箱错误"),
    EMAIL_NOT_FOUND(50004,"邮箱找不到"),
    PHONE_ERROR(50001,"手机号错误"),
    ADMIN_NOT_ACTIVE(50005, "用户未激活"),
    CODE_CHECK_ERROR(50006, "验证码错误"),
    DELETE_ERROR(50007,"删除失败" ),
    UPDATE_ERROR(50008,"修改失败" );

    private final Integer status;
    private final String message;
}
