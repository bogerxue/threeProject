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
    ERROR(50000, "失败");

    private final Integer status;
    private final String message;
}
