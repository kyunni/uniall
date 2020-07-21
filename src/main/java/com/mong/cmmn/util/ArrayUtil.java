package com.mong.cmmn.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class ArrayUtil {

    public static String getString(String[] array, int index) {
        if (isEmpty(array) || array.length <= index) {
            return "";
        }

        return array[index];
    }

    public static boolean isEmpty(String[] array) {
        return ArrayUtils.isEmpty(array);
    }

    public static boolean isNotEmpty(Object[] array) {
        return ArrayUtils.isNotEmpty(array);
    }

    public static int indexOf(Object[] array, Object objectToFind) {
        return ArrayUtils.indexOf(array, objectToFind);
    }

    public static int getLength(Object array) {
        return ArrayUtils.getLength(array);
    }

    public static <T> T[] append(T[] arr, T element) {
        final int N = arr.length;
        arr = Arrays.copyOf(arr, N + 1);
        arr[N] = element;
        return arr;
    }

    public static <T> T[] removeElements(T[] array, T... values) {
        return ArrayUtils.removeElements(array, values);
    }

    public static boolean isArray(Object obj){
        if(obj == null){
            return false;
        }

        return obj.getClass().isArray();
    }
    public static <T> T[] add(T[] array, int index, T element){
        return ArrayUtils.add(array, index, element);
    }
}
