package org.starstudio.loser.gurad.tab.main.view;

import android.view.View;

import org.starstudio.loser.gurad.common.mvp.base.IMVPView;
import org.starstudio.loser.gurad.tab.main.presenter.MainEventListener;

/**
 * Created by loser on 2017/9/9.
 *
 */

public interface IMainView extends IMVPView<MainEventListener> {
    View getView();
}
