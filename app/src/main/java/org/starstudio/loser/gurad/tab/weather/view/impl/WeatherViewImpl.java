package org.starstudio.loser.gurad.tab.weather.view.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.starstudio.loser.gurad.R;
import org.starstudio.loser.gurad.common.mvp.GuardView;
import org.starstudio.loser.gurad.common.utils.TimeUtils;
import org.starstudio.loser.gurad.tab.weather.WeatherUtils;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherFutureBean;
import org.starstudio.loser.gurad.tab.weather.model.bean.WeatherNowBean;
import org.starstudio.loser.gurad.tab.weather.presenter.WeatherEventListener;
import org.starstudio.loser.gurad.tab.weather.view.IWeatherView;

import java.text.ParseException;

import static android.content.ContentValues.TAG;

/**
 * Created by loser on 2017/9/9.
 *
 */

public class WeatherViewImpl extends GuardView<WeatherEventListener> implements IWeatherView {
    private View mRootView;
    private TextView mDate;
    private TextView mAddress;
    private TextView mRelease;
    private TextView mHighTemperature;
    private TextView mLowTemperature;
    private TextView mTemperature;
    private TextView mMessage;
    private TextView mFeelLike;
    private TextView mWindPower;
    private TextView mWindDirection;
    private TextView mRainPercent;
    private Button mBeforeDay;
    private Button mNextDay;
    private TextView mDescription;
    private ImageView mImageView;


    public WeatherViewImpl(Activity activity) {
        super(activity);
        Log.d(TAG, "WeatherViewImpl: 加载了weather_main");
        mRootView = LayoutInflater.from(activity).inflate(R.layout.weather_main, null);
        mDate = (TextView) mRootView.findViewById(R.id.weather_main_date);
        mAddress = (TextView) mRootView.findViewById(R.id.weather_main_address);
        mRelease = (TextView) mRootView.findViewById(R.id.weather_main_release);
        mHighTemperature = (TextView) mRootView.findViewById(R.id.weather_main_high_temperature);
        mLowTemperature = (TextView) mRootView.findViewById(R.id.weather_main_low_temperature);
        mTemperature = (TextView) mRootView.findViewById(R.id.weather_main_temperature);
        mMessage = (TextView) mRootView.findViewById(R.id.weather_main_message);
        mFeelLike = (TextView) mRootView.findViewById(R.id.weather_main_feels_like);
        mWindPower = (TextView) mRootView.findViewById(R.id.weather_main_wind_power);
        mWindDirection = (TextView) mRootView.findViewById(R.id.weather_main_wind_direction);
        mRainPercent = (TextView) mRootView.findViewById(R.id.weather_main_rain_percent);
        mBeforeDay = (Button) mRootView.findViewById(R.id.weather_main_before);
        mNextDay = (Button) mRootView.findViewById(R.id.weather_main_next);
        mDescription = (TextView) mRootView.findViewById(R.id.weather_main_description);
        mImageView = (ImageView) mRootView.findViewById(R.id.weather_main_icon);
    }

    @Override
    public View getView() {
        return mRootView;
    }

    @SuppressLint({"NewApi", "SetTextI18n"})
    @Override
    public void setNow() {
        WeatherNowBean.Data data = WeatherUtils.getWeatherNowBean().getResults().get(0);
        mAddress.setText(data.getLocation().getName());
        String id = "_" + String.valueOf(WeatherUtils.getWeatherNowBean().getResults().get(0).getNow().getCode());
        Log.d(TAG, "setData: id = ? " + id);
        int imageId = getActivity().getResources().getIdentifier(id, "drawable", "org.starstudio.loser.gurad");
        mImageView.setImageDrawable(getActivity().getResources().getDrawable(imageId, null));
        mDescription.setText(data.getNow().getText() );
        mTemperature.setText(data.getNow().getTemperature() + "℃");
        try {
            mRelease.setText(TimeUtils.timeChangeTo(data.getLast_update()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFuture() {
        WeatherFutureBean.Daily daily = WeatherUtils.getWeatherFutureBean().getResults().get(0).getDaily().get(0);
        mDate.setText(daily.getDate());
        mHighTemperature.setText("最高温度：" + daily.getHigh() + "℃");
        mLowTemperature.setText("最低温度：" +daily.getLow() + "℃");
        mWindDirection.setText(daily.getWind_direction());
        mWindPower.setText(daily.getWind_scale() + "级");
    }

}
