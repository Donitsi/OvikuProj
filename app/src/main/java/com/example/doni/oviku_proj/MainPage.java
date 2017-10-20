package com.example.doni.oviku_proj;

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
                        Toast.makeText(MainPage.this, "Action History clicked!", Toast.LENGTH_SHORT).show();
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

            imageview.setImageResource(R.drawable.lock_closed);
            firstImageShown = false;
        }
        else{
            imageview.setImageResource(R.drawable.lock_open);
            firstImageShown = true;
        }
    }

    public void SecureDoor(){

        ImageView imageview = (ImageView)findViewById(R.id.vLock);
        imageview.setImageResource(R.drawable.lock_secured);
        firstImageShown = true;
    }

}
