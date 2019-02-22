package com.wormhole.common.base;

import com.wormhole.common.enums.ApiStatus;
import lombok.Data;

/**
 * @Author: ChenYu
 * @Date: 2019/2/22 11:48
 * @Description: 定制Api响应类(Result)
 */
@Data
public class ApiResponse {
    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;

    public ApiResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 常用的静态方法
     */

    public static ApiResponse ofSuccess(Object data){
        return new ApiResponse(ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMsg(), data);
    }

    public static ApiResponse ofMessage(int code, String msg){
        return new ApiResponse(code, msg, null);
    }

    public static ApiResponse ofStatus(ApiStatus status){
        return new ApiResponse(status.getCode(), status.getMsg(), null);
    }


}
