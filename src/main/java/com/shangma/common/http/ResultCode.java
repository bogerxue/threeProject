package com.shangma.common.http;

import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author BOGEY
 * 2022/7/15  11:16
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //不是null的数据才会携带给前端
public class ResultCode<T> {
    /**
     * 响应状态
     */
    private int status;
    /**
     * 响应信息
     */
    private String message;

    private StatusCode statusCode;
    /**
     * 响应数据
     */
    private T data;

    public ResultCode(){
    }


    public ResultCode(StatusCode statusCode, T t) {
        this.statusCode=statusCode;
        this.data = t;
    }


    private static <T> ResultCode<T> getInstance(StatusCode statusCode, T t) {
        return new ResultCode<T>(statusCode, t);
    }

    /**
     * 请求成功返回
     * @return 状态信息
     */
    private static <T> ResultCode<T> success() {
        return getInstance(StatusCode.OK, null);
    }

    /**
     * 请求成功携带数据返回
     * @param t 数据
     * @return 状态信息和数据
     */
    private static <T> ResultCode<T> success(T t) {
        return getInstance(StatusCode.OK, t);
    }

    /**
     * 请求失败返回
     * @return 状态信息
     */
    private static <T> ResultCode<T> error() {
        return getInstance(StatusCode.ERROR, null);
    }
    /**
     * 请求失败携带数据返回
     * @param t 数据
     * @return 状态信息和数据
     */
    private static <T> ResultCode<T> error(T t) {
        return getInstance(StatusCode.ERROR, t);
    }


}
