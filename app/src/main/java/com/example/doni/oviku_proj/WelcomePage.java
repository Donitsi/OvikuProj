package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class WelcomePage extends Activity {


    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome_page);


        // Setting the background picture
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.frontpage_background_dark);

    }

    public void CreateAccount(View view) {
        Intent homeIntent = new Intent(WelcomePage.this, CreateAccountPage.class);
        startActivity(homeIntent);
    }

    public void SignIn(View view) {
        Intent homeIntent = new Intent(WelcomePage.this, SignInPage.class);
        startActivity(homeIntent);
    }

    // Controls the back button of the phone**
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {

            //Toast.makeText(this, "Test!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
