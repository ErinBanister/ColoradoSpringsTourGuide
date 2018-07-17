package com.example.android.cstg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class seeFragment extends Fragment {
    final static ArrayList<Place> places = new ArrayList<Place>();
    public int colorID;

    public seeFragment() {
        // Required empty public constructor
    }

    public static seeFragment newInstance() {
        seeFragment fragment = new seeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        places.clear();
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);
        places.clear();
        //create the place ArrayList
        //public Place(int placeType, int placePic, int nameId, int descId, int addressId, int phoneId, int webId, int hours){
        places.add(new Place(R.string.see, R.drawable.cheyennemountainzoo, R.string.cmzTitle, R.string.cmzDesc, R.string.cmzAdd, R.string.cmzPhone, R.string.cmzWeb, R.string.cmzHours));
        places.add(new Place(R.string.see, R.drawable.railroad, R.string.rrTitle, R.string.rrDesc, R.string.rrAdd, R.string.rrPhone, R.string.rrWeb, R.string.rrHours));
        places.add(new Place(R.string.see, R.drawable.cliffdwellings, R.string.cdTitle, R.string.cdDesc, R.string.cdAdd, R.string.cdPhone, R.string.cdWeb, R.string.cdHours));
        places.add(new Place(R.string.see, R.drawable.ghosttown, R.string.ghostTitle, R.string.ghostDesc, R.string.ghostAdd, R.string.ghostPhone, R.string.ghostWeb, R.string.ghostHours));
        colorID = R.color.grey;

        placeAdapter adapter = new placeAdapter(getContext(), places, colorID);
        ListView listview = (ListView) rootView.findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getActivity();
                Intent intent = new Intent(getContext(), DetailActivity.class);
                Bundle args = new Bundle();
                args.putString("FragmentName", "See");
                args.putInt("Color", colorID);
                args.putInt("Pic", places.get(position).getPlacePic());
                args.putInt("Name", places.get(position).getPlaceName());
                args.putInt("Desc", places.get(position).getDescription());
                args.putInt("Add", places.get(position).getAddress());
                args.putInt("Phone", places.get(position).getPhone());
                args.putInt("Web", places.get(position).getWeb());
                args.putInt("Hours", places.get(position).getHours());
                intent.putExtra("Bundle", args);
                context.startActivity(intent);
            }
        });

        return rootView;
    }
}

