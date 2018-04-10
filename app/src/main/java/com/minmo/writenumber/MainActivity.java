package com.minmo.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {    //MainActivityͷ��
    static boolean isPlay=true;         //�������ֲ���״̬����
    MediaPlayer mediaPlayer;            //�������ֲ��Ŷ���
    Button music_btn;                   //����������ֲ��Ű�ť
    //OnCreate����
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //�˴���Ӵ���
        music_btn=(Button)findViewById(R.id.btn_music);
        PlayMusic();
    }
    //Play��ť����Ч��
    public  void OnPlay(View v){
        startActivity(new Intent(MainActivity.this, SelectActivity.class));
    }
    //about��ť����Ч��
    public void OnAbout(View v){
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }
    //music��ť����Ч��
    public void OnMusic(View v){
        if(isPlay){
            if(mediaPlayer!=null) {
                mediaPlayer.stop();     //ֹͣ����
                music_btn.setBackgroundResource(R.drawable.btn_music2);
                isPlay = false;
            }
        }else{
            PlayMusic();                //��������
            music_btn.setBackgroundResource(R.drawable.btn_music1);
            isPlay=true;
        }
    }
    //���ű������ַ���
    private void PlayMusic(){
        //�������ֲ��������󲢼��ز��������ļ�
        mediaPlayer=MediaPlayer.create(this,R.raw.main_music);
        mediaPlayer.setLooping(true);       //ѭ������
        mediaPlayer.start();                //��������
    }
    //������ֹͣʱ��������ֹͣ
    protected void onStop(){
        super.onStop();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }
    //��������ֹͣ�����������Դ
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    //���ؽ���ʱ�ٴβ���
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
