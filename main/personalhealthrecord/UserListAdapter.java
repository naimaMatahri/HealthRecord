package com.example.personalhealthrecord;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends ArrayAdapter<AddAppointment> {

    private Context mContext;
    int mResource;

    public UserListAdapter(Context context, int resource, ArrayList<AddAppointment> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String locationString = getItem(position).getLocation();
        String reasonString = getItem(position).getReason();
        String time = getItem(position).getTime();
        String date = getItem(position).getDate();

        AddAppointment addAppointment = new AddAppointment(locationString, reasonString, time, date);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView locationTxView = (TextView) convertView.findViewById(R.id.locationView);
        TextView reasonTxView = (TextView) convertView.findViewById(R.id.reasonView);
        TextView timeTxView = (TextView) convertView.findViewById(R.id.timeView);
        TextView dateTxView = (TextView) convertView.findViewById(R.id.dateView);

        locationTxView.setText(locationString);
        reasonTxView.setText(reasonString);
        timeTxView.setText(time);
        dateTxView.setText(date);

        return convertView;

    }
}
