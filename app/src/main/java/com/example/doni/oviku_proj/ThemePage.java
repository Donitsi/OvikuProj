package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ThemePage extends AppCompatActivity {

    private boolean darkVisible = true;    // Dark
    private boolean lightVisible = false;    // Light


    String[] HOLDER1 = {"Dark", "Light"};

    int[] IMAGES = {R.drawable.ic_check,R.drawable.ic_check };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_page);


        TextView toolbarText = (TextView)findViewById(R.id.toolbarText);
        toolbarText.setText("Theme");


        ListView listView = (ListView)findViewById(R.id.theme_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        ImageView backButton = (ImageView)findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(ThemePage.this, Settings.class);
                startActivity(homeIntent);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String category = (String) parent.getItemAtPosition(position);
                if(position == 0) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.vImage2);
                    if(darkVisible){

                        imageView.setImageResource(0);
                        darkVisible = false;
                    }

                    else if(lightVisible){
                        imageView.setImageResource(0);
                        lightVisible = false;
                    }
                    else{

                        darkVisible = true;
                    }

                }
                else if(position == 1){
                    ImageView imageView = (ImageView) view.findViewById(R.id.vImage2);
                    if(lightVisible){
                        imageView.setImageResource(IMAGES[0]);
                        lightVisible = false;
                    }
                    else if(darkVisible){
                        imageView.setImageResource(0);
                        darkVisible = false;
                    }
                    else{
                        lightVisible = true;
                    }

                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 2;
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
        public View getView(int position, View view, ViewGroup parent) {

            view = getLayoutInflater().inflate(R.layout.customthemelayout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.vImage2);
            TextView holder1 = (TextView) view.findViewById(R.id.vHolder4);

            holder1.setText(HOLDER1[position]);


            if(darkVisible){
                // in the beginning - it was dark
                imageView.setImageResource(IMAGES[position]);
                imageView.setImageResource(0);
                darkVisible = false;
            }
            else if(lightVisible){
                imageView.setImageResource(0);
                lightVisible = false;
            }
            else{
                //
            }

            return view;
        }

    }
}