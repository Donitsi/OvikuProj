package com.example.doni.oviku_proj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MorePage extends AppCompatActivity {


    int[] IMAGES = {R.drawable.ic_sign_in, R.drawable.ic_add_virtual_key, R.drawable.ic_add_new_key};

    String[] TEXT = {"Sign in", "Add virtual key", "Add new lock"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_page);

        TextView toolbarText = (TextView)findViewById(R.id.toolbarText);
        toolbarText.setText("More");

        ListView listView = (ListView)findViewById(R.id.history_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);


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
            ImageView imageView = (ImageView)view.findViewById(R.id.vImage);
            TextView logName = (TextView)view.findViewById(R.id.vHolder1);

            imageView.setImageResource(IMAGES[i]);
            logName.setText(TEXT[i]);

            return view;
        }
    }
}
