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
 * Created by Doni on 10/26/2017.
 */

public class HistoryPageFragment extends Fragment {

    int[] IMAGES = {R.drawable.open_lock2, R.drawable.close_lock2, R.drawable.open_lock2, R.drawable.close_lock2};

    String[] NAMES = {"Liisa", "Heikki", "Tuomas", "Maria"};

    String[] TIME = {"18:42", "20:22", "21:33", "22:24"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_history_page, container, false);

        TextView toolbarText = (TextView)v.findViewById(R.id.toolbarText);
        toolbarText.setText("History");

        ListView listView = (ListView)v.findViewById(R.id.history_list);
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        ImageView backButton = (ImageView) v.findViewById(R.id.back_button);
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
            return NAMES.length;
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

            view = getActivity().getLayoutInflater().inflate(R.layout.customlistlayout, null);
            ImageView vImage = (ImageView)view.findViewById(R.id.vImage);
            TextView holder1 = (TextView)view.findViewById(R.id.vHolder1);
            TextView holder2 = (TextView)view.findViewById(R.id.vHolder2);

            vImage.setImageResource(IMAGES[i]);
            holder1.setText(NAMES[i]);
            holder2.setText(TIME[i]);

            return view;
        }
    }

}
