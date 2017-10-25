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

public class HistoryPage extends AppCompatActivity {

    int[] IMAGES = {R.drawable.open_lock, R.drawable.close_lock, R.drawable.secure_lock, R.drawable.open_lock};

    String[] NAMES = {"Liisa", "Heikki", "Tuomas", "Maria"};

    String[] TIME = {"18:42", "20:22", "21:33", "22:24"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);

        TextView toolbarText = (TextView)findViewById(R.id.toolbarText);
        toolbarText.setText("History");

        ListView listView = (ListView)findViewById(R.id.history_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        ImageView backButton = (ImageView)findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(HistoryPage.this, MainPage.class);
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
            ImageView imageView = (ImageView)view.findViewById(R.id.vImage);
            TextView logName = (TextView)view.findViewById(R.id.vHolder1);
            TextView timeLog = (TextView)view.findViewById(R.id.vHolder2);

            imageView.setImageResource(IMAGES[i]);
            logName.setText(NAMES[i]);
            timeLog.setText(TIME[i]);


            return view;
        }
    }
}
