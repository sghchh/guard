package org.starstudio.loser.gurad.tab.wifi.presenter;

import android.app.Activity;
import android.database.Observable;

import org.starstudio.loser.gurad.common.mvp.GuardPresenter;
import org.starstudio.loser.gurad.tab.wifi.bean.WifiRes;
import org.starstudio.loser.gurad.tab.wifi.model.WifiApiManager;
import org.starstudio.loser.gurad.tab.wifi.view.WifiViewImpl;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by as on 2017/9/16.
 */

public class WifiPresenterImpl extends GuardPresenter<WifiViewImpl,WifiApiManager> {
    private WifiViewImpl wifiView;
    private WifiRes mWifiRes;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public WifiPresenterImpl(Activity activity) {
        super(activity);
    }

    @Override
    public void onAttach() {
        this.wifiView.attachPresenter(this);
    }

    @Override
    public void onDetach() {
        this.wifiView.attachPresenter(null);
    }

    public WifiRes getmWifiRes()
    {
        return this.mWifiRes;
    }
    public void doGetApiFromInternet()
    {
        io.reactivex.Observable<WifiRes> observable=WifiApiManager.getWifiApiFromInternet();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WifiRes>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull WifiRes wifiRes) {
                        mWifiRes=wifiRes;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        (wifiView.getEventListener()).onError();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
        compositeDisposable.clear();
        this.onDetach();
    }

}
