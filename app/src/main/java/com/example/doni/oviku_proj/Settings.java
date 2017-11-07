package com.example.doni.oviku_proj;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    //int[] IMAGES = {R.drawable.ic_lock_open, R.drawable.ic_lock_close, R.drawable.ic_lock_secure, R.drawable.ic_lock_close};

    String[] HOLDER1 = {"Name", "Lock info","Notify me", "Theme"};

    String[] HOLDER2 = {"Front door", " ", " ", "Dark"};



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



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = (String) parent.getItemAtPosition(position);
                if(position == 2){
                    //String strName = "Theme";
                    Toast.makeText(Settings.this, "Notify me!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    PendingIntent pIntent = PendingIntent.getActivity(Settings.this,0, intent,0);
                    Notification noti = new Notification.Builder(Settings.this)
                            .setTicker("Ticker Title")
                            .setContentTitle("Conten tTitle")
                            .setContentText("Content text sdlmfd")
                            .setSmallIcon(R.drawable.ic_lock)
                            .addAction(R.drawable.ic_lock, "Open lock", pIntent)
                            .addAction(R.drawable.ic_lock, "Close lock", pIntent)
                            .setContentIntent(pIntent).getNotification();

                    noti.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0, noti);
                }
                if(position == 3){
                    //String strName = "Theme";
                    Intent homeIntent = new Intent(Settings.this, ThemePage.class);
                    //homeIntent.putExtra("theme_page", strName);
                    startActivity(homeIntent);
                }

            }
        });
    }

    public void RemoveLock(View view) {
        String strName = "Theme";
        Intent homeIntent = new Intent(Settings.this, ThemePage.class);
        homeIntent.putExtra("theme_page", strName);
        startActivity(homeIntent);
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
