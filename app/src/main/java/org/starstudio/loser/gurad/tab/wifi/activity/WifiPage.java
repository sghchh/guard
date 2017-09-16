package org.starstudio.loser.gurad.tab.wifi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.starstudio.loser.gurad.R;
import org.starstudio.loser.gurad.common.GuardActivity;
import org.starstudio.loser.gurad.tab.wifi.presenter.WifiPresenterImpl;
import org.starstudio.loser.gurad.tab.wifi.view.WifiEventListener;
import org.starstudio.loser.gurad.tab.wifi.view.WifiViewImpl;
import org.starstudio.loser.gurad.tab.wifi.view.adapter.WifiAdapter;

public class WifiPage extends GuardActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private WifiAdapter wifiAdapter;
    private WifiPresenterImpl presenter;
    private WifiEventListener eventListener;
    private WifiViewImpl wifiView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_page);

        init();
        attach();
    }

    public void init()
    {
        presenter=new WifiPresenterImpl(this);
        eventListener=new WifiEventListener();
        wifiView=new WifiViewImpl(this);

        wifiAdapter=new WifiAdapter();
        linearLayoutManager=new LinearLayoutManager(this);
    }

    public void attach()
    {
        presenter.addView(wifiView);
        wifiView.attachPresenter(presenter);
        presenter.doGetApiFromInternet();

        //进行一个循环等待数据加载完
        do {
        }while(presenter.getmWifiRes()!=null);

        /*
        等到adapter中有数据了，才初始化RecyclerView，并且为RecyclerView绑定布局和适配器
         */
        wifiView.pushWifiAdapterData(wifiAdapter);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_wifi);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(wifiAdapter);

    }
}
