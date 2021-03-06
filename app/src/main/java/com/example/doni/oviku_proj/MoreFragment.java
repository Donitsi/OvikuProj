package com.example.doni.oviku_proj;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Doni on 10/25/2017.
 */

public class MoreFragment extends Fragment{

    int[] IMAGES = {R.drawable.ic_sign_in, R.drawable.ic_add_virtual_key, R.drawable.ic_add_new_key, R.drawable.ic_lock};

    String[] TEXT = {"Log out", "Add virtual key", "Add new lock", "My locks"};

    String[] TIME ={" ", " ", " ", " "};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_more_page, container, false);

        TextView toolbarText = (TextView)v.findViewById(R.id.toolbarText);
        toolbarText.setText("More");

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Resources res = getResources();
                String [] category_more = res.getStringArray(R.array.category_more);
                String category = category_more[position];
                if(category.equals("Log out")) {



                    //Remove all data
                    SaveSharedPreference.clearUserName(getContext());

/*                    SharedPreferences.Editor editor = SaveSharedPreference.getSharedPreferences(getContext()).edit();
                    editor.clear();
                    editor.commit();*/

                    Intent homeIntent = new Intent(getActivity(), SignInPage.class);
                    startActivity(homeIntent);
                }
                else if(category.equals("Add virtual key")){
                    //Open adding virtual key
                }
                else if(category.equals("Add new lock")){
                    // Open Add new lock page
                }

                else if(category.equals("My locks")){
                    // Open My locks page
                    MyLocksFragment f = new MyLocksFragment();
                    getFragmentManager().beginTransaction().replace(R.id.main_frame, f).commit();
                }
            }
        });

        return v;
    }



    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
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
            holder1.setText(TEXT[i]);
            holder2.setText(TIME[i]);

            return view;
        }
    }

}
