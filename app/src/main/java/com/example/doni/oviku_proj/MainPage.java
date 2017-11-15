package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainPage extends AppCompatActivity {

    BottomBar bottomBar;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_page);

        if(SaveSharedPreference.getBackgroundTheme(getApplicationContext()).length() == 0){
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.drawable.background4);
        }
        else{
            if(SaveSharedPreference.getBackgroundTheme(getApplicationContext()).equals("Dark")){
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.drawable.background2);
            }
            else if(SaveSharedPreference.getBackgroundTheme(getApplicationContext()).equals("Light")){
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.drawable.background4);
            }
            else if(SaveSharedPreference.getBackgroundTheme(getApplicationContext()).equals("Blue")){
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.drawable.background3);
            }
        }

        //String username = getIntent().getStringExtra("Username");

        final String username = SaveSharedPreference.getUserName(getApplicationContext());


/*        Toast toast = Toast.makeText(MainPage.this, username +" has logged in!", Toast.LENGTH_SHORT);
        toast.show();*/

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


    // Controls the back button of the phone**
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            //Toast.makeText(this, SaveSharedPreference.getUserName(getApplicationContext()), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
