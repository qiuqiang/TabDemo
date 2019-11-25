package com.qq.tab;

import android.content.Context;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.qq.tab.adapter.MyPageAdapter;
import com.qq.tab.fragment.FragFive;
import com.qq.tab.fragment.FragFour;
import com.qq.tab.fragment.FragHome;
import com.qq.tab.fragment.FragMiddle;
import com.qq.tab.fragment.FragRight;
import com.qq.tab.fragment.FragSix;
import com.qq.tab.view.TipTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tab_tabLayout)
    public TipTabLayout tabLayout;
    @BindView(R.id.tab_viewPager)
    public ViewPager viewPager;
    @BindView(R.id.tab_text)
    public TextView tab_text;
    private Context context;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private MyPageAdapter myPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        loadFrag();
    }

    private void loadFrag() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        FragHome home = new FragHome();
        FragMiddle middle = new FragMiddle();
        FragRight right = new FragRight();
        FragFour fragFour = new FragFour();
        FragFive fragFive = new FragFive();
        FragSix fragSix = new FragSix();
        fragmentList.add(home);
        fragmentList.add(middle);
        fragmentList.add(right);
        fragmentList.add(fragFour);
        fragmentList.add(fragFive);
        fragmentList.add(fragSix);
        titleList.add("最新");
        titleList.add("新版本");
        titleList.add("英雄圈");
        titleList.add("视频");
        titleList.add("赛事");
        titleList.add("专栏");
        myPageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(myPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTitle(titleList, viewPager);
        tabLayout.showNewsTip(3);
    }
}
