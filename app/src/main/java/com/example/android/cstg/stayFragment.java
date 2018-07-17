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
public class stayFragment extends Fragment {
    final static ArrayList<Place> places = new ArrayList<Place>();
    public int colorID;

    public stayFragment() {
        // Required empty public constructor
    }

    public static stayFragment newInstance() {
        stayFragment fragment = new stayFragment();
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
        places.add(new Place(R.string.stay, R.drawable.cliffhouse, R.string.chTitle, R.string.chDesc, R.string.chAdd, R.string.chWeb, R.string.chVar));
        places.add(new Place(R.string.stay, R.drawable.cheyennemountainresort, R.string.cmrTitle, R.string.cmrDesc, R.string.cmrAdd, R.string.cmrWeb, R.string.cmrVar));
        places.add(new Place(R.string.stay, R.drawable.broadmoor, R.string.broadTitle, R.string.broadDesc, R.string.broadAdd, R.string.broadWeb, R.string.broadVar));
        places.add(new Place(R.string.stay, R.drawable.gleneyrie, R.string.glenTitle, R.string.glenDesc, R.string.glenAdd, R.string.glenWeb, R.string.glenVar));
        places.add(new Place(R.string.stay, R.drawable.sunmountain, R.string.smTitle, R.string.smDesc, R.string.smAdd, R.string.smWeb, R.string.smVar));
        colorID = R.color.purple;

        placeAdapter adapter = new placeAdapter(getContext(), places, colorID);
        ListView listview = (ListView) rootView.findViewById(R.id.list);
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
