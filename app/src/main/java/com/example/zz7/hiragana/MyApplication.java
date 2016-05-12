package com.example.zz7.hiragana;

import android.app.Application;

/**
 * Created by zz7 on 5/12/16.
 */
public class MyApplication extends Application {

    private int flag;

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }
}
