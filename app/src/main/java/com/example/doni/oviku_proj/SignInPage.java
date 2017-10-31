package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignInPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_in_page);
    }

    public void LogIn(View view) {
        Intent homeIntent = new Intent(SignInPage.this, MainPage.class);
        startActivity(homeIntent);
    }
}
