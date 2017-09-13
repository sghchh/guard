package org.starstudio.loser.gurad.tab.main.view.impl;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.starstudio.loser.gurad.R;
import org.starstudio.loser.gurad.common.mvp.GuardView;
import org.starstudio.loser.gurad.tab.main.presenter.MainEventListener;
import org.starstudio.loser.gurad.tab.main.view.IMainView;

import static android.content.ContentValues.TAG;

/**
 * Created by loser on 2017/9/9.
 *
 */

public class MainViewImpl extends GuardView<MainEventListener> implements IMainView {
    private View mRootView;
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    public MainViewImpl(Activity activity) {
        super(activity);
        Log.d(TAG, "MainViewImpl: ");
        mRootView = LayoutInflater.from(activity).inflate(R.layout.activity_main, null);
        mViewPager = (ViewPager) activity.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MyAdapter());
        mBottomNavigationView = (BottomNavigationView) activity.findViewById(R.id.bottom_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.weather:
                        mViewPager.setCurrentItem(0, true);
                        break;
                    case R.id.card:
                        mViewPager.setCurrentItem(1, true);
                        break;
                    case R.id.wifi:
                        mViewPager.setCurrentItem(2,true);
                        break;
                    case R.id.member:
                        mViewPager.setCurrentItem(3,true);
                        break;
                    default:
                }
                return true;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            MenuItem mMenuItem;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mMenuItem != null) {
                    mMenuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                mMenuItem = mBottomNavigationView.getMenu().getItem(position);
                mMenuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public View getView() {
        Log.d(TAG, "getView: ");
        return mRootView;
    }


    private class MyAdapter extends PagerAdapter{
        private static final int SIZE = 4;

        MyAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return SIZE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            if (getEventListener() != null) {
                view = getEventListener().getView(position);
            }
            container.addView(view);
            return view;
        }
    }
}
