package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        ImageView imageView = (ImageView)findViewById(R.id.back_button);

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(Settings.this, MainPage.class);
                startActivity(homeIntent);
                finish();
            }
        });


        ListView listView = (ListView)findViewById(R.id.log_list);

    }
}
