package com.mong.cmmn.util;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * Created by ub-06 on 2016-11-18.
 */
public class FieldUtil {

    public static Object readField(Object target, String fieldName, boolean forceAccess) throws IllegalAccessException {

        if (target == null){
            return null;
        }

        return FieldUtils.readField(target, fieldName, forceAccess);
    }

    public static Field[] getAllFields(Class<?> cls){
        return FieldUtils.getAllFields(cls);
    }

    public static Field getDeclaredField(Class<?> cls, String fieldName){
        return FieldUtils.getDeclaredField(cls, fieldName);
    }

    public static Field getDeclaredField(Class<?> cls, String fieldName, boolean forceAccess){
        return FieldUtils.getDeclaredField(cls, fieldName, forceAccess);
    }
}
