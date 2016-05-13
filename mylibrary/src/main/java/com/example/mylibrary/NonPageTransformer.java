package com.example.mylibrary;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by leiqi on 16-5-13.
 */
public class NonPageTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View page, float position)
    {
        page.setScaleX(0.999f);//hack
    }

    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();
}
