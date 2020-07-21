package com.mong.cmmn.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    public static Calendar getCalendar(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, day);

        return calendar;
    }

    public static int getMonthLasDay(int year, int month){
        Calendar calendar = getCalendar(year, month, 1);

        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getDayOfWeek(int year, int month, int day){
        Calendar calendar = getCalendar(year, month, day);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String getCurrentYear(){
        return getCurrentDateFormat("yyyy");
    }

    public static String getCurrentMonth(){
        return getCurrentDateFormat("MM");
    }

    public static String getCurrentDateFormat(String format){
        Calendar cld = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(cld.getTime());
    }

    public static String getDateFormat(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date addMonths(Date date, int amount){
        return DateUtils.addMonths(date, amount);
    }

    public static Date addDays(Date date, int amount){
        return DateUtils.addDays(date, amount);
    }

    public static Date addHours(Date date, int amount){
        return DateUtils.addHours(date, amount);
    }

    public static Date addYears(Date date, int amount){
        return DateUtils.addYears(date, amount);
    }

    public static Date parseDate(String str) throws ParseException {
        return DateUtils.parseDate(str, "yyyy-MM-dd");
    }

    public static Date parseDate(String str, String pattern) throws ParseException {
        return DateUtils.parseDate(str, pattern);
    }

    public static Date parseDate(String str, String pattern, Date defaultDate)  {
        Date parseDate = null;

        try {
            parseDate = DateUtils.parseDate(str, pattern);
        } catch (ParseException e) {
            parseDate = defaultDate;
        }

        return parseDate;
    }

    public static Date getDate(int year, int month, int day) throws ParseException {
        return parseDate(String.format("%d-%02d-%02d", year, month, day));
    }

    public static boolean isSameDay(Date date1, Date date2){
        return DateUtils.isSameDay(date1, date2);
    }

    public static long calculateDayGap(Date date1, Date date2){
        long diff = date2.getTime() - date1.getTime();

        return TimeUnit.MILLISECONDS.toDays(diff);
    }

    public static long calculateHourGap(Date date1, Date date2){
        long diff = date2.getTime() - date1.getTime();

        return TimeUnit.MILLISECONDS.toHours(diff);
    }

    public static int truncatedCompareTo(Date date1, Date date2, int field) {
        return DateUtils.truncatedCompareTo(date1, date2, field);
    }

    public static boolean isCurrentDateBetween(String startDateStr, String endDateStr, String pattern){
        Date startDate = null;
        Date endDate = null;
        Date date = new Date();

        try {
            startDate = parseDate(startDateStr, pattern);
        } catch (ParseException e) {
            //e.printStackTrace();
        }

        try {
            endDate = parseDate(endDateStr, pattern);
        } catch (ParseException e) {
            //e.printStackTrace();
        }

        if(startDate == null && endDate == null){
            return true;
        }else if(startDate == null){
            return endDate.after(date);
        }else if(endDate == null){
            return startDate.before(date);
        }else{
            return endDate.after(date) && startDate.before(date);
        }
    }

    public static void main(String[] args)throws ParseException{
        System.out.print(parseDate("2014-09-11 1:2", "yyyy-MM-dd HH:mm"));
    }
}
