package org.starstudio.loser.gurad.common.mvp;

import android.app.Activity;
import android.util.Log;

import org.starstudio.loser.gurad.common.mvp.base.IMVPModel;
import org.starstudio.loser.gurad.common.mvp.base.IMVPPresenter;
import org.starstudio.loser.gurad.common.mvp.base.IMVPView;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * Created by loser on 2017/9/7.
 * BasePresenter 所有的presenter类都继承这个presenter类
 */

public abstract class GuardPresenter<V extends IMVPView, M extends IMVPModel> implements IMVPPresenter<V, M> {
    private M mModel;
    private V mView;
    private Activity mActivity;

    //用来搜集所有的Rxjava线程，然后一起取消
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public GuardPresenter(Activity activity) {
        this.mActivity = activity;
    }

    public Activity getActivity() {
        return mActivity;
    }

    @Override
    public void setModel(M model) {
        this.mModel = model;
    }
    @Override
    public void addView(V view) {
        this.mView = view;
    }
    public final V getView() {
        return mView;
    }
    public final M getModel(){
        return mModel;
    }

    @Override
    public void attach() {
        Log.d(TAG, "attach: ");
        onAttach();
    }

    @Override
    public void detach() {
        if (mView != null) {
            mView = null;
        }
        if (mModel != null) {
            mModel = null;
        }
        onDetach();
    }

    //重写方法进行初始化操作（也可以在方法中调用init方法来初始化）
    public abstract void onAttach();

    //重写方法来切断联系后的操作
    public abstract void onDetach();

    public final CompositeDisposable getCompositeSubscription(){
        if (mCompositeDisposable != null) {
            return mCompositeDisposable;
        }
        return null;
    }

    public final void add(Disposable disposable){
        if (mCompositeDisposable != null) {
            mCompositeDisposable.add(disposable);
        }
    }

    public final void remove(Disposable disposable) {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.remove(disposable);
        }
    }

}
