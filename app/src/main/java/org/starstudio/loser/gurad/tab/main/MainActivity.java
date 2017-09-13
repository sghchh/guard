package org.starstudio.loser.gurad.tab.main;


import android.os.Bundle;
import org.starstudio.loser.gurad.R;
import org.starstudio.loser.gurad.common.GuardActivity;
import org.starstudio.loser.gurad.tab.main.model.impl.MainModelImpl;
import org.starstudio.loser.gurad.tab.main.presenter.IMainPresenter;
import org.starstudio.loser.gurad.tab.main.presenter.impl.MainPresenterImpl;
import org.starstudio.loser.gurad.tab.main.view.impl.MainViewImpl;


public class MainActivity extends GuardActivity {
    private IMainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mPresenter = new MainPresenterImpl(this);
        mPresenter.addView(new MainViewImpl(getActivity()));
        mPresenter.setModel(new MainModelImpl());
        mPresenter.attach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
