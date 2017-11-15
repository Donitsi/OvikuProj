package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Doni on 10/25/2017.
 */

public class HomePageFragment extends Fragment {

    private boolean firstImageShown = true;
    TextView loadingText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.home_page, container, false);


        ImageView settingsButton = (ImageView) v.findViewById(R.id.settings_button);
        ImageView lockImage = (ImageView)v.findViewById(R.id.vLock);


/*        loadingText = (TextView)v.findViewById(R.id.loadingText);
        loadingText.setText("Loading");*/

        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(getActivity(), Settings.class);
                startActivity(homeIntent);
            }
        });

        lockImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(firstImageShown){
                    ImageView lockImage1 = (ImageView)v.findViewById(R.id.vLock);
                    lockImage1.setImageResource(R.drawable.close_lock1);
                    firstImageShown = false;
                }
                else{
                    ImageView lockImage1 = (ImageView)v.findViewById(R.id.vLock);
                    lockImage1.setImageResource(R.drawable.open_lock1);
                    firstImageShown = true;
                }
            }
        });

        lockImage.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                ImageView lockImage1 = (ImageView)v.findViewById(R.id.vLock);
                lockImage1.setImageResource(R.drawable.secure_lock1);
                firstImageShown = true;
                return true;
            }
        });
        return v;
    }


}
