package com.example.nakhonpathom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nakhonpathom.R;
import com.example.nakhonpathom.model.Place;

import java.util.List;

public class PlaceListAdapter extends ArrayAdapter<Place> {

        private Context mContext;
        private  int mRescorce;
        private  List<Place> mPlaceList;


    public PlaceListAdapter(@NonNull Context context, int resource, @NonNull List<Place> placeList) {
        super(context, resource, placeList);
        this.mContext = context;
        this.mRescorce = resource;
        this.mPlaceList = placeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(mRescorce,parent,false);

        Place place = mPlaceList.get(position);
         //กำหนดชื่อสถานที่ของ textview
        TextView placeNameTextView =v.findViewById(R.id.place_name_text_view);
        placeNameTextView.setText(place.name);
        //กำหนดอำเภอ่ของ textview
        TextView districtTextView =v.findViewById(R.id.district_text_view);
        districtTextView.setText(place.district);

        return v;
    }
}
