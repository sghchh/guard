package org.starstudio.loser.gurad.tab.weather.model;



import org.starstudio.loser.gurad.common.GuardActivity;
import org.starstudio.loser.gurad.common.mvp.base.IMVPModel;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;

import io.reactivex.Observable;

/**
 * Created by loser on 2017/9/9.
 *
 */

public interface IWeatherModel extends IMVPModel{
    //获取现在的天气信息
    Observable<WeatherNowBean> getNowWeather(final GuardActivity activity, String city);

    //获取未来3天的天气信息
    Observable<WeatherFutureBean> getFutureWeather(final GuardActivity activity, String city);
}
