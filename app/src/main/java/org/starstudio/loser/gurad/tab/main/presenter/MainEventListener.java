package org.starstudio.loser.gurad.tab.main.presenter;

import android.view.View;

import org.starstudio.loser.gurad.common.mvp.base.MVPEventListener;

/**
 * Created by loser on 2017/9/9.
 *
 */

public interface MainEventListener extends MVPEventListener {
    View getView(int position);
}
