package com.mong.cmmn.page.request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mong.cmmn.util.ArrayUtil;
import com.mong.cmmn.util.IteratorUtil;
import com.mong.cmmn.util.MapUtil;
import com.mong.cmmn.util.NumberUtil;
import com.mong.cmmn.util.StringUtil;
import com.mong.cmmn.util.XSSFilterUtil;

import egovframework.rte.fdl.cmmn.exception.BaseException;

public class UniRequest {
    public static final String[] DEFAULT_ALLOWED_EXT = new String[]{"txt", "ppt", "pptx", "doc", "docx", "xls", "xlsx", "pdf", "hwp", "jpg", "jpeg", "png", "bmp", "gif", "zip", "rar", "mp3", "mp4"};

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return sra.getRequest();
    }

    public static String getParameter(String paramName){
        return getParameter(getRequest(), paramName);
    }

    public static String getParameter(String paramName, String defaultValue){
        return getParameter(getRequest(), paramName, defaultValue);
    }

    public static int getParameter(String paramName, int defaultValue){
        return getParameter(getRequest(), paramName, defaultValue);
    }

    public static String getParameter(HttpServletRequest request, String paramName){
        return XSSFilterUtil.doFilter(request.getParameter(paramName));
    }

    public static String getParameterHtml(HttpServletRequest request, String paramName){
        return XSSFilterUtil.doFilter(request.getParameter(paramName));
    }

    public static String getParameter(HttpServletRequest request, String paramName, String defaultValue){
        String paramValue = XSSFilterUtil.doFilter(request.getParameter(paramName));

        return StringUtil.isBlank(paramValue) ? defaultValue : paramValue;
    }

    public static int getParameter(HttpServletRequest request, String paramName, int defaultValue){
        String paramValue = XSSFilterUtil.doFilter(request.getParameter(paramName));

        return NumberUtil.toInt(paramValue, defaultValue);
    }

    public static int getMenuId(){
        return getParameter("menuId", 0);
    }

    public static String[] getParameterValues(HttpServletRequest request, String name) {
        String[] value = request.getParameterValues(name);

        if (value != null) {
            int length = value.length;

            for (int idx=0; idx < length; idx++) {
                value[idx] = XSSFilterUtil.doFilter(value[idx]);
            }
        }

        return value;
    }

/*    public static Map<String, MultipartFile> getFileMap(MultipartHttpServletRequest multiRequest) {
        return getFileMap(multiRequest, DEFAULT_ALLOWED_EXT);
    }*/
