package org.starstudio.loser.gurad.common.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.content.ContentValues.TAG;


/**
 * Created by loser on 2017/9/10.
 * 解析时间
 */

public class TimeUtils {
    //解析如这类的时间:2016-09-03T00:00:00.000+08:00  yyyy-MM-dd'T'HH:mm:ss.SSSXXXX
    public static String timeChangeTo(String oldTime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = format.parse(oldTime);
        Log.d(TAG, "timeChangeTo: date is " + date.toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.getDefault());
        Date date1 = dateFormat.parse(date.toString());
        Log.d(TAG, "timeChangeTo: date1 is " + date1.toString());
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        return format1.format(date1) + "更新";
    }
}
