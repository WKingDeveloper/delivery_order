package com.example.order.utils;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateUtils {

    public static Timestamp getThreeDaysAgo() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, -3);
        return new Timestamp(date.getTimeInMillis());
    }
}
