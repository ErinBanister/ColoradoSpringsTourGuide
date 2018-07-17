package com.example.android.cstg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeAdapter extends ArrayAdapter<Place> {
    private int mColorId;
    private Context mContext;

    public placeAdapter(Context context, ArrayList<Place> places, int colorID) {
        super(context, 0, places);
        mColorId = colorID;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //if an view isn't being used, inflate the view
        View listItemView = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (listItemView == null) {
            try {
                listItemView = inflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            } catch (InflateException e) {
                e.printStackTrace();
            }
        }

        final Place currentPlace = getItem(position);
        ImageView phone = listItemView.findViewById(R.id.phone);
        ImageView directions = listItemView.findViewById(R.id.directions);
        ImageView web = listItemView.findViewById(R.id.web);
        ImageView pic = listItemView.findViewById(R.id.itemImage);
        TextView placeName = listItemView.findViewById(R.id.itemTitle);
        TextView description = listItemView.findViewById(R.id.itemDesc);
        TextView hours = listItemView.findViewById(R.id.hours);

        //set pic, name, & description
        pic.setImageResource(currentPlace.getPlacePic());
        placeName.setText(currentPlace.getPlaceName());
        pic.setContentDescription(placeName.getText());
        description.setText(currentPlace.getDescription());

        //if hours = 0, then get rid of box. Otherwise, set text
        if (currentPlace.getAltPlace()) {
            if (currentPlace.getHours() == 0) {
                phone.setVisibility(View.VISIBLE);
                hours.setVisibility(View.GONE);

            } else { //if there is an hours value, then set the phone visibiliy to gone
                hours.setText(currentPlace.getHours());
                hours.setVisibility(View.VISIBLE);
                phone.setVisibility(View.GONE);
            }
        } else {
            hours.setVisibility(View.VISIBLE);
            hours.setText(currentPlace.getHours());
        }

        //set the background color of this item
        int color = ContextCompat.getColor(getContext(), mColorId);
        listItemView.setBackgroundColor(color);

        //set onClickListeners for buttons
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = mContext.getString(currentPlace.getPhone());
                phoneNum = phoneNum.replaceAll("[()-]", "");
                phoneNum = "tel:" + phoneNum;
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(phoneNum));
                mContext.startActivity(callIntent);
            }
        });

        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "geo:0,0?q=" + mContext.getString(currentPlace.getAddress());
                Uri myUri = Uri.parse(address);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(myUri);
                if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                    mContext.startActivity(intent);
                }
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringUrl = mContext.getString(currentPlace.getWeb());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(stringUrl));
                mContext.startActivity(intent);

            }
        });

        return listItemView;

    }
}

