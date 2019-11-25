package com.qq.tab.view;

import android.content.Context;

import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.qq.tab.R;

import java.util.List;



/**
 * Created by QiuQ on 2017-07-12.
 */

public class TipTabLayout extends TabLayout {

    public TipTabLayout(Context context) {
        super(context);
    }

    public TipTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TipTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //添加标题 动态设置ViewPager的当前选择项
    public void addTitle(List<String> titleList, final ViewPager viewPager) {
        if (titleList != null && titleList.size() > 0) {
            for (int i = 0, count = getTabCount(); i < count; i++) {
                Tab tab = getTabAt(i);
                assert tab != null;
                tab.setCustomView(R.layout.tab_item);
                View customView = tab.getCustomView();
                assert customView != null;
                TextView title = (TextView) customView.findViewById(R.id.tab_item_title);
                title.setText(titleList.get(i));
                ImageView checkBox = (ImageView) customView.findViewById(R.id.tab_checkBox);
                checkBox.setSelected(tab.isSelected());
            }
        }
        addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                View customView = tab.getCustomView();
                assert customView != null;
                ImageView img = (ImageView) customView.findViewById(R.id.tab_checkBox);
                img.setSelected(true);
            }

            @Override
            public void onTabUnselected(Tab tab) {
                View customView = tab.getCustomView();
                assert customView != null;
                ImageView img = (ImageView) customView.findViewById(R.id.tab_checkBox);
                img.setSelected(false);
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });

    }

    //显示指定位置的tip图片
    public void showNewsTip(int position) {
        for (int i = 0, count = getTabCount(); i < count; i++) {
            Tab tab = getTabAt(i);
            assert tab != null;
            View customView = tab.getCustomView();
            assert customView != null;
            ImageView tab_item_newTip = (ImageView) customView.findViewById(R.id.tab_item_newTip);
            if (i == position) {
                tab_item_newTip.setVisibility(View.VISIBLE);
            }
        }
    }

    //隐藏指定位置的tip图片
    public void dismissNewsTip(int position) {
        for (int i = 0, count = getTabCount(); i < count; i++) {
            Tab tab = getTabAt(i);
            assert tab != null;
            View customView = tab.getCustomView();
            assert customView != null;
            ImageView tab_item_newTip = (ImageView) customView.findViewById(R.id.tab_item_newTip);
            if (i == position) {
                tab_item_newTip.setVisibility(View.GONE);
            }
        }
    }

}
