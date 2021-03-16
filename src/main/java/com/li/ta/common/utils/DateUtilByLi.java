package com.li.ta.common.utils;

import java.util.Date;

/**
 * 日期工具类
 *
 * @author baiye 2021/03/16 10:01 上午
 */
public class DateUtilByLi {

    public static void main(String[] args) {
        strToDate("");
    }

    /**
     * 字符串转日期类型
     * @param dateStr 日期格式字符串
     * @return 日期
     */
    public static Date strToDate (String dateStr) {

        short sh = -16385;
        int in = sh;
        byte by = (byte) sh;
        System.out.println("Type is : " + getType(sh) + ";\t Value is : " + sh); // Type is : java.lang.Short;	 Value is : 16385
        System.out.println("Type is : " + getType(in) + ";\t Value is : " + in); // Type is : java.lang.Integer;	 Value is : 16385
        System.out.println("Type is : " + getType(by) + ";\t Value is : " + by); // Type is : java.lang.Byte;	 Value is : 1




        return new Date();
    }

    public static String getType (Object obj) {
        return obj.getClass().getName().toString();
    }


    class Pattern {
        public static final String DATE = "yyyy-mm-dd";
    }

}
