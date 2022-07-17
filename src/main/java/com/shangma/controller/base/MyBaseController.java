package com.shangma.controller.base;

import com.shangma.common.http.ResultCode;
import com.shangma.common.http.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author wenbo
 * 2022/7/17
 */
@Component
public class MyBaseController {

    public ResultCode toResult(int row) {
        return row > 0 ? ResultCode.success() : ResultCode.error();
    }

    public ResultCode toResult(int row, StatusCode statusCode) {
        return row > 0 ? ResultCode.success() : ResultCode.getInstance(statusCode);
    }

    public ResultCode toResult(int row, StatusCode success, StatusCode error) {
        return row > 0 ? ResultCode.getInstance(success) : ResultCode.getInstance(error);
    }


}
