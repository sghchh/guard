package org.starstudio.loser.gurad.common.mvp.base;

/**
 * Created by lsoer on 2017/9/7.
 * 基础接口  泛型为MVPEventListener的子类
 * 通过在MVPEventListener中调用方法来实现View与Presenter的交互
 */

public interface IMVPView<E extends MVPEventListener> {
    //view与Presenter交互
    void setEventListener(E eventListener);
}
