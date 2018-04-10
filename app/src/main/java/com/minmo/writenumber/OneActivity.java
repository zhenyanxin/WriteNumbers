package com.minmo.writenumber;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;


public class OneActivity extends Activity {
    private ImageView iv_frame;
    int i=1;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    int igvx;
    int igvy;
    int type = 0;
    int widthPixels;
    int heightPixels;
    float scaleWidht;
    float scaleHeight;
    Timer touchTimer=null;
    Bitmap arrdown;
    boolean typedialog=true;
    private LinearLayout linearLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        initView();
    }

    private void initView(){
        iv_frame=(ImageView)findViewById(R.id.iv_frame);
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout1);
        LinearLayout write_layout=(LinearLayout)findViewById(R.id.linearLayout_number);
        write_layout.setBackgroundResource(R.drawable.bg1);
        widthPixels=this.getResources().getDisplayMetrics().widthPixels;
        heightPixels=this.getResources().getDisplayMetrics().heightPixels;
        scaleHeight=((float)heightPixels/1280);
        scaleWidht=((float)widthPixels/720);
        try{
            InputStream is=getResources().getAssets().open("on1_1.png");
            arrdown= BitmapFactory.decodeStream(is);
        }catch (IOException e){
            e.printStackTrace();
        }
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)iv_frame.getLayoutParams();
        layoutParams.width=(int)(arrdown.getWidth()*scaleWidht);
        layoutParams.height=(int)(arrdown.getHeight()*scaleHeight);
        iv_frame.setLayoutParams(layoutParams);
        lodimagep(1);
    }

    private synchronized void lodimagep(int j){
        i=j;
        if(i<25){
            String name="on_"+i;
            int imgid=getResources().getIdentifier(name,"drawable","com.minmo.writenumber");
            iv_frame.setBackgroundResource(imgid);
            i++;
        }
        if(j==24){
            if(typedialog){
                dialog();
            }
        }
    }
    protected void dialog(){
        typedialog=false;
        AlertDialog.Builder builder=new AlertDialog.Builder(OneActivity.this);
        builder.setMessage("太棒了，书写完成！");
        builder.setTitle("提示");
        builder.setPositiveButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                typedialog = true;
                finish();
            }
        });
        builder.setNegativeButton("再来一次",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                typedialog=true;
                i=1;
                lodimagep(i);
            }
        });
        builder.create().show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_one, menu);
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
