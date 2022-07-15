package com.shangma.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author:
 * @description:
 * @className:
 * @date: 2022/7/15 14:20
 */
@Getter
@AllArgsConstructor
public enum AxiosStatus {
    OK(20000,"操作成功"),
    ERROR(50000,"操作失败");

    private int status;
    private String message;
}
