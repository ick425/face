package com.github.face.utils;

import org.apache.commons.lang.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 日期处理工具类
 *
 * @author wcl
 */
public class DateUtils {
    /**
     * 获取当前日期
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getCurrentDay(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyyMMdd";
        }
        return format(localDateTime2Date(localDateTime), pattern);
    }

    /**
     * 格式化日期为字符串
     *
     * @param date    date
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTime类型转为Date
     *
     * @param localDateTime LocalDateTime object
     * @return Date object
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前月第一天
     *
     * @return LocalDate
     */
    public static LocalDate getFirstDateOfMonth() {
        LocalDate localDate = LocalDate.now();
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取当前月最后一天
     *
     * @return LocalDate
     */
    public static LocalDate getLastDateOfMonth() {
        LocalDate localDate = LocalDate.now();
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static void main(String[] args) {
        System.out.println(getFirstDateOfMonth());
        System.out.println(getLastDateOfMonth());
    }
}
