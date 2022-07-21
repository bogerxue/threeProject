package com.shangma.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author BOGEY
 * 2022/7/15  11:16
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //不是null的数据才会携带给前端
public class AxiosResult<T> {
    /**
     * 响应状态
     */
    private Integer status;
    /**
     * 响应信息
     */
    private String message;

    private AxiosStatus axiosStatus;
    /**
     * 响应数据
     */
    private T data;

    public AxiosResult() {
    }

    public AxiosResult(AxiosStatus axiosStatus) {
        this.status = axiosStatus.getStatus();
        this.message = axiosStatus.getMessage();
    }

    public AxiosResult(T t, AxiosStatus axiosStatus) {
        this.status = axiosStatus.getStatus();
        this.message = axiosStatus.getMessage();
        this.data = t;
    }

    public static <T> AxiosResult<T> getInstance(AxiosStatus axiosStatus) {
        return new AxiosResult<T>(axiosStatus);
    }

    public static <T> AxiosResult<T> getInstance(T t, AxiosStatus axiosStatus) {
        return new AxiosResult<T>(t, axiosStatus);
    }

}
