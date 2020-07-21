package com.mong.cmmn.util;

import org.apache.commons.lang3.BooleanUtils;

public class BooleanUtil {
    public static final String YES = "Y";
    public static final String NO = "N";

    public static boolean toBoolean(String str){
        return BooleanUtils.toBoolean(str);
    }
}
