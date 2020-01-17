package com.lunwei.lw_StopPushing.enums;

import lombok.Getter;

/**
 * ClassName:    ResultEnum
 * Package:    com.lunwei.lw_StopPushing.enums
 * Description:
 * Datetime:    2020/1/17   15:39
 * Author:   zhoukaishun
 */
@Getter
public enum ResultEnum implements CodeEnum {

    SUCCESS(0, "成功"),

    PARAMS_INVALID(1,"参数无效"),

    PARAMS_MISSING(2,"参数缺失"),

    ILLEGAL_USERS(100, "非法用户"),

    SERVER_ERROR(500, "服务器错误"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
