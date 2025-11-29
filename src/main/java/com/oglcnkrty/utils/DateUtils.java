package com.oglcnkrty.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String currentDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    return sdf.format(date);
    }
}
