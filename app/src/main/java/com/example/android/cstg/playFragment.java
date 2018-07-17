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
public class playFragment extends Fragment {
    final static ArrayList<Place> places = new ArrayList<Place>();
    public int colorID;

    public playFragment() {
        // Required empty public constructor
    }

    public static playFragment newInstance() {
        playFragment fragment = new playFragment();
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
        places.add(new Place(R.string.play, R.drawable.ppbrodeo, R.string.rodeoTitle, R.string.rodeoDesc, R.string.rodeoAdd, R.string.rodeoWeb, R.string.rodeoVar));
        places.add(new Place(R.string.play, R.drawable.emma, R.string.emmaTitle, R.string.emmaDesc, R.string.emmaAdd, R.string.emmaWeb, R.string.emmaVar));
        places.add(new Place(R.string.play, R.drawable.ccicefest, R.string.iceTitle, R.string.iceDesc, R.string.iceAdd, R.string.iceWeb, R.string.iceVar));
        places.add(new Place(R.string.play, R.drawable.ppihc, R.string.ppihcTitle, R.string.ppihcDesc, R.string.ppihcAdd, R.string.ppihcWeb, R.string.ppihcVar));
        places.add(new Place(R.string.play, R.drawable.territorydays, R.string.terrTitle, R.string.terrDesc, R.string.terrAdd, R.string.terrWeb, R.string.terrVar));
        colorID = R.color.darkBlue;

        placeAdapter adapter = new placeAdapter(getContext(), places, colorID);
        ListView listview = rootView.findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getActivity();
                Intent intent = new Intent(getContext(), DetailActivity.class);
                Bundle args = new Bundle();
                args.putString("FragmentName", "Play");
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
