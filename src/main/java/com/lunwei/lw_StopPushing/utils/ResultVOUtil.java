package com.lunwei.lw_StopPushing.utils;

import com.lunwei.lw_StopPushing.enums.CodeEnum;
import com.lunwei.lw_StopPushing.exception.CodeMessageException;

/**
 * ClassName:    ResultVOUtil
 * Package:    com.lunwei.lw_StopPushing.utils
 * Description: 出参公共类
 * Datetime:    2020/1/17   15:37
 * Author:   zhoukaishun
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setStatus("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO success(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setStatus("成功");
        resultVO.setMessage(msg);
        return resultVO;
    }

    public static ResultVO success(String msg,Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setStatus("成功");
        resultVO.setMessage(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setStatus("失败");
        resultVO.setMessage(msg);
        return resultVO;
    }

    public static ResultVO error(CodeMessageException exception) {
        return error(exception.getCode(),exception.getMessage());
    }

    public static ResultVO error(CodeEnum codeEnum) {
        return error(codeEnum.getCode(),codeEnum.getMessage());
    }

}
