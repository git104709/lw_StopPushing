package com.lunwei.lw_StopPushing.utils;

import java.util.UUID;

/**
 * ClassName:    TokenUtil
 * Package:    com.lunwei.lw_StopPushing.utils
 * Description:
 * Datetime:    2020/1/17   15:29
 * Author:   zhoukaishun
 */
public class TokenUtil {
    public TokenUtil() {
    }

    public static String getUUID32() {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    public static String getUUID64() {
        String token = UUID.randomUUID().toString().replaceAll("-", "") + UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }
}
