package org.starstudio.loser.gurad.tab.wifi.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.starstudio.loser.gurad.R;
import org.starstudio.loser.gurad.tab.wifi.bean.WifiRes;
import org.starstudio.loser.gurad.tab.wifi.view.WifiHolder;

import javax.annotation.Nonnull;

/**
 * Created by as on 2017/9/16.
 */

public class WifiAdapter extends RecyclerView.Adapter<WifiHolder> {

    private WifiRes data=null;
    @Override
    public WifiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.wifi_layout,parent,false);
        return new WifiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WifiHolder holder, int position) {
        holder.setViewContent(data.getData().getWifilist().get(position));
    }

    @Override
    public int getItemCount() {
        return data.getData().getWifilist().size();
    }

    public void attachData(@Nonnull WifiRes wifiRes)
    {
        this.data=wifiRes;
    }
}
