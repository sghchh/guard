package org.starstudio.loser.gurad.tab.wifi.bean;

/**
 * Created by as on 2017/9/16.
 * Wifi返回的api的第一层
 */

public class WifiRes {
    private int status;
    private WifiData data;
    private String message;

    public int getStatus()
    {
        return this.status;
    }

    public String getMessage()
    {
        return this.message;
    }

    public WifiData getData()
    {
        return this.data;
    }
}
