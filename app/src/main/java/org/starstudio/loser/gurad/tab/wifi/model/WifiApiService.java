package org.starstudio.loser.gurad.tab.wifi.model;

import android.database.Observable;

import org.starstudio.loser.gurad.tab.wifi.bean.WifiRes;

import retrofit2.http.GET;

/**
 * Created by as on 2017/9/16.
 */

public interface WifiApiService {
    @GET("wifi")
    io.reactivex.Observable<WifiRes> getWifiApiFromInternet();
}
