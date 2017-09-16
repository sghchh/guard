package org.starstudio.loser.gurad.tab.wifi.view;

import android.widget.Toast;

import org.starstudio.loser.gurad.common.AppContext;
import org.starstudio.loser.gurad.common.mvp.base.MVPEventListener;
import org.starstudio.loser.gurad.tab.wifi.bean.Wifi;
import org.starstudio.loser.gurad.tab.wifi.bean.WifiRes;

/**
 * Created by as on 2017/9/16.
 */

public class WifiEventListener implements MVPEventListener {

    /**
     * 网络访问失败的时候调用
     * 在Rxjava中的Subscriber的onError中回调
     */
    public static void onError()
    {
        Toast.makeText(AppContext.get(),"出错了", Toast.LENGTH_SHORT).show();
    }

    public WifiRes onSuccess(WifiRes wifiRes)
    {
        return wifiRes;
    }
}
