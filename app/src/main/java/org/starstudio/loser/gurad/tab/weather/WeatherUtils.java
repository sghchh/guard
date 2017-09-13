package org.starstudio.loser.gurad.tab.weather;

import android.util.Log;

import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;

import static android.content.ContentValues.TAG;

/**
 * Created by loser on 2017/9/10.
 *
 */

public class WeatherUtils {
    private static WeatherNowBean mWeatherNowBean;
    private static WeatherFutureBean mWeatherFutureBean;

    public static WeatherFutureBean getWeatherFutureBean() {
        return mWeatherFutureBean;
    }

    public static void setWeatherFutureBean(WeatherFutureBean mWeatherFutureBean) {
        WeatherUtils.mWeatherFutureBean = mWeatherFutureBean;
    }

    public static WeatherNowBean getWeatherNowBean() {
        return mWeatherNowBean;
    }

    public static void setWeatherNowBean(WeatherNowBean weatherNowBean) {
        Log.d(TAG, "setWeatherNowBean: setbean hahha");
        mWeatherNowBean = weatherNowBean;
    }
}
