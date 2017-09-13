package org.starstudio.loser.gurad.tab.main.presenter.impl;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import org.starstudio.loser.gurad.common.mvp.GuardPresenter;
import org.starstudio.loser.gurad.tab.main.model.IMainModel;
import org.starstudio.loser.gurad.tab.main.presenter.IMainPresenter;
import org.starstudio.loser.gurad.tab.main.presenter.MainEventListener;
import org.starstudio.loser.gurad.tab.main.view.IMainView;
import org.starstudio.loser.gurad.tab.weather.model.IWeatherModel;
import org.starstudio.loser.gurad.tab.weather.model.impl.WeatherModelImpl;
import org.starstudio.loser.gurad.tab.weather.presenter.IWeatherPresenter;
import org.starstudio.loser.gurad.tab.weather.presenter.impl.WeatherPresenterImpl;
import org.starstudio.loser.gurad.tab.weather.view.IWeatherView;
import org.starstudio.loser.gurad.tab.weather.view.impl.WeatherViewImpl;

import static android.content.ContentValues.TAG;

/**
 * Created by loser on 2017/9/9.
 *
 */

public class MainPresenterImpl extends GuardPresenter<IMainView, IMainModel> implements IMainPresenter {
    private IMainView mMainView;

    private IWeatherView mWeatherView;
    private IWeatherPresenter mWeatherPresenter;


    private MainEventListener mEventListener = new MainEventListener() {
        @Override
        public View getView(int position) {
            View view = null;
            Log.d(TAG, "getView: ");
            switch (position) {
                //在此处添加页面信息
                case 0:
                    Log.d(TAG, "getView: 添加了weather页面拉！！" + mWeatherView);
                    view = mWeatherView == null ? new View(getActivity()) : mWeatherView.getView();
                    break;
                case 1:
                    view = new View(getActivity());
                    break;
                case 2:
                    view = new View(getActivity());
                    break;
                case 3:
                    view = new View(getActivity());
                    break;
                default:
            }
            return view;
        }
    };

    public MainPresenterImpl(Activity activity) {
        super(activity);
        Log.d(TAG, "MainPresenterImpl: ");
    }

    @Override
    public void onAttach() {
        Log.d(TAG, "onAttach: ");
        mMainView = getView();
        mMainView.setEventListener(mEventListener);
        init();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach: ");
    }

    @Override
    public void init() {
        Log.d(TAG, "init: ");
        //初始化weather页面
        mWeatherPresenter = new WeatherPresenterImpl(getActivity());
        mWeatherView = new WeatherViewImpl(getActivity());
        mWeatherPresenter.addView(mWeatherView);
        mWeatherPresenter.setModel(new WeatherModelImpl());
        mWeatherPresenter.attach();
    }
}
