package com.minmo.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {    //MainActivity头部
    static boolean isPlay=true;         //设置音乐播放状态变量
    MediaPlayer mediaPlayer;            //定义音乐播放对象
    Button music_btn;                   //定义控制音乐播放按钮
    //OnCreate方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //此处添加代码
        music_btn=(Button)findViewById(R.id.btn_music);
        PlayMusic();
    }
    //Play按钮按下效果
    public  void OnPlay(View v){
        startActivity(new Intent(MainActivity.this, SelectActivity.class));
    }
    //about按钮按下效果
    public void OnAbout(View v){
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }
    //music按钮按下效果
    public void OnMusic(View v){
        if(isPlay){
            if(mediaPlayer!=null) {
                mediaPlayer.stop();     //停止播放
                music_btn.setBackgroundResource(R.drawable.btn_music2);
                isPlay = false;
            }
        }else{
            PlayMusic();                //播放音乐
            music_btn.setBackgroundResource(R.drawable.btn_music1);
            isPlay=true;
        }
    }
    //播放背景音乐方法
    private void PlayMusic(){
        //创建音乐播放器对象并加载播放音乐文件
        mediaPlayer=MediaPlayer.create(this,R.raw.main_music);
        mediaPlayer.setLooping(true);       //循环播放
        mediaPlayer.start();                //启动播放
    }
    //主界面停止时背景音乐停止
    protected void onStop(){
        super.onStop();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }
    //背景音乐停止并清空音乐资源
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    //返回界面时再次播放
    protected void onRestart(){
        super.onRestart();
        if(isPlay){
            PlayMusic();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
