package com.example.musicplayer.splash;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.musicplayer.R;
import com.example.musicplayer.home.HomeActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int DELAY_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        goToHome();
    }

    private void goToHome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(HomeActivity.getIntent(SplashActivity.this));
                finish();
            }
        }, DELAY_TIME);
    }
}
