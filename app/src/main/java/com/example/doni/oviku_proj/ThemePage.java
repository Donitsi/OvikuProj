package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ThemePage extends Settings {

    private boolean darkVisible = true;    // Dark
    private boolean lightVisible = false;    // Light

    View view;


    String[] HOLDER1 = {"Dark", "Light", "Blue"};

    //int[] IMAGES = {R.drawable.ic_check,R.drawable.ic_check };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_page);

        // Setting the background picture
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.background4);


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


                if(position == 0){
                    // Change background
                    SetBackgroundDark(view);
                }

                else if (position == 1){
                    SetBackgroundLight(view);
                }

                else if(position == 2){
                    SetBackGroundBlue(view);
                }

/*                if (view.findViewById(R.id.vImage2).getVisibility() == View.VISIBLE) {
                    view.findViewById(R.id.vImage2).setVisibility(View.INVISIBLE);

                } else {
                    view.findViewById(R.id.vImage2).setVisibility(View.VISIBLE);
                }*/
            }
        });
    }

    public void SetBackgroundDark(View v){

        view.setBackgroundResource(R.drawable.background2);
    }

    public void SetBackgroundLight(View v){

        view.setBackgroundResource(R.drawable.background4);
    }

    public void SetBackGroundBlue(View v){
        view.setBackgroundResource(R.drawable.background3);
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

            view = getLayoutInflater().inflate(R.layout.customthemelayout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.vImage2);
            TextView holder1 = (TextView) view.findViewById(R.id.vHolder4);

            holder1.setText(HOLDER1[position]);
            //imageView.setImageResource(IMAGES[position]);

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