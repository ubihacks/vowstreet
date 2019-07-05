package com.ubihacks.vowstreet.vowstreet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {


    private ImageView splashIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initView();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        splashIcon.setAnimation(animation);





        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {


                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();

            }
        },1500);
    }

    private void initView() {
        splashIcon = (ImageView) findViewById(R.id.splashIcon);
    }
}

