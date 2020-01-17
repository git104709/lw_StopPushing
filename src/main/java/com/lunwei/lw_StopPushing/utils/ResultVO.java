package com.lunwei.lw_StopPushing.utils;

import lombok.Data;

/**
 * ClassName:    ResultVO
 * Package:    com.lunwei.lw_StopPushing.utils
 * Description: 出参公共类
 * Datetime:    2020/1/17   15:37
 * Author:   zhoukaishun
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;
    /**
     *  状态
     */
    private String status;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T data;

}
