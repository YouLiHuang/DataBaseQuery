package com.example.databasequery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.nineoldandroids.view.ViewHelper;


public class MainActivity extends AppCompatActivity {

    private Context mContext;

    /**导航栏右侧的用户图标*/
    private ImageView nav_userImg;
    /**导航栏右侧的侧边栏的父容器*/
    private DrawerLayout mDrawerLayout;
    /**导航栏右侧的侧边栏碎片界面*/
    private rightListFragment rightMenuFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        //初始化控件
        initViews();
        //初始化数据
        initData();
        //初始化控件的点击事件
        initEvent();
    }

    private void initEvent() {
        //用户图标的点击事件
        nav_userImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OpenLeftMenu();
            }
        });

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                Log.w("onDrawerSlide", "slideOffset="+slideOffset);//0.0 -- 0.56 -- 1.
                View mContent = mDrawerLayout.getChildAt(0);//内容区域view
                View mMenu = drawerView;
                float scale = 1 - slideOffset;

                if (drawerView.getTag().equals("RIGHT"))
                {
                    ViewHelper.setTranslationX(mContent,-mMenu.getMeasuredWidth() * slideOffset);
                    mContent.invalidate();
                }

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                if (drawerView.getTag().equals("RIGHT")){//如果感觉显示有延迟的话，可以放到nav_userImg的点击事件监听中执行

                }
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    /**打开左侧的侧边栏*/
    public void OpenLeftMenu()
    {
        mDrawerLayout.openDrawer(Gravity.LEFT);
        //打开手势滑动：DrawerLayout.LOCK_MODE_UNLOCKED（Gravity.LEFT：代表左侧的）
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,Gravity.LEFT);
    }



    private void initViews() {
        nav_userImg = (ImageView) findViewById(R.id.id_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
        //关闭手势滑动：DrawerLayout.LOCK_MODE_LOCKED_CLOSED（Gravity.LEFT：代表左侧的）
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);
        rightMenuFragment = (rightListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_rightmenu);
    }

    private void initData() {

    }



}