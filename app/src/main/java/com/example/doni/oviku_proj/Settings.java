package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Settings extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        ImageView backButton = (ImageView)findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(Settings.this, MainPage.class);
                startActivity(homeIntent);
                finish();
            }
        });



    }

}