/*
    public static Map<String, MultipartFile> getFileMap(MultipartHttpServletRequest multiRequest, String... allowedExt) {
        Map<String, MultipartFile> files = multiRequest.getFileMap();

        Map<String, MultipartFile> fileMap = new LinkedHashMap<String, MultipartFile>();

        if (MapUtil.isNotEmpty(files)) {
            Iterator<Map.Entry<String, MultipartFile>> itr = (Iterator<Map.Entry<String, MultipartFile>>) IteratorUtil.getIterator(files.entrySet());

            while (itr.hasNext()) {
                Map.Entry<String, MultipartFile> entry = itr.next();
                MultipartFile file = entry.getValue();
                String ext = StringUtil.lowerCase(MultipartFileUtil.getExtension(file));

                if (MultipartFileUtil.isEmpty(file) || StringUtil.equalsAny(ext, allowedExt)) {
                    fileMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return fileMap;
    }

    public static Map<String, MultipartFile> getSortedFileMap(MultipartHttpServletRequest multiRequest) {
        Map<String, MultipartFile> files = getFileMap(multiRequest, DEFAULT_ALLOWED_EXT);

        List<String> sortedKeys = new ArrayList<String>(files.keySet());
        Collections.sort(sortedKeys);

        Map<String, MultipartFile> sortedFiles = new LinkedHashMap<String, MultipartFile>();

        if(CollectionUtil.isNotEmpty(sortedKeys)){
            for(String key : sortedKeys){
                sortedFiles.put(key, MapUtil.getObject(files, key));
            }
        }

        return sortedFiles;
    }*/

    public static Map<String, Object> getParameterMap(HttpServletRequest request){
        Map<String, String[]> paramMap = request.getParameterMap();

        Map<String, Object> param = new LinkedHashMap<String, Object>();

        Set<String> keys = paramMap.keySet();

        if(MapUtil.isNotEmpty(paramMap)){
            for(String key : keys){
                String[] values = paramMap.get(key);

                if(ArrayUtil.isEmpty(values)){
                    param.put(key, "");
                }else if(ArrayUtil.getLength(values) == 1){
                    param.put(key, UniRequest.getParameter(request, key));
                }else{
                    param.put(key, UniRequest.getParameterValues(request, key));
                }
            }
        }

        return param;
    }

    public static Map<String, Object> getParameterMap(MultipartHttpServletRequest request){

        Map<String, Object> param = getParameterMap((HttpServletRequest)request);

        Map<String, MultipartFile> files = request.getFileMap();

        if(MapUtil.isNotEmpty(files)){
            for(Map.Entry<String, MultipartFile> entry : files.entrySet()){
                param.put(entry.getKey(), entry.getValue());
            }
        }

        return param;
    }

    public static String getQueryString(HttpServletRequest request){
        Enumeration<String> paramNameEnum = request.getParameterNames();

        String queryString = "";

        while(paramNameEnum.hasMoreElements()){
            String paramName = paramNameEnum.nextElement();

            String[] paramValues = request.getParameterValues(paramName);

            for(String paramValue : paramValues){
                queryString += String.format("%s=%s&", paramName, paramValue);
            }
        }

        return queryString;
    }
/*
    public static String getParameterOfEmail(HttpServletRequest request, String paramName){
        String[] paramValues = UniRequest.getParameterValues(request, paramName);

        return StringUtil.join(paramValues, "@");
    }

    public static String getParameterOfPhone(HttpServletRequest request, String paramName){
        String[] paramValues = UniRequest.getParameterValues(request, paramName);

        return StringUtil.join(paramValues, "-");
    }

    public static String getParameterOfAddress(HttpServletRequest request, String paramName){
        String[] paramValues = UniRequest.getParameterValues(request, paramName);

        return StringUtil.joinAddress(paramValues);
    }

    public static String getParameterWithJoined(HttpServletRequest request, String paramName, String seperator){
        String[] paramValues = UniRequest.getParameterValues(request, paramName);

        return StringUtil.join(paramValues, seperator);
    }*/

    public static String getRemoteAddr(HttpServletRequest request) {
        String clientIp = "";

        clientIp = request.getHeader("X-Forwarded-For");

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_CLIENT_IP");
        }

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }

        return XSSFilterUtil.doFilter(clientIp);
    }

    public static String getUriWithQuery(HttpServletRequest request){
        String queryString = request.getQueryString();

        if(StringUtil.isEmpty(queryString)){
            return request.getRequestURI();
        }

        return String.format("%s?%s", request.getRequestURI(), queryString);
    }

    public static String getBackUrl(HttpServletRequest request)throws BaseException{
        return getBackUrl(UniRequest.getUriWithQuery(request));
    }

    public static String getBackUrl(String url) throws BaseException {
        String backUrl = "";

        try {
            backUrl = String.format("backUrl=%s", URLEncoder.encode(url, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new BaseException(e);
        }

        return backUrl;
    }

    public static List<Integer> convertStrToArray(String str) {
    	List<Integer> idxArray = new ArrayList<Integer>();
    	
    	if (StringUtil.isNotEmpty(str)) {
    		if (str.indexOf(",") >= 0) {
	
	    		String[] arr = str.split(",");
	    		
	    		int arrayLength = arr.length;
	    		
	    		for (int idx = 0; idx < arrayLength; idx++) {
	    			idxArray.add(NumberUtil.toInt(arr[idx]));
	    		}
	    	} else {
	    		idxArray.add(NumberUtil.toInt(str));
	    	}
    	}
    	
    	return idxArray;
    }
}
