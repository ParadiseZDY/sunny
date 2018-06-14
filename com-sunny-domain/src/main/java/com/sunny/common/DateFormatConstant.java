package com.sunny.common;

import java.text.SimpleDateFormat;

/**
 * @author dongyangz
 * @date 2018/6/14
 */
public class DateFormatConstant {

    public static ThreadLocal<SimpleDateFormat> yMd = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static ThreadLocal<SimpleDateFormat> yMdHms = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        }
    };
}
