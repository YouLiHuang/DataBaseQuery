package com.example.mainui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageView textView_topTitle;
    private FrameLayout content;
    private NavigationView nav_view;
    private ImageButton btn_nva;
    private DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        textView_topTitle = (ImageView) findViewById(R.id.textView_topTitle);//标题
        content = (FrameLayout) findViewById(R.id.content);//Fragment碎片布局
        //左侧隐藏的NavigationView布局
        nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);//nva菜单的Item点击事件钮监听
        //左上角导航按钮
        btn_nva = (ImageButton) findViewById(R.id.btn_nva);
        btn_nva.setOnClickListener(this);//监听是否按下导航按钮
        //activity_main文件内最外层布局
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer_layout.setOnClickListener(this);

    }
    /*导航栏下的按键监听*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if(menuItem.getItemId()==R.id.fragment_05)
        {
            Toast.makeText(MainActivity.this, "界面1", Toast.LENGTH_SHORT).show();

            //getSupportFragmentManager().beginTransaction().replace(R.id.content,new Fragment_05()).commit();
            drawer_layout.closeDrawer(GravityCompat.START);//关闭侧滑栏
        }
        else if (menuItem.getItemId()==R.id.fragment_06) {
            Toast.makeText(MainActivity.this, "界面2", Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId()==R.id.fragment_07) {
            Toast.makeText(MainActivity.this, "界面3", Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId()==R.id.fragment_08) {
            Toast.makeText(MainActivity.this, "界面4", Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId()==R.id.fragment_09) {
            Toast.makeText(MainActivity.this, "界面5", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
    /*导航栏弹窗监听*/
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_nva)//
        {
            drawer_layout.openDrawer(GravityCompat.START);//设置左边菜单栏显示出来
        }
    }
}