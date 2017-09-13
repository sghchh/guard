package org.starstudio.loser.gurad.common.mvp;

import android.app.Activity;

import org.starstudio.loser.gurad.common.mvp.base.IMVPView;
import org.starstudio.loser.gurad.common.mvp.base.MVPEventListener;

/**
 * Created by loser on 2017/9/7.
 * BaseView类  所有的View都继承这个类
 */

public class GuardView<E extends MVPEventListener> implements IMVPView<E> {
    private E mEventListener = null;
    private Activity mActivity;

    public GuardView(Activity activity) {
        this.mActivity = activity;
    }

    public final Activity getActivity() {
        return mActivity;
    }

    @Override
    public void setEventListener(E eventListener) {
        this.mEventListener = eventListener;
    }

    public E getEventListener() {
        return mEventListener;
    }
}
