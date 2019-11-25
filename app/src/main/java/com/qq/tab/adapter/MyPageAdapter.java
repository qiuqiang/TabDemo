package com.qq.tab.adapter;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by QiuQ on 2017-07-10.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> titleList;


    public MyPageAdapter(FragmentManager fm, List<Fragment> list, List<String> titleList) {
        super(fm);
        this.list = list;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (list.size() == titleList.size()) {
            return titleList.get(position);
        } else {
            return "";
        }
    }


}
