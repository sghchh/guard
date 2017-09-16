package org.starstudio.loser.gurad.tab.wifi.bean;

import java.util.List;

/**
 * Created by as on 2017/9/16.
 * Wifi的Api返回的第二层数据
 */

public class WifiData {
    private String contact;
    private List<Wifi> wifilist;

    public String getContact()
    {
        return this.contact;
    }
    public List<Wifi> getWifilist()
    {
        return this.wifilist;
    }

}

