package com.example.doni.oviku_proj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.doni.oviku_proj.R.id.logInUsername;

public class SignInPage extends Activity {

    OvikuDatabaseHelper helper = new OvikuDatabaseHelper(this);

    View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_in_page);

        // Setting the background picture
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.background4);



        String username = getIntent().getStringExtra("Username");

/*        if(SaveSharedPreference.getUserName(SignInPage.this).length() == 0)
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
        }*/

/*        if(SaveSharedPreference.getUserName(SignInPage.this).equals("demo")){
            // This goes through when "demo" has signed in for the first time
            Toast.makeText(this, username + " has signed in!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, username + " has logged out!", Toast.LENGTH_SHORT).show();
        }*/

    }

    public void LogIn(View view) {


        EditText logInUsernameOrEmail = (EditText)findViewById(logInUsername);
        String str = logInUsernameOrEmail.getText().toString();

        EditText logInPassword = (EditText)findViewById(R.id.logInPassword);
        String pass = logInPassword.getText().toString();

        String usernameOrEmail = helper.searchPass(str);

        if(pass.equals(usernameOrEmail)){

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

    // Controls the back button of the phone**
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {

            //Toast.makeText(this, "Test!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(SignInPage.this, WelcomePage.class);
            startActivity(intent);

/*            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true*/;
        }
        return false;
    }
}
