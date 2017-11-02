package com.example.doni.oviku_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Doni on 11/2/2017.
 */

public class ThemeFragment extends Fragment {
    String[] HOLDER1 = {"Heikki", "Emilia", "Jukka", "Maria"};

    String[] HOLDER2 = {"owner", "owner", "guest", "guest"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.theme_fragment_page, container, false);

        ImageView backButton = (ImageView)v.findViewById(R.id.back_button);

        TextView toolbarText = (TextView)v.findViewById(R.id.toolbarText);
        toolbarText.setText("Access");
        ListView listView = (ListView)v.findViewById(R.id.access_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent homeIntent = new Intent(getActivity(), MainPage.class);
                startActivity(homeIntent);
            }
        });

        return v;
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

            view = getActivity().getLayoutInflater().inflate(R.layout.customthemelayout, null);
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
