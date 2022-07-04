package com.naturaltel.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateUtils {
    private static final String DEFAULT_DATE_FORMAT     = "yyyyMMdd";
    private static final String DEFAULT_TIME_FORMAT     = "HHmmss";
    private static final String DEFAULT_DATETIME_FORMAT = DEFAULT_DATE_FORMAT + DEFAULT_TIME_FORMAT;
    private static final Date   nullDate                = new Date(0);

    private static final Logger logger = LogManager.getLogger(DateUtils.class);

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

    private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> sdfThread = sdfMap.get(pattern);
        if (sdfThread == null) {
            synchronized (DateUtils.class) {
                sdfThread = sdfMap.get(pattern);
                if (sdfThread == null) {
                    logger.debug("Put new instance of sampleDateFormat which pattern is {} into map.", pattern);
                    sdfThread = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            logger.debug("Thread: {} initialized simpleDateFormat which pattern is {}.", Thread.currentThread(),
                                    pattern);
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, sdfThread);
                }
            }
        }
        return sdfThread.get();
    }

    public static DateFormat getDefaultDateFormatter() {
        return getFormatter(DEFAULT_DATE_FORMAT);
    }

    public static DateFormat getDefaultTimeFormatter() {
        return getFormatter(DEFAULT_TIME_FORMAT);
    }

    public static DateFormat getDefaultDateTimeFormatter() {
        return getFormatter(DEFAULT_DATETIME_FORMAT);
    }


    public static DateFormat getFormatter(final String pattern) {
        return getSimpleDateFormat(pattern);
    }

    public static Date parseDate(DateFormat formatter, String dateStr) {
        if (StringUtils.isNotBlank(dateStr)) {
            try {
                return formatter.parse(dateStr);
            } catch (Exception ex) {
                logger.error("Exception occurred: {}", ex.getMessage());
            }
        }
        return null;
    }

    public static Date parseDate(String pattern, String dateStr) {
        return parseDate(getSimpleDateFormat(pattern), dateStr);
    }

    public static Date parseDate(String dateStr) {
        return parseDate(getDefaultDateFormatter(), dateStr);
    }

    public static Date parseTime(String dateStr) {
        return parseDate(getDefaultTimeFormatter(), dateStr);
    }

    public static Date parseDateTime(String dateStr) {
        return parseDate(getDefaultDateTimeFormatter(), dateStr);
    }

    public static DateFormat getDatetimeFormatter(Locale locale) {
        if (locale == null) {
            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        } else {
            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
        }
    }

    public static DateFormat getDateFormatter(Locale locale) {
        if (locale == null) {
            return DateFormat.getDateInstance(DateFormat.SHORT);
        } else {
            return DateFormat.getDateInstance(DateFormat.SHORT, locale);
        }
    }

    public static DateFormat getTimeFormatter(Locale locale) {
        if (locale == null) {
            return DateFormat.getTimeInstance(DateFormat.SHORT);
        } else {
            return DateFormat.getTimeInstance(DateFormat.SHORT, locale);
        }
    }

    public static String formatDatetime(Date datetime, Locale locale) {
        if (datetime != null) {
            if (!isDateEquals(nullDate, datetime)) {
                return getDatetimeFormatter(locale).format(datetime);
            }
        }
        return "";
    }

    public static String format(String pattern, Date date) {
        return getSimpleDateFormat(pattern).format(date);
    }

    public static boolean isDateEquals(Date d1, Date d2) {
        Calendar calendar_d1 = getCalendar(d1);
        Calendar calendar_d2 = getCalendar(d2);
        ;
        return (calendar_d1.get(Calendar.YEAR) == calendar_d2.get(Calendar.YEAR)) &&
               (calendar_d1.get(Calendar.MONTH) == calendar_d2.get(Calendar.MONTH)) &&
               (calendar_d1.get(Calendar.DAY_OF_MONTH) == calendar_d2.get(Calendar.DAY_OF_MONTH));
    }

    public static Date getSQLDate(Date date) {
        Calendar calendar = getCalendar(date);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getNow() {
        return getSQLDate(null);
    }

    public static Date getToday() {
        return getDateStart(new Date());
    }

    public static Date getDateStart(Date date) {
        if (date != null) {
            Calendar calendar = getCalendar(date, 0, 0, 0, 0);
            return calendar.getTime();
        }
        return null;
    }

    public static Date getDayEnd(Date date) {
        if (date != null) {
            Calendar calendar = getCalendar(date, 23, 59, 59, 999);
            return calendar.getTime();
        }
        return null;
    }

    public static Calendar getCalendar(Date date) {
        return getCalendar(date, null, null, null, null);
    }

    public static Calendar getCalendar(Date date, Integer hour, Integer min, Integer sec, Integer millisecond) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        if (hour != null) {
            calendar.set(Calendar.HOUR_OF_DAY, hour);
        }
        if (min != null) {
            calendar.set(Calendar.MINUTE, min);
        }
        if (sec != null) {
            calendar.set(Calendar.SECOND, sec);
        }
        if (millisecond != null) {
            calendar.set(Calendar.MILLISECOND, millisecond);
        }
        return calendar;
    }

    public static Date currentTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static String autoFormat(String dateTime) throws ParseException {
        if (new SimpleDateFormat("yyyy-MM-dd").parse(dateTime).compareTo(currentTime()) > 0) {
            dateTime = new SimpleDateFormat("yyyy-MM-dd").format(currentTime());
        }
        return dateTime;
    }

}