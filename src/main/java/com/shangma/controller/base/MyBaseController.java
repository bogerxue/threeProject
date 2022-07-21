package com.shangma.controller.base;

import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import org.springframework.stereotype.Component;

/**
 * @author wenbo
 * 2022/7/17
 */
@Component
public class MyBaseController {

    public AxiosResult toResult(int row) {
        return row > 0 ? AxiosResult.getInstance(AxiosStatus.OK) : AxiosResult.getInstance(AxiosStatus.ERROR);
    }

    public AxiosResult toResult(int row, AxiosStatus axiosStatus) {
        return row > 0 ? AxiosResult.getInstance(AxiosStatus.OK) : AxiosResult.getInstance(axiosStatus);
    }

    public AxiosResult toResult(int row, AxiosStatus success, AxiosStatus error) {
        return row > 0 ? AxiosResult.getInstance(success) : AxiosResult.getInstance(error);
    }


}
