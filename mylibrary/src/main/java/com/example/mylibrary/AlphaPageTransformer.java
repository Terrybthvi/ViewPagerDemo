package com.example.mylibrary;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by leiqi on 16-5-13.
 */
public class AlphaPageTransformer extends BasePageTransformer {

    private static  final float DEFAULT_MIN_ALPHA = 0.5f;
    private float  mMainAlpha = DEFAULT_MIN_ALPHA;
    public AlphaPageTransformer(){

    }
    public AlphaPageTransformer(float minAlpha){
        this(minAlpha,NonPageTransformer.INSTANCE);
    }
    public AlphaPageTransformer(float minAlpha,ViewPager.PageTransformer pageTransformer){
        mMainAlpha = minAlpha;
        mPageTransformer = pageTransformer;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void pageTransform(View view, float position)
    {
        view.setScaleX( 0.999f);//hack

        if (position < -1)
        { // [-Infinity,-1)
            view.setAlpha(mMainAlpha);
        } else if (position <= 1)
        { // [-1,1]

            if (position < 0) //[0，-1]
            {           //[1,min]
                float factor = mMainAlpha + (1 - mMainAlpha) * (1 + position);
                view.setAlpha(factor);
            } else//[1，0]
            {
                //[min,1]
                float factor = mMainAlpha + (1 - mMainAlpha) * (1 - position);
                view.setAlpha(factor);
            }
        } else
        { // (1,+Infinity]
            view.setAlpha(mMainAlpha);
        }
    }
}
