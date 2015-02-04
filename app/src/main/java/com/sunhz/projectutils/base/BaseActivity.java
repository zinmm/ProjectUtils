package com.sunhz.projectutils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

    protected Context mContext;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        BaseApplication.getInstance().addActivity(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.getInstance().removeActivity(this);
    }
}
