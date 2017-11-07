package com.example.doni.oviku_proj;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
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

    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        resources = getResources();

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
                //String category = (String) parent.getItemAtPosition(position);
                if(position == 2){

                    Bitmap bitmapI = BitmapFactory.decodeResource(resources, R.drawable.oviku_logo2); // Set any icon from drawable
                    //String strName = "Theme";
                    Toast.makeText(Settings.this, "Notify me!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    PendingIntent pIntent = PendingIntent.getActivity(Settings.this,0, intent,0);
                    //NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_lock, "Open lock", pIntent).build();

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Settings.this);


/*                    Notification noti = new Notification.Builder(Settings.this)
                            .setTicker("Ticker Title")
                            .setContentTitle("Your lock is nearby!")
                            .setContentText("What do you want to do?")
                            .setSmallIcon(R.drawable.oviku_logo1)
                            .setLargeIcon(bitmapI)
                            .addAction(R.drawable.ic_lock_open, "Open lock", pIntent)
                            .addAction(R.drawable.ic_lock_close, "Close lock", pIntent)
                            .setContentIntent(pIntent)
                            .build();



                    noti.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0, noti);*/



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
