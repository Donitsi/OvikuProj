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
    }

    public void LogIn(View view) {


        EditText logInEmail = (EditText)findViewById(R.id.logInEmail);
        String strEmail = logInEmail.getText().toString();

        EditText logInPassword = (EditText)findViewById(R.id.logInPassword);
        String strPassword = logInPassword.getText().toString();

        String password = helper.searchPass(strEmail);

        if(strPassword.equals(password)){
            Intent homeIntent = new Intent(SignInPage.this, MainPage.class);
            homeIntent.putExtra("Email", strEmail);
            startActivity(homeIntent);
        }
        else{
            Toast toast = Toast.makeText(SignInPage.this, "Your email or password is incorrect", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
