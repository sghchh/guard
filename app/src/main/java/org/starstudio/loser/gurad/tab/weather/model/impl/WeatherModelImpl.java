package org.starstudio.loser.gurad.tab.weather.model.impl;

import android.widget.Toast;

import com.trello.rxlifecycle2.android.ActivityEvent;

import org.starstudio.loser.gurad.common.GuardActivity;
import org.starstudio.loser.gurad.common.bese.Base;
import org.starstudio.loser.gurad.common.mvp.GuardModel;
import org.starstudio.loser.gurad.tab.weather.WeatherUtils;
import org.starstudio.loser.gurad.tab.weather.api.service.WeatherApiService;
import org.starstudio.loser.gurad.tab.weather.model.IWeatherModel;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by loser on 2017/9/9.
 *
 */

public class WeatherModelImpl extends GuardModel implements IWeatherModel {

    @Override
    public Observable<WeatherNowBean> getNowWeather(final GuardActivity activity, String city) {
        return WeatherApiService.getInstance().fetchNow(Base.WEATHER_KEY, city)
                    .compose(activity.<WeatherNowBean>bindUntilEvent(ActivityEvent.DESTROY))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<WeatherFutureBean> getFutureWeather(GuardActivity activity, String city) {
        return WeatherApiService.getInstance().fetchFuture(Base.WEATHER_KEY, city)
                .compose(activity.<WeatherFutureBean>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
