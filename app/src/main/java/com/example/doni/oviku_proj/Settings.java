package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    int[] IMAGES = {R.drawable.ic_lock_open, R.drawable.ic_lock_close, R.drawable.ic_lock_secure, R.drawable.ic_lock_close};

    String[] NAMES = {"Liisa", "Heikki", "Tuomas", "Maria"};

    String[] TIME = {"18:42", "20:22", "21:33", "22:24"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        ListView listView = (ListView)findViewById(R.id.settings_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        ImageView backButton = (ImageView)findViewById(R.id.back_button_in_settings);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(Settings.this, MainPage.class);
                startActivity(homeIntent);
                finish();
            }
        });



    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {

            view = getLayoutInflater().inflate(R.layout.customlistlayout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.lockImage);
            TextView logName = (TextView) view.findViewById(R.id.logName);
            TextView timeLog = (TextView) view.findViewById(R.id.time_log);

            imageView.setImageResource(IMAGES[i]);
            logName.setText(NAMES[i]);
            timeLog.setText(TIME[i]);


            return view;
        }
    }
}
