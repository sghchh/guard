package org.starstudio.loser.gurad.tab.main.presenter;

import org.starstudio.loser.gurad.common.mvp.base.IMVPPresenter;
import org.starstudio.loser.gurad.tab.main.model.IMainModel;
import org.starstudio.loser.gurad.tab.main.view.IMainView;

/**
 * Created by loser on 2017/9/9.
 *
 */

public interface IMainPresenter extends IMVPPresenter<IMainView, IMainModel> {
    void init();
}
