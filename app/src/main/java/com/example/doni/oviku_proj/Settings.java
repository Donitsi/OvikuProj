package com.example.doni.oviku_proj;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    //int[] IMAGES = {R.drawable.ic_lock_open, R.drawable.ic_lock_close, R.drawable.ic_lock_secure, R.drawable.ic_lock_close};

    String[] HOLDER1 = {"Name", "Lock info", "Theme"};

    String[] HOLDER2 = {"Front door", " ", "Dark"};



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

        /*

        // Create a List from String Array elements
        List<String> fruits_list = new ArrayList<String>(Arrays.asList(HOLDER1));

        // Create an ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.RED);

                // Generate ListView Item using TextView
                return view;
            }
        };

        // DataBind ListView with items from ArrayAdapter
        listView.setAdapter(arrayAdapter);

        */


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Resources res = getResources();
                String [] category_settings = res.getStringArray(R.array.category_settings);
                String category = category_settings[position];
                if(category.equals("Name")) {

                }
                else if(category.equals("Lock info")){
                    //Open adding virtual key
                }
                else if(category.equals("Theme")){
                    // Open Add new lock page
                }

            }
        });
    }

    public void RemoveLock(View view) {

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
        public View getView(int position, View view, ViewGroup parent) {

            view = getLayoutInflater().inflate(R.layout.customsettingslayout, null);
            //ImageView imageView = (ImageView) view.findViewById(R.id.lockImage);
            TextView holder1 = (TextView) view.findViewById(R.id.holder1);
            TextView holder2 = (TextView) view.findViewById(R.id.holder2);

            //imageView.setImageResource(IMAGES[i]);
            holder1.setText(HOLDER1[position]);
            holder2.setText(HOLDER2[position]);


            return view;
        }
    }
}
