package org.starstudio.loser.gurad.tab.weather.api;

import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by loser on 2017/9/10.
 * 处理api请求
 */

public interface WeatherApi {
    //@FormUrlEncoded
    @GET("weather/now.json")
    Observable<WeatherNowBean> fetchNowWeather(@Query("key") String key,
                                               @Query("location") String location);


    @GET("weather/daily.json")
    Observable<WeatherFutureBean> fetchFutureWeather(@Query("key") String key,
                                                     @Query("location") String location);
}
