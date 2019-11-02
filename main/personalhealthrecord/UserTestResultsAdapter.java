package com.example.personalhealthrecord;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class UserTestResultsAdapter extends ArrayAdapter<AddTestResult> {

    String testNameString, daysDoneString, normalRangeString, yourValuesString;

    private Context mContext;
    int mResource;

    public UserTestResultsAdapter(Context context, int resource, ArrayList<AddTestResult> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        testNameString = getItem(position).getTestName();
        daysDoneString = getItem(position).getDaysDone();
        normalRangeString = getItem(position).getNormalRange();
        yourValuesString = getItem(position).getYourValues();

        AddTestResult addTestResult = new AddTestResult(testNameString, daysDoneString, normalRangeString, yourValuesString);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView testNameTxView = (TextView) convertView.findViewById(R.id.testDoneAdapter);
        TextView dayDonTxView = (TextView) convertView.findViewById(R.id.dateDoneAdapter);
        TextView normalRangeTxView = (TextView) convertView.findViewById(R.id.normalRangeAdapter);
        TextView yourValuesTxView = (TextView) convertView.findViewById(R.id.yourValuesAdapter);

        testNameTxView.setText(testNameString);
        dayDonTxView.setText(daysDoneString);
        normalRangeTxView.setText(normalRangeString);
        yourValuesTxView.setText(yourValuesString);

        return convertView;

    }
}


