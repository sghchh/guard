package org.starstudio.loser.gurad.common;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by loser on 2017/9/8.
 * BaseActivity 所有实现的Activity类都要继承这个类
 */

public class GuardActivity extends RxAppCompatActivity {
    public void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }

    public Activity getActivity() {
        return this;
    }

}
