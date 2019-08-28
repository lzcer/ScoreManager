package com.example.scoremanager;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Shanping extends AppCompatActivity {

    /**
     * 人生不必太计较
     */
    private TextView mShanpingTV;
    private RelativeLayout mShanpingRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shanping);
        initView();
    }

    private void initView() {
        mShanpingTV = (TextView) findViewById(R.id.ShanpingTV);
        mShanpingRL = (RelativeLayout) findViewById(R.id.ShanpingRL);
        setView();
    }

    private void setView() {
        AssetManager manager=getAssets();
        Typeface typeface=Typeface.createFromAsset(manager,"fonts/guyin.ttf");
        mShanpingTV.setTypeface(typeface);//设置字体样式
        AlphaAnimation alphaAnimation=new AlphaAnimation(1,1);
        alphaAnimation.setDuration(2000);//持续两秒
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                startActivity(new Intent(Shanping.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mShanpingRL.setAnimation(alphaAnimation);
    }
}
