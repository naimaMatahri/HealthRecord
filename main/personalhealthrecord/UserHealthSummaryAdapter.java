package com.example.personalhealthrecord;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

public class UserHealthSummaryAdapter extends ArrayAdapter<AddHealthSummary> {

    String healthSummary;
    private Context mContext;
    int mResource;

    public UserHealthSummaryAdapter(Context context, int resource, ArrayList<AddHealthSummary> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        healthSummary = getItem(position).getHealthSummaryString();

        AddHealthSummary addHealthSummary = new  AddHealthSummary(healthSummary);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

//        TextView healthSummaryTxView = (TextView) convertView.findViewById(R.id.activity_test_results);

//        healthSummaryTxView .setText(healthSummary);

        return convertView;

    }
}

