package com.example.zz7.hiragana;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener {

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    private RadioGroup rg;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private RadioButton rb_4;
    private ViewPager pager;
    private MediaPlayer mp;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    public void init() {

        rg = (RadioGroup) findViewById(R.id.rg);
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);

        pager = (ViewPager) findViewById(R.id.pager);

        MyFragmentPagerAdapter myFragmentPagerAdapter
                = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(myFragmentPagerAdapter);
        pager.setCurrentItem(0);
        pager.addOnPageChangeListener(this);
        rb_1.setChecked(true);


        //check_listener
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        pager.setCurrentItem(PAGE_ONE);
                        break;
                    case R.id.rb_2:
                        pager.setCurrentItem(PAGE_TWO);
                        break;
                    case R.id.rb_3:
                        pager.setCurrentItem(PAGE_THREE);
                        break;
                    case R.id.rb_4:
                        pager.setCurrentItem(PAGE_FOUR);
                        break;
                }
            }
        });
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        //  boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        Log.e("HEHE", "clicked!");
        switch (view.getId()) {

            case R.id.rb_1:
                rb_1.setChecked(true);
                Log.e("HEHE", "rb_1 clicked!");
                break;
            case R.id.rb_2:
                rb_2.setChecked(true);
                Log.e("HEHE", "rb_2 clicked!");
                break;
            case R.id.rb_3:
                rb_3.setChecked(true);
                Log.e("HEHE", "rb_3 clicked!");
                break;
            case R.id.rb_4:
                rb_4.setChecked(true);
                Log.e("HEHE", "rb_4 clicked!");
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (pager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_1.setChecked(true);
                    pager.setCurrentItem(PAGE_ONE);
                    break;
                case PAGE_TWO:
                    rb_2.setChecked(true);
                    pager.setCurrentItem(PAGE_TWO);
                    break;
                case PAGE_THREE:
                    rb_3.setChecked(true);
                    pager.setCurrentItem(PAGE_THREE);
                    break;
                case PAGE_FOUR:
                    rb_4.setChecked(true);
                    pager.setCurrentItem(PAGE_FOUR);
                    break;
            }

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }


    public void ButtonOnClick(View v) {
        int id = v.getId();
        String name = getResources().getResourceEntryName(v.getId());
        Log.e("button", name);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/" + name);
        Log.e("uri", uri.toString());


        if (mp != null) {
            mp.reset();
        }
        mp = MediaPlayer.create(v.getContext(), uri);
        mp.start();
    }

}
