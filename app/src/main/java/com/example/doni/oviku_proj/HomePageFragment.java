package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Doni on 10/25/2017.
 */

public class HomePageFragment extends Fragment {

    private boolean firstImageShown = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.home_page, container, false);


        ImageView settingsButton = (ImageView) v.findViewById(R.id.settings_button);
        ImageView lockImage = (ImageView)v.findViewById(R.id.vLock);

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
                    lockImage1.setImageResource(R.drawable.close_lock);
                    firstImageShown = false;
                }
                else{
                    ImageView lockImage1 = (ImageView)v.findViewById(R.id.vLock);
                    lockImage1.setImageResource(R.drawable.open_lock);
                    firstImageShown = true;
                }
            }
        });

        lockImage.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                ImageView lockImage1 = (ImageView)v.findViewById(R.id.vLock);
                lockImage1.setImageResource(R.drawable.secure_lock);
                firstImageShown = true;
                return true;
            }
        });

/*        final ImageView imageview = (ImageView)v.findViewById(R.id.vLock);


        ImageView backButton = (ImageView) v.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(getActivity(), MainPage.class);
                startActivity(homeIntent);
            }
        });

        ImageView lockImage = (ImageView)v.findViewById(R.id.vLock);
        lockImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(firstImageShown){

                    imageview.setImageResource(R.drawable.close_lock);
                    firstImageShown = false;
                }
                else{
                    imageview.setImageResource(R.drawable.open_lock);
                    firstImageShown = true;
                }
            }
        });

        lockImage.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View view){
                imageview.setImageResource(R.drawable.secure_lock);
                firstImageShown = true;
                return true;
            }
        });*/

        return v;
    }

}
