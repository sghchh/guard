package org.starstudio.loser.gurad.tab.wifi.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.starstudio.loser.gurad.R;
import org.starstudio.loser.gurad.tab.wifi.bean.Wifi;

/**
 * Created by as on 2017/9/16.
 */

public class WifiHolder extends RecyclerView.ViewHolder {

    public ImageView wifiImage;
    public TextView wifiName,wifiPassword;
    public WifiHolder(View itemView) {
        super(itemView);
        wifiImage=(ImageView)itemView.findViewById(R.id.wifi_image);
        wifiName=(TextView)itemView.findViewById(R.id.wifi_name);
        wifiPassword=(TextView)itemView.findViewById(R.id.wifi_password);
    }

    public void setViewContent(Wifi wifi)
    {
        this.wifiName.setText(wifi.getName());
        this.wifiPassword.setText(wifi.getPassword());
    }
}
