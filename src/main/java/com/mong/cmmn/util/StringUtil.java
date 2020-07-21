package com.mong.cmmn.util;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static String defaultString(String str){
        return StringUtils.defaultString(str);
    }
    
    public static String defaultString(String str, String defaultStr){
        return StringUtils.defaultString(str, defaultStr);
    }
    
    public static String defaultIfBlank(String str, String defaultStr) {
        return StringUtils.defaultIfBlank(str, defaultStr);
    }
    
    public static boolean equals(String str1, String str2){
        return StringUtils.equals(str1, str2);
    }

    public static boolean notEquals(String str1, String str2){
        return !StringUtils.equals(str1, str2);
    }

    public static String removeEnd(String str, String remove){
        return StringUtils.removeEnd(str, remove);
    }

    public static String replace(String text, String searchString, String replacement){
        return StringUtils.replace(text, searchString, replacement);
    }

    public static String replaceAll(String text, String searchString, String replacement){
        return StringUtils.replaceAll(text, searchString, replacement);
    }
    
    public static String[] replaceAll(String[] textArr, String searchString, String replacement){
        if(textArr == null ){
            return new String[]{};
        }

        for(int i = 0; i < textArr.length; i++){
            textArr[i] = replaceAll(textArr[i], searchString, replacement);
        }

        return textArr;
    }

    public static String toString(Object obj){
        //return Objects.toString(obj);
        return obj == null ? null : obj.toString();
    }

    public static boolean isEmpty(String str){
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return StringUtils.isNotEmpty(str);
    }

    public static boolean isBlank(String str){
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str){
        return StringUtils.isNotBlank(str);
    }

    public static boolean startsWith(CharSequence str, CharSequence prefix){
        return StringUtils.startsWith(str, prefix);
    }

    public static boolean endsWith(String str, String suffix){
        return StringUtils.endsWith(str, suffix);
    }

    public static boolean endsWithAny(String str, String... searchStrings){
        return StringUtils.endsWithAny(str, searchStrings);
    }

    public static boolean endsWithIgnoreCase(String str, String suffix){
        return StringUtils.endsWithIgnoreCase(str, suffix);
    }

    public static boolean endsWithAnyIgnoreCase(String str, String... searchStrings){
        if(searchStrings == null){
            return false;
        }

        for(String searchString : searchStrings){
            if(endsWithIgnoreCase(str, searchString)){
                return true;
            }
        }

        return false;
    }

    public static boolean contains(String str, String searchStr) {
        return StringUtils.contains(str, searchStr);
    }

    public static boolean isNumeric(CharSequence cs) {
        return StringUtils.isNumeric(cs);
    }
    
    public static boolean isNumeric(String s) {
		try {
		    Double.parseDouble(s);
		    return true;
		} catch(NumberFormatException e) {
		    return false;
		}
    }
    
    public static boolean isNumAlpha(String str) {
    	String pattern = "^[0-9a-zA-z]*$";
    	
    	return Pattern.matches(pattern, str);
    }


    public static String nl2br(String str) {
        return (str != null) ? str.replace("\n", "<br />") : "";
    }

    public static String getFormatStr(int val, int size) {
        String value = "";

        if (size == 0) size = 1;

        value = String.format("%0" + size + "d", val);

        return value;
    }

    public static String convertRemark(String str) {
        String tmp = "";

        if (str == null) return tmp;

        tmp = str.replace("<BR", "<br").replace("<br>", "<br/>");
        tmp = tmp.replace("<P>", "<p>").replace("</P>", "</p>");

        tmp = tmp.replace("&amp;", "&");
        tmp = tmp.replace("&lt;", "<").replace("&gt;", ">");

        //tmp = XSSFilterUtil.doFilter(tmp);

        tmp = stripXSS(tmp);
        tmp = cleanScript(tmp);

        return tmp;
    }

    public static String cleanScript(String value) {

        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");

        //value = value.replaceAll("'", "& #39;");

        value = value.replaceAll("eval\\((.*)\\)", "");

        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

        value = value.replaceAll("script", "");

        value = org.springframework.web.util.HtmlUtils.htmlEscape(value);
        //SQL injection characters
        //value = StringEscapeUtils.escapeSql(value);

        return value;
    }

    public static String stripXSS(String value) {
        if (value != null) {
            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
            // avoid encoded attacks.
            // value = ESAPI.encoder().canonicalize(value);

            // Avoid null characters
            value = value.replaceAll("", "");

            // Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("<img", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("src=", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            //	          // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");


            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            
            scriptPattern = Pattern.compile("<iframe", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            
            scriptPattern = Pattern.compile("</iframe>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            
            scriptPattern = Pattern.compile("alert", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("onmouseover", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("window(.*?)location", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
        }
        return value;
    }


    public static String stripValueXSS(String value) {
        if (value != null) {
            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
            // avoid encoded attacks.
            // value = ESAPI.encoder().canonicalize(value);

            // Avoid null characters
            value = value.replaceAll("", "");

            // Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("http-equiv='refresh'", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("<iframe", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            
            scriptPattern = Pattern.compile("</iframe>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");
            
            scriptPattern = Pattern.compile("alert", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("onmouseover", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("window(.*?)location", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
        }
        return value;
    }

    public static int length(CharSequence cs){
        return StringUtils.length(cs);
    }
}
