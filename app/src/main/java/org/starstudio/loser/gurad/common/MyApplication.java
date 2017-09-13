package org.starstudio.loser.gurad.common;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by loser on 2017/9/7.
 * 主要初始化数据库
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化context
        AppContext.init(this);

        Realm.init(this);
    }
}
