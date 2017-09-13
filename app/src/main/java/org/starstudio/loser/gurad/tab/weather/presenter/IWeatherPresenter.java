package org.starstudio.loser.gurad.tab.weather.presenter;

import org.starstudio.loser.gurad.common.mvp.base.IMVPPresenter;
import org.starstudio.loser.gurad.tab.weather.model.IWeatherModel;
import org.starstudio.loser.gurad.tab.weather.view.IWeatherView;

/**
 * Created by loser on 2017/9/9.
 *
 */

public interface IWeatherPresenter extends IMVPPresenter<IWeatherView, IWeatherModel>{
    void getNow();
    void getFuture();
}
