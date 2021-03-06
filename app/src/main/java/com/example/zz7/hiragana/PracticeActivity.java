package com.example.zz7.hiragana;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;

public class PracticeActivity extends AppCompatActivity implements
        ViewPager.OnPageChangeListener {

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    public static  int flag=0;

    private RadioGroup rg;
    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private RadioButton rb_4;
    private ViewPager pager;
    private MediaPlayer mp;
    private Toolbar toolbar;
    private ToggleButton p_toggle;

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

        toolbar= (Toolbar) findViewById(R.id.p_toolbar);
        //setSupportActionBar(toolbar);
       // toolbar.inflateMenu(R.menu.menu_main);
        p_toggle= (ToggleButton) findViewById(R.id.p_toogle);

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


        p_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    flag=1;
                } else {
                    flag=0;
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
        setContentView(R.layout.activity_practice);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


//        switch (item.getItemId()) {
//            case R.id.menu_toggle:
//
//                if(birthSort){
//                    //change your view and sort it by Alphabet
//                    item.setIcon(icon1)
//                    item.setTitle(title1)
//                    birthSort=false;
//                }else{
//                    //change your view and sort it by Date of Birth
//                    item.setIcon(icon2)
//                    item.setTitle(title2)
//                    birthSort=true;
//                }
//                return true;



        //}
        return super.onOptionsItemSelected(item);

    }

}
