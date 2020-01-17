package com.lunwei.lw_StopPushing.utils;

import java.util.Random;

/**
 * ClassName:    RandomStringUtils
 * Package:    com.lunwei.lw_StopPushing.utils
 * Description:
 * Datetime:    2020/1/17   14:19
 * Author:   zhoukaishun
 */
public class RandomStringUtils {

    private static String number = "0123456789";

    private static String upperWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String lowerWord = "abcdefghijklmnopqrstuvwxyz";

    public static String randomNumeric(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(number.charAt(random.nextInt(number.length())));
        }
        return stringBuffer.toString();
    }

    public static String randomString(int n) {
        String string = number + upperWord + lowerWord;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(string.charAt(random.nextInt(string.length())));
        }
        return stringBuffer.toString();
    }

    public static String leftZeroFill(String string, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = string.length(); i < length; i++) {
            builder.append("0");
        }
        return builder.toString() + string;
    }

    public static String getMaxSubString(String s1, String s2) {
        String max = "", min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;
        for (int x = 0; x < min.length(); x++) {
            for (int y = 0, z = min.length() - x; z != min.length() + 1; y++, z++) {
                String temp = min.substring(y, z);
                if (max.contains(temp)) return temp;
            }
        }
        return "";
    }

}
