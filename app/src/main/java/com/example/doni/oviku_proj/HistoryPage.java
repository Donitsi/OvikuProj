package com.example.doni.oviku_proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoryPage extends AppCompatActivity {

    int[] IMAGES = {R.drawable.ic_lock_open, R.drawable.ic_lock_close, R.drawable.ic_lock_secure, R.drawable.ic_lock_close};

    String[] NAMES = {"Liisa", "Heikki", "Tuomas", "Maria"};

    String[] TIME = {"18:42", "20:22", "21:33", "22:24"};

    //CustomAdapter customAdapter = new CustomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
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

            view = getLayoutInflater().inflate(R.layout.activity_settings, null);
            ImageView imageView = (ImageView)view.findViewById(R.id.lockImage);
            TextView logName = (TextView)view.findViewById(R.id.logName);
            TextView timeLog = (TextView)view.findViewById(R.id.time_log);

            imageView.setImageResource(IMAGES[i]);
            logName.setText(NAMES[i]);
            timeLog.setText(TIME[i]);


            return view;
        }
    }
}
