package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountPage extends AppCompatActivity {

    OvikuDatabaseHelper helper = new OvikuDatabaseHelper(this);

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_create_account_page);

        // Setting the background picture
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.background4);
    }

    public void SignUp(View view) {
        EditText name = (EditText)findViewById(R.id.vName);
        EditText email = (EditText)findViewById(R.id.vEmail);
        EditText username = (EditText)findViewById(R.id.vUsername);
        EditText password1 =(EditText)findViewById(R.id.vPassword);
        EditText password2 = (EditText)findViewById(R.id.vConfirm_password);

        String namestr = name.getText().toString();
        String emailstr = email.getText().toString();
        String usernamestr = username.getText().toString();
        String password1str = password1.getText().toString();
        String password2str = password2.getText().toString();

        if(!password1str.equals(password2str)){
            Toast pass = Toast.makeText(CreateAccountPage.this, "Password don't match!", Toast.LENGTH_SHORT);
            pass.show();
        }

        else{
            // insert details in database
            Contact c = new Contact();
            c.setName(namestr);
            c.setEmail(emailstr);
            c.setUsername(usernamestr);
            c.setPassword(password1str);

            helper.insertContact(c);

            Toast pass = Toast.makeText(CreateAccountPage.this, "Account created!", Toast.LENGTH_SHORT);
            pass.show();
            String password = helper.searchPass(usernamestr);

            if(password1str.equals(password)){
                Intent homeIntent = new Intent(CreateAccountPage.this, MainPage.class);
                homeIntent.putExtra("Username", usernamestr);
                startActivity(homeIntent);
                finish();
            }
            else{
                Toast toast = Toast.makeText(CreateAccountPage.this, "Your email or password is incorrect", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
