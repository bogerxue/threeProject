package com.shangma.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author BOGEY
 * 2022/7/15  11:04
 */
@Getter
@AllArgsConstructor
public enum StatusCode {
    /**
     * 成功
     * 失败
     */
    OK(20000, "成功"),
    ERROR(50000, "失败"),
    ADDUSER_ERROR(50003, "添加失败"),
    MAIL_ERROR(50002,"邮箱错误"),
    PHONE_ERROR(50001,"手机号错误");

    private final Integer status;
    private final String message;
}
