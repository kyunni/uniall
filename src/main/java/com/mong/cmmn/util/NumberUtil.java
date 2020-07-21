package com.mong.cmmn.util;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigInteger;

/**
 * Created by ub-06 on 2016-11-10.
 */
public class NumberUtil {
    public static int toInt(String str){
        return NumberUtils.toInt(str);
    }

    public static int toInt(String str, int defaultValue){
        return NumberUtils.toInt(str, defaultValue);
    }

    public static int toInt(Object obj){
        return toInt(StringUtil.toString(obj));
    }

    public static BigInteger createBigInteger(String str){
        if(StringUtil.isBlank(str)){
            return new BigInteger("0");
        }
        return NumberUtils.createBigInteger(str);
    }
}
