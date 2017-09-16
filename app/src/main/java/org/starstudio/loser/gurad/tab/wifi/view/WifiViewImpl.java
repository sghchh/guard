package org.starstudio.loser.gurad.tab.wifi.view;

import android.app.Activity;

import org.starstudio.loser.gurad.common.mvp.GuardView;
import org.starstudio.loser.gurad.common.mvp.base.IMVPView;
import org.starstudio.loser.gurad.tab.wifi.bean.WifiRes;
import org.starstudio.loser.gurad.tab.wifi.presenter.WifiPresenterImpl;
import org.starstudio.loser.gurad.tab.wifi.view.adapter.WifiAdapter;

/**
 * Created by as on 2017/9/16.
 */

public class WifiViewImpl extends GuardView<WifiEventListener> implements IMVPView<WifiEventListener> {

    private WifiPresenterImpl presenter;
    public WifiViewImpl(Activity activity) {
        super(activity);
    }

    public void attachPresenter(WifiPresenterImpl wifiPresenter)
    {
        this.presenter=wifiPresenter;
    }

    public void pushWifiAdapterData(WifiAdapter adapter)
    {
        adapter.attachData(presenter.getmWifiRes());
    }
}
