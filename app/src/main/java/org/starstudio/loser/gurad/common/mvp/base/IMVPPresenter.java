package org.starstudio.loser.gurad.common.mvp.base;

/**
 * Created by loser on 2017/9/7.
 * 基础接口 因为Presenter接口要可以和View和Model交互，所以需要泛型的添加
 */

public interface IMVPPresenter<V extends IMVPView, M extends IMVPModel> {
    //设置model
    void setModel(M model);

    //添加view
    void addView(V view);

    //进行View的初始化和一些初始的炒作
    void attach();

    //切断View和presenter的联系
    void detach();
}
