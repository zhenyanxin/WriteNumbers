package com.minmo.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class StartActivity extends Activity {  //StartActivity类头部

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //OnCreate()方法头部
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Timer timer=new Timer();    //创建Timer对象，用于设置启动界面显示的时间
        //创建TimerTask对象，用于实现启动界面向游戏主界面的跳转
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this,MainActivity.class));
                finish();
            }
        };
        timer.schedule(timerTask,5000);
    }   //OnCreate()方法尾部

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   //StartActivity类尾部
