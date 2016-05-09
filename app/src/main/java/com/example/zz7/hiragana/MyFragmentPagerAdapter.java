package com.example.zz7.hiragana;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import static com.example.zz7.hiragana.PracticeActivity.PAGE_FOUR;
import static com.example.zz7.hiragana.PracticeActivity.PAGE_ONE;
import static com.example.zz7.hiragana.PracticeActivity.PAGE_THREE;
import static com.example.zz7.hiragana.PracticeActivity.PAGE_TWO;

/**
 * Created by zz7 on 16-4-3.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    private final int pageCount = 4;

    private Fragment1 fragment1 = null;
    private Fragment2 fragment2 = null;
    private Fragment3 fragment3 = null;
    private Fragment4 fragment4 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case PAGE_ONE:
                fragment = fragment1;
                break;
            case PAGE_TWO:
                fragment = fragment2;
                break;
            case PAGE_THREE:
                fragment = fragment3;
                break;
            case PAGE_FOUR:
                fragment = fragment4;
        }
        return fragment;
    }


    @Override
    public int getCount() {

        return pageCount;
    }
    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }



}
