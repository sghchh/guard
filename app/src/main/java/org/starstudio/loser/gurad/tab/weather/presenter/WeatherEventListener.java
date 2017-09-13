package org.starstudio.loser.gurad.tab.weather.presenter;

import org.starstudio.loser.gurad.common.mvp.base.MVPEventListener;

/**
 * Created by loser on 2017/9/9.
 */

public interface WeatherEventListener extends MVPEventListener {
    void onRefresh();
}
