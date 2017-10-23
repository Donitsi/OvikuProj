package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {


    private boolean firstImageShown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_page);


        ImageView imageview = (ImageView)findViewById(R.id.vLock);
        ImageView settingsButton = (ImageView) findViewById(R.id.settings_button);

        imageview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OpenAndCloseLockDoor();
            }
        });

        imageview.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View view){
                SecureDoor();
                return true;
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               Intent homeIntent = new Intent(MainPage.this, Settings.class);
               startActivity(homeIntent);
               finish();
           }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){

                switch (item.getItemId()){
                    case R.id.action_keys:
                        Toast.makeText(MainPage.this, "Action Keys clicked!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_access:
                        Toast.makeText(MainPage.this, "Action Access clicked!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_history:
                        Intent homeIntent = new Intent(MainPage.this, HistoryPage.class);
                        startActivity(homeIntent);
                        finish();
                        break;
                    case R.id.action_more:
                        Toast.makeText(MainPage.this, "Action More clicked!", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

    }

    public void OpenAndCloseLockDoor(){

        ImageView imageview = (ImageView)findViewById(R.id.vLock);

        if(firstImageShown){

            imageview.setImageResource(R.drawable.close_lock);
            firstImageShown = false;
        }
        else{
            imageview.setImageResource(R.drawable.open_lock);
            firstImageShown = true;
        }
    }

    public void SecureDoor(){

        ImageView imageview = (ImageView)findViewById(R.id.vLock);
        imageview.setImageResource(R.drawable.secure_lock);
        firstImageShown = true;
    }
}
