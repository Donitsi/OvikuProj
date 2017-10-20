package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class HomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_page);
    }

    public void CreateAccount(View view) {
        Intent homeIntent = new Intent(HomePage.this, CreateAccountPage.class);
        startActivity(homeIntent);
        finish();
    }
}
