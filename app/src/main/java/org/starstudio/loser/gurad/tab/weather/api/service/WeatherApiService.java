package org.starstudio.loser.gurad.tab.weather.api.service;


import org.starstudio.loser.gurad.common.bese.Base;
import org.starstudio.loser.gurad.common.http.Client;
import org.starstudio.loser.gurad.tab.weather.api.WeatherApi;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;

import io.reactivex.Observable;

/**
 * Created by loser on 2017/9/10.
 * 一个api服务类
 */

public class WeatherApiService {
    private static WeatherApiService sInstance;
    private WeatherApi mApi;

    private WeatherApiService(WeatherApi api) {
        this.mApi = api;
    }

    public static synchronized WeatherApiService getInstance() {
        if (sInstance == null) {
            sInstance = new WeatherApiService(Client.getsInstance(Base.WEATHER_URL).getClient().create(WeatherApi.class));
        }
        return sInstance;
    }

    public Observable<WeatherFutureBean> fetchFuture(String key, String location) {
        return mApi.fetchFutureWeather(key, location);
    }

    public Observable<WeatherNowBean> fetchNow(String key, String location) {
        return mApi.fetchNowWeather(key, location);
    }
}
