package com.mong.cmmn.util;

/**
 * Created by ub-06 on 2017-01-03.
 */
public class FileSecurityUtil {

    public static String filterFileName(String fileName){

        fileName = StringUtil.replaceAll(fileName, "\\.\\.", "");
        fileName = StringUtil.replaceAll(fileName, "&", "");
        fileName = StringUtil.replaceAll(fileName, "\\\\", "");
        fileName = StringUtil.replaceAll(fileName, "/", "");

        return fileName;
    }

    public static String filterFileExtension(String fileExt){

        fileExt = StringUtil.replaceAll(fileExt, " ", "");
        fileExt = StringUtil.replaceAll(fileExt, "\\.", "");
        fileExt = StringUtil.replaceAll(fileExt, "\\\\", "");
        fileExt = StringUtil.replaceAll(fileExt, "&", "");
        fileExt = StringUtil.replaceAll(fileExt, "/", "");

        return fileExt;
    }

    public static void main(String[] args){
        System.out.println(filterFileName("..\\readme.txt"));
    }
}
