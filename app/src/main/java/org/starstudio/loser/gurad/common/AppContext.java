package org.starstudio.loser.gurad.common;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * Created by loser on 2017/9/7.
 * 结合Application类来初始化Context
 */

public class AppContext {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext = null;

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public static Context get(){
        return mContext;
    }
}
