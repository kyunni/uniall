package com.mong.cmmn.util;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

public class MapUtil {
    public static boolean isValueEmpty(Map map, String key){

        if(MapUtils.getObject(map, key) == null || StringUtil.isEmpty(MapUtils.getString(map, key))){
            return true;
        }

        return false;
    }

    public static boolean isValueNotEmpty(Map map, String key){
        return !isValueEmpty(map, key);
    }

    public static boolean isArrayEmpty(Map map, String key){
        Object[] arr = map == null ? null : (Object[]) map.get(key);

        return ArrayUtils.isEmpty(arr);
    }

    public static boolean isEmpty(Map map){
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map map){
        return MapUtils.isNotEmpty(map);
    }

    public static String getString(Map map, String key){
        return MapUtils.getString(map, key);
    }

    public static String getDefaultString(Map map, String key){
        return StringUtil.defaultString(getString(map, key));
    }

    public static String getDefaultString(Map map, String key, String defaultStr){
        return StringUtil.defaultString(getString(map, key), defaultStr);
    }

    public static Integer getInteger(Map map, String key){
        return MapUtils.getInteger(map, key);
    }

    public static int getIntValue(Map map, String key){
        return MapUtils.getIntValue(map, key);
    }

    public static int getIntValue(Map map, String key, int defaultValue){
        return MapUtils.getIntValue(map, key, defaultValue);
    }

    public static double getDoubleValue(Map map, String key){
        return MapUtils.getDoubleValue(map, key);
    }

    public static Integer getInteger(Map map, String key, Integer defaultValue){
        return MapUtils.getInteger(map, key, defaultValue);
    }

    public static <K, V> V getObject(Map<? super K, V> map, K key) {
        return MapUtils.getObject(map, key);
    }

    @SuppressWarnings("unchecked")
	public static String[] getStrings(Map map, String key){
        Object value = getObject(map, key);

        if(value == null){
            return new String[]{};
        }else if(value.getClass().isArray()){
            Object[] valueArr = (Object[])value;
            String[] strArr = new String[valueArr.length];

            for(int i = 0; i < valueArr.length; i++){
                strArr[i] = StringUtil.toString(valueArr[i]);
            }

            return strArr;
        }else{
            return new String[]{value.toString()};
        }
    }

    public static Boolean getBoolean(Map map, String key, Boolean defaultValue){
        return MapUtils.getBoolean(map, key, defaultValue);
    }

    public static <K, V> Map<K, V> copyMap(Map<K, V> source){
        Map<K, V> copyMap = new HashMap<K, V>();

        copyMap.putAll(source);

        return copyMap;
    }

    public static <K, V> void copyMap(Map<K, V> source, Map<K, V> destination){
        destination.clear();

        destination.putAll(source);
    }

    public static Object[] lookupValues(Map<String, Object> map, String searchKey){
        if(MapUtil.isEmpty(map)){
            return new Object[]{};
        }

        Set<String> keys = map.keySet();

        List<Object> valueList = new ArrayList<Object>();

        for(String key : keys){
            if(StringUtil.contains(key, searchKey)){
                valueList.add(map.get(key));
            }
        }

        return valueList.toArray();
    }

    @SuppressWarnings("unchecked")
	public static Object[] getArray(Map map, String key) {
        Object[] objs = null;

        if(isEmpty(map)){
            objs = new Object[]{};
        }else if(ArrayUtil.isArray(getObject(map, key))){
            objs = (Object[]) getObject(map, key);
        }else{
            objs = new Object[]{getObject(map, key)};
        }

        return objs;
    }

    @SuppressWarnings("unchecked")
	public static <T> T[] getArray(Class<T> c, Map map, String key) {
    	T[] objs = null;
    	
    	if (isEmpty(map)) {
    		objs = (T[]) Array.newInstance(c, 0);
    	} else if (ArrayUtil.isArray(getObject(map, key))) {
    		objs = (T[]) MapUtil.getObject(map, key);
    	} else {
    		objs = (T[]) Array.newInstance(c, 0);
    		objs = (T[]) ArrayUtil.add(objs, 0, getObject(map, key));
    	}
    	
    	return objs;
    }

}