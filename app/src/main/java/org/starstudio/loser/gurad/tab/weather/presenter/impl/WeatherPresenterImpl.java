package org.starstudio.loser.gurad.tab.weather.presenter.impl;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import org.starstudio.loser.gurad.common.GuardActivity;
import org.starstudio.loser.gurad.common.mvp.GuardPresenter;
import org.starstudio.loser.gurad.tab.weather.WeatherUtils;
import org.starstudio.loser.gurad.tab.weather.model.IWeatherModel;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;
import org.starstudio.loser.gurad.tab.weather.presenter.IWeatherPresenter;
import org.starstudio.loser.gurad.tab.weather.presenter.WeatherEventListener;
import org.starstudio.loser.gurad.tab.weather.view.IWeatherView;
import org.starstudio.loser.gurad.tab.weather.view.impl.WeatherViewImpl;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * Created by loser on 2017/9/9.
 *
 */

public class WeatherPresenterImpl extends GuardPresenter<IWeatherView, IWeatherModel> implements IWeatherPresenter {
    private IWeatherView mView;
    private WeatherEventListener mEventListener = new WeatherEventListener() {
        @Override
        public void onRefresh() {

        }
    };


    public WeatherPresenterImpl(Activity activity) {
        super(activity);
    }

    @Override
    public void onAttach() {
        mView = getView();
        mView.setEventListener(mEventListener);
        Log.d(TAG, "onAttach: getNow???? 开始了吗");
        getNow();
        getFuture();
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void getNow() {
        getModel().getNowWeather((GuardActivity) getActivity(), "成都")
                .subscribe(new Observer<WeatherNowBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull WeatherNowBean weatherNowBean) {
                        if (weatherNowBean != null) {
                            WeatherUtils.setWeatherNowBean(weatherNowBean);
                        } else {

                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        if (WeatherUtils.getWeatherNowBean() != null) {
                            mView.setNow();
                        }
                    }
                });
    }

    @Override
    public void getFuture() {
        getModel().getFutureWeather((GuardActivity) getActivity(), "成都")
                .subscribe(new Observer<WeatherFutureBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull WeatherFutureBean weatherFutureBean) {
                        if (weatherFutureBean != null) {
                            WeatherUtils.setWeatherFutureBean(weatherFutureBean);
                        } else {

                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        if (WeatherUtils.getWeatherFutureBean() != null) {
                            mView.setFuture();
                        }
                    }
                });
    }
}
