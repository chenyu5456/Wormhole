package com.wormhole.common.enums;

import lombok.Getter;

/**
 * @Author: ChenYu
 * @Date: 2019/2/22 11:56
 * @Description: 定义状态枚举
 */
@Getter
public enum ApiStatus {
    SUCCESS(200, "操作成功!"),
    BAD_REQUEST(400, "错误请求"),
    NOT_FOUND(404, "页面未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_LOGIN(40005, "没登录"),
    INVALID_PARAM(40006, "无效参数");
    private int code;
    private String msg;

    ApiStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
