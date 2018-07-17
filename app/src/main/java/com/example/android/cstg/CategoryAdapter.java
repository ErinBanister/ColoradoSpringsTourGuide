package com.example.android.cstg;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * CategoryAdapter provides a layout for each list item group using the TabLayout class
 */
public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new eatFragment();
        } else if (position == 1) {
            return new playFragment();
        } else if (position == 2) {
            return new stayFragment();
        } else {
            return new seeFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.eat);
        } else if (position == 1) {
            return mContext.getString(R.string.play);
        } else if (position == 2) {
            return mContext.getString(R.string.stay);
        } else {
            return mContext.getString(R.string.see);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
