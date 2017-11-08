package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(SaveSharedPreference.getUserName(MainActivity.this).length() == 0)
                {
                    // call Login Activity
                    Intent intent = new Intent(MainActivity.this, MainPage.class);
                    startActivity(intent);
                }
                else
                {
                    // Stay at the current activity.
                    Intent homeIntent = new Intent(MainActivity.this, WelcomePage.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);

    }
}
