package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInPage extends Activity {

    OvikuDatabaseHelper helper = new OvikuDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_in_page);


        if(SaveSharedPreference.getUserName(SignInPage.this).length() == 0)
        {
            // call Login Activity
            Intent intent = new Intent(SignInPage.this, MainPage.class);
            startActivity(intent);
        }
        else
        {
            // Stay at the current activity.
            Intent homeIntent = new Intent(SignInPage.this, MainPage.class);
            startActivity(homeIntent);
            finish();
        }

    }

    public void LogIn(View view) {


        EditText logInUsername = (EditText)findViewById(R.id.logInUsername);
        String str = logInUsername.getText().toString();

        EditText logInPassword = (EditText)findViewById(R.id.logInPassword);
        String pass = logInPassword.getText().toString();

        String password = helper.searchPass(str);

        if(pass.equals(password)){

            SaveSharedPreference.setUserName(this, str);

            Intent homeIntent = new Intent(SignInPage.this, MainPage.class);
            homeIntent.putExtra("Username", str);
            startActivity(homeIntent);
        }
        else{
            Toast toast = Toast.makeText(SignInPage.this, "Your email or password is incorrect", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
