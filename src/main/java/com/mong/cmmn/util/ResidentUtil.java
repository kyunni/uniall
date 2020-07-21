package com.mong.cmmn.util;

/**
 * Created by ub-06 on 2016-12-06.
 */
public class ResidentUtil {
    /**
     * 주민등록번호로 나이를 알아낸다.
     * @param ssn
     * @return
     */
    public static String getAgeFromSSN(String ssn){
        String returnValue = "";
        if(ssn != null && !"".equals(ssn) && ssn.length()>6){
            int tmpYear = Integer.parseInt(ssn.substring(0,2));
            String tmpType = ssn.substring(7,8);
            int year = 2000;
            if("1".equals(tmpType) || "2".equals(tmpType)){
                year = 1900;
            }
            year = year + tmpYear;
            int nowYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            returnValue = String.valueOf(nowYear - year);
        }
        return returnValue;
    }

    /**
     * 회원관리에서 성별 구분 메소드(주민등록번호로 성별을 알아낸다)
     * @param ssn
     * @return
     */
    public static String getGenderFromSSN(String ssn){
        String returnValue = "";
        if(ssn != null && !"".equals(ssn) && ssn.length()>6){
            String tmpType = ssn.substring(7,8);
            if("1".equals(tmpType) || "3".equals(tmpType)){
                returnValue = "남성";
            }else{
                returnValue = "여성";
            }
        }
        return returnValue;
    }
}
