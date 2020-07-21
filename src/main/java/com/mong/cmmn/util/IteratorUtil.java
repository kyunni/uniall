package com.mong.cmmn.util;

import java.util.Iterator;

import org.apache.commons.collections4.IteratorUtils;


public class IteratorUtil {

    public static Iterator<?> getIterator(Object obj) {
        return IteratorUtils.getIterator(obj);
    }

    public static <E> E get(Iterator<E> iterator, int index) {
        return IteratorUtils.get(iterator, index);
    }


}
