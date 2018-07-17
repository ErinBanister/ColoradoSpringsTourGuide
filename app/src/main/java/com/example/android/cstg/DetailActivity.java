package com.example.android.cstg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import static android.view.View.GONE;


public class DetailActivity extends AppCompatActivity {
    public int picID;
    public int nameID;
    public int descID;
    public int addID;
    public int phoneID;
    public int webID;
    public int hoursID;
    public int colorID;
    public String fragment;
    public int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_detail);

        Intent intent = getIntent();
        //Bundle & pass values to the fragment to populate the detailed data
        Bundle args = intent.getBundleExtra("Bundle");
        fragment = args.getString("FragmentName");
        position = args.getInt("Position");
        picID = args.getInt("Pic");
        nameID = args.getInt("Name");
        descID = args.getInt("Desc");
        addID = args.getInt("Add");
        phoneID = args.getInt("Phone");
        webID = args.getInt("Web");
        hoursID = args.getInt("Hours");
        colorID = args.getInt("Color");

        //set toolbar
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //use collapsing toolbar
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(nameID));
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.cardview_light_background));
        setValues();
    }

    private void setValues() {
        ImageView image = findViewById(R.id.mainImage);
        Glide.with(this).load(getDrawable(picID)).apply(RequestOptions.centerCropTransform()).into(image);

        //set card colors
        View titleCard = findViewById(R.id.titleCard);
        View aboutCard = findViewById(R.id.aboutCard);
        titleCard.setBackgroundColor(colorID);
        aboutCard.setBackgroundColor(colorID);


        ///set title
        TextView title = findViewById(R.id.cardTitle);
        title.setText(getResources().getString(nameID));

        //set description
        TextView desc = findViewById(R.id.cardDesc);
        desc.setText(getResources().getString(descID));

        //set hours, if a value is available
        TextView hours = findViewById(R.id.cardHours);
        if (hoursID == 0) {
            hours.setVisibility(View.GONE);
        } else {
            hours.setVisibility(View.VISIBLE);
            hours.setText(getResources().getString(hoursID));
        }

        //set phone, if a value is available
        TextView phone = findViewById(R.id.cardPhone);
        if (phoneID == 0) {
            phone.setVisibility(GONE);
        } else {
            phone.setVisibility(View.VISIBLE);
            phone.setText(getResources().getString(phoneID));
        }
        //set address
        TextView address = findViewById(R.id.cardAddress);
        address.setText(getResources().getString(addID));

        //set web
        TextView web = findViewById(R.id.cardWeb);
        web.setText(getResources().getString(webID));
        web.setLinksClickable(true);

    }
}



