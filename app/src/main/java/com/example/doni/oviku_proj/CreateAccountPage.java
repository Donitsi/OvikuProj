package com.example.doni.oviku_proj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountPage extends AppCompatActivity {

    OvikuDatabaseHelper helper = new OvikuDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_create_account_page);
    }

    public void SignUp(View view) {
        EditText name = (EditText)findViewById(R.id.vName);
        EditText email = (EditText)findViewById(R.id.vEmail);
        EditText password1 =(EditText)findViewById(R.id.vPassword);
        EditText password2 = (EditText)findViewById(R.id.vConfirm_password);

        String namestr = name.getText().toString();
        String emailstr = email.getText().toString();
        String password1str = password1.getText().toString();
        String password2str = password2.getText().toString();

        if(!password1.equals(password2)){
            Toast pass = Toast.makeText(CreateAccountPage.this, "Password don't match!", Toast.LENGTH_SHORT);
            pass.show();
        }

        else{
            // insert details in database
            Contact c = new Contact();
            c.setName(namestr);
            c.setEmail(emailstr);
            c.setPassword(emailstr);

            helper.insertContact(c);
        }
    }
}
