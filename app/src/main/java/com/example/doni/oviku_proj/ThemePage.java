package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
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

                if (view.findViewById(R.id.vImage2).getVisibility() == View.VISIBLE) {
                    view.findViewById(R.id.vImage2).setVisibility(View.INVISIBLE);
                    if(position == 0){

                    }
                } else {
                    view.findViewById(R.id.vImage2).setVisibility(View.VISIBLE);
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
            imageView.setImageResource(IMAGES[position]);

            return view;
        }
    }

    // Controls the back button of the phone**
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {

            //Toast.makeText(this, "Test!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }
}