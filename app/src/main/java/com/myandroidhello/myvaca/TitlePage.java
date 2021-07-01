package com.myandroidhello.myvaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class TitlePage extends AppCompatActivity {

    private TextView app_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);

//        app_String = (TextView) findViewById(R.id.appString);
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
//        app_String.setAnimation(anim);

//        new Thread(){
//            public void run(){
//                try {
//                    sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(TitlePage.this, TitlePage.class);
//                startActivity(intent);
//            }
//        }.start();
    }
}