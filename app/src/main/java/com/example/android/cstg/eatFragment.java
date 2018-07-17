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

public class eatFragment extends Fragment {
    final static ArrayList<Place> places = new ArrayList<Place>();
    public int colorID;

    public eatFragment() {
        // Required empty public constructor
    }

    public static eatFragment newInstance() {
        eatFragment fragment = new eatFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        places.clear();
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //clear arraylist so entries don't duplicate on re-entry
        places.clear();

        //create the place ArrayList
        places.add(new Place(R.string.eat, R.drawable.brotherluck, R.string.fourTitle, R.string.fourDesc, R.string.fourAddress, R.string.fourPhone, R.string.fourWeb, R.string.fourHours));
        places.add(new Place(R.string.eat, R.drawable.margarita, R.string.margTitle, R.string.margDesc, R.string.margAddress, R.string.margPhone, R.string.margWeb, R.string.margHours));
        places.add(new Place(R.string.eat, R.drawable.piglatin, R.string.pigTitle, R.string.pigDesc, R.string.pigAdd, R.string.pigPhone, R.string.pigWeb, R.string.pigHours));
        places.add(new Place(R.string.eat, R.drawable.rabbithole, R.string.rabbitTitle, R.string.rabbitDesc, R.string.rabbitAdd, R.string.rabbitPhone, R.string.rabbitWeb, R.string.rabbitHours));
        places.add(new Place(R.string.eat, R.drawable.caspian, R.string.caspTitle, R.string.caspDesc, R.string.caspAdd, R.string.rabbitPhone, R.string.caspWeb, R.string.caspHours));
        places.add(new Place(R.string.eat, R.drawable.shugas, R.string.shugasTitle, R.string.shugasDesc, R.string.shugasAdd, R.string.shugasPhone, R.string.shugasWeb, R.string.shugasHours));

        colorID = R.color.blushPink;

        placeAdapter adapter = new placeAdapter(getContext(), places, colorID);
        ListView listview = rootView.findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getActivity();
                Intent intent = new Intent(getContext(), DetailActivity.class);
                Bundle args = new Bundle();
                args.putString("FragmentName", "Eat");
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