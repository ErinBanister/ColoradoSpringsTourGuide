package com.example.android.cstg;

import java.util.ArrayList;

/**
 * Public CLass {@Link place} represents a place within Springs a Tourist May want to visit.
 */

public class Place extends ArrayList {
    //local variables for each descriptor of a location
    private int mPlaceType;
    private int mPlacePic;
    private int mPlaceName;
    private int mDescription;
    private int mAddress;
    private int mPhone;
    private int mWeb;
    private int mHours;

    private boolean alternatePlace = false;

    //create a new place object, pass in values for each of the descriptors, having each description field
    public Place(int placeType, int placePic, int nameId, int descId, int addressId, int phoneId, int webId, int hours) {
        mPlaceType = placeType;
        mPlacePic = placePic;
        mPlaceName = nameId;
        mDescription = descId;
        mAddress = addressId;
        mPhone = phoneId;
        mWeb = webId;
        mHours = hours;
    }

    public Place(int placeTypeID, int placePic, int nameId, int descId, int addressId, int webId, int variantID) {
        mPlaceType = placeTypeID;
        if (mPlaceType == R.string.stay) {
            mPhone = variantID;
            mHours = 0;
            alternatePlace = true;
        } else {
            mHours = variantID;
            mPhone = 0;
            alternatePlace = true;
        }

        mPlacePic = placePic;
        mPlaceName = nameId;
        mDescription = descId;
        mAddress = addressId;
        mWeb = webId;
    }

    //methods to retrieve the values from the ArrayList
    public int getPlacePic() {
        return mPlacePic;
    }

    public int getPlaceName() {
        return mPlaceName;
    }

    public int getDescription() {
        return mDescription;
    }

    public int getAddress() {
        return mAddress;
    }

    public int getPhone() {
        return mPhone;
    }

    public int getWeb() {
        return mWeb;
    }

    public int getHours() {
        return mHours;
    }

    public boolean getAltPlace() {
        return alternatePlace;
    }

}
