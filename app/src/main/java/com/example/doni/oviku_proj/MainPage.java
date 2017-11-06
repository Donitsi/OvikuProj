package com.example.doni.oviku_proj;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainPage extends AppCompatActivity {

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_page);

        String name = getIntent().getStringExtra("Username");

        Toast toast = Toast.makeText(MainPage.this, name +" has logged in!", Toast.LENGTH_SHORT);
        toast.show();

        bottomBar = BottomBar.attach(this,savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.bottom_navigation_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId == R.id.action_keys){
                    HomePageFragment f = new HomePageFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, f).commit();
                }
                else if(menuItemId == R.id.action_access){
                    AccessPageFragment f = new AccessPageFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,f).commit();
                }

                else if(menuItemId == R.id.action_history){
                    HistoryPageFragment f = new HistoryPageFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, f).commit();
                }
                else if(menuItemId == R.id.action_more){
                    MoreFragment f = new MoreFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, f).commit();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
    }
}
