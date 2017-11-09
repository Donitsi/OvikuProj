package com.example.doni.oviku_proj;

import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.Toast;

import static com.example.doni.oviku_proj.SaveSharedPreference.getBackgroundTheme;
import static com.example.doni.oviku_proj.SaveSharedPreference.getNotificationStatus;

public class Settings extends AppCompatActivity {

    //int[] IMAGES = {R.drawable.ic_lock_open, R.drawable.ic_lock_close, R.drawable.ic_lock_secure, R.drawable.ic_lock_close};


    String backgroundTheme;
    String notificationStr;


    private Resources resources;

    //final String backgroundTheme = SaveSharedPreference.getBackgroundTheme(getApplicationContext());

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        if(getBackgroundTheme(getApplicationContext()).length() == 0){

            backgroundTheme = "Light";
            view = this.getWindow().getDecorView();
            view.setBackgroundResource(R.drawable.background4);
        }
        else{
            if(getBackgroundTheme(getApplicationContext()).equals("Dark")){
                backgroundTheme = getBackgroundTheme(getApplicationContext());
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.drawable.background2);
            }
            else if(getBackgroundTheme(getApplicationContext()).equals("Light")){
                backgroundTheme = getBackgroundTheme(getApplicationContext());
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.drawable.background4);
            }
            else if(getBackgroundTheme(getApplicationContext()).equals("Blue")){
                backgroundTheme = getBackgroundTheme(getApplicationContext());
                view = this.getWindow().getDecorView();
                view.setBackgroundResource(R.drawable.background3);
            }
        }

        if(getNotificationStatus(getApplicationContext()).length() == 0){
            notificationStr = "While using app";
        }
        else{
            if(getNotificationStatus(getApplicationContext()).equals("Never")){
                notificationStr = getNotificationStatus(getApplicationContext());
            }
            else if(getNotificationStatus(getApplicationContext()).equals("While using app")){
                notificationStr = getNotificationStatus(getApplicationContext());
            }
            else if(getNotificationStatus(getApplicationContext()).equals("Always")){
                notificationStr = getNotificationStatus(getApplicationContext());
            }
        }




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

                    Intent homeIntent = new Intent(Settings.this, NotificationPage.class);
                    startActivity(homeIntent);


/*                    String text ="What do you want to do?";
                    Bitmap bitmapI = BitmapFactory.decodeResource(resources, R.drawable.oviku_logo2); // Set any icon from drawable
                    //String strName = "Theme";
                    Intent intent = new Intent(Settings.this, MainPage.class);
                    PendingIntent pIntent = PendingIntent.getActivity(Settings.this,0, intent,0);
                    //NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_lock, "Open lock", pIntent).build();

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Settings.this);

                    builder.setSmallIcon(R.drawable.oviku_logo1)
                            .setContentTitle("You are near your front door!");
                    builder.setStyle(new NotificationCompat.BigTextStyle(builder));

                    builder.setContentText(text);
                    builder.setContentIntent(pIntent);
                    builder.setLargeIcon(bitmapI);
                    builder.setPriority(Notification.PRIORITY_MAX)
                            .setWhen(0);
                    builder.addAction(new NotificationCompat.Action(R.drawable.open_lock, "Open lock", pIntent));
                    builder.addAction(new NotificationCompat.Action(R.drawable.close_lock, "Close lock", pIntent));

                    Notification notification = builder.build();
                    NotificationManagerCompat.from(Settings.this).notify(0, notification);*/


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

    public void RemoveLock(View v) {

        //Toast.makeText(this, getBackgroundTheme(getApplicationContext()), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Background theme: " + backgroundTheme + ", Notification status: " + notificationStr, Toast.LENGTH_SHORT).show();
    }


    class CustomAdapter extends BaseAdapter {

        String[] HOLDER1 = {"Name", "Lock info","Notification", "Theme"};

        String[] HOLDER2 = {"Front door", "OVIKU_LOCKSAVBBC5324", notificationStr, backgroundTheme};

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
