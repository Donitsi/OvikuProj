package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome_page);
    }

    public void CreateAccount(View view) {
        Intent homeIntent = new Intent(WelcomePage.this, CreateAccountPage.class);
        startActivity(homeIntent);
    }

    public void SignIn(View view) {
        Intent homeIntent = new Intent(WelcomePage.this, SignInPage.class);
        startActivity(homeIntent);
    }
}
