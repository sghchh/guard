package org.starstudio.loser.gurad.tab.weather.view;

import android.view.View;

import org.starstudio.loser.gurad.common.mvp.base.IMVPView;
import org.starstudio.loser.gurad.tab.weather.presenter.WeatherEventListener;

/**
 * Created by loser on 2017/9/9.
 *
 */

public interface IWeatherView extends IMVPView<WeatherEventListener>{
    View getView();
    //设置数据
    void setNow();
    void setFuture();
}
