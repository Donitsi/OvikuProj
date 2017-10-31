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

    //int[] IMAGES = {R.drawable.ic_lock_open, R.drawable.ic_lock_close, R.drawable.ic_lock_secure, R.drawable.ic_lock_close};

    String[] HOLDER1 = {"Name", "Lock info", "Color theme", "Remove lock"};

    String[] HOLDER2 = {"Front door", " ", "Grey", " "};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView toolbarText = (TextView)findViewById(R.id.toolbarText);
        toolbarText.setText("Settings");
        ListView listView = (ListView)findViewById(R.id.settings_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        ImageView backButton = (ImageView)findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(Settings.this, MainPage.class);
                startActivity(homeIntent);
            }
        });



    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return HOLDER1.length;
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

            view = getLayoutInflater().inflate(R.layout.customsettingslayout, null);
            //ImageView imageView = (ImageView) view.findViewById(R.id.lockImage);
            TextView holder1 = (TextView) view.findViewById(R.id.holder1);
            TextView holder2 = (TextView) view.findViewById(R.id.holder2);

            //imageView.setImageResource(IMAGES[i]);
            holder1.setText(HOLDER1[i]);
            holder2.setText(HOLDER2[i]);


            return view;
        }
    }
}
