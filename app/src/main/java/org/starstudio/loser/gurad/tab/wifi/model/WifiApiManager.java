package org.starstudio.loser.gurad.tab.wifi.model;

import android.database.Observable;

import org.starstudio.loser.gurad.common.bese.Base;
import org.starstudio.loser.gurad.common.http.Client;
import org.starstudio.loser.gurad.common.mvp.GuardModel;
import org.starstudio.loser.gurad.common.mvp.base.IMVPModel;
import org.starstudio.loser.gurad.tab.wifi.bean.WifiRes;

import retrofit2.Retrofit;

/**
 * Created by as on 2017/9/16.
 * 封装了网络访问的实现，从网络获取api的实现直接通过静态方法实现
 */

public class WifiApiManager extends GuardModel implements IMVPModel {
    //内部有从网络获取数据的Retrofit
    private static Client mClient=Client.getsInstance(Base.WIFI_URL);

    private WifiApiManager(){};
    //从网络获取api
    public static io.reactivex.Observable<WifiRes> getWifiApiFromInternet(){
        Retrofit retrofit=WifiApiManager.mClient.getClient();
        WifiApiService wifiApiService=retrofit.create(WifiApiService.class);

        return wifiApiService.getWifiApiFromInternet();
    }

}
