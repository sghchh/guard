package org.starstudio.loser.gurad.common.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lsoer on 2017/9/8.
 * 用来初始化okhttp 和 retrofit
 */

public class Client {
    private static Client sInstance;
    private Retrofit mRetrofit;

    private Client() {

    }

    public Retrofit getClient() {
        return mRetrofit;
    }

    public static synchronized Client getsInstance(String url) {
        if (sInstance == null) {
            sInstance = new Client();

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            sInstance.mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sInstance;
    }
}
