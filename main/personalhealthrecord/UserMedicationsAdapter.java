package com.example.personalhealthrecord;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserMedicationsAdapter extends ArrayAdapter<AddMedication> {

    String medNameString, daysSupplyString, doseString, dateDispensedString;

    private Context mContext;
    int mResource;

    public UserMedicationsAdapter(Context context, int resource, ArrayList<AddMedication> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        medNameString = getItem(position).getMedicationName();
        daysSupplyString = getItem(position).getDaysSupply();
        doseString = getItem(position).getDose();
        dateDispensedString = getItem(position).getDateDispensed();

        AddMedication addMedication = new AddMedication(medNameString, daysSupplyString, doseString, dateDispensedString);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView medNameTxView = (TextView) convertView.findViewById(R.id.medNameAdapter);
        TextView daysSupplyTxView = (TextView) convertView.findViewById(R.id.daysSupplyAdapter);
        TextView doseTxView = (TextView) convertView.findViewById(R.id.doseAdapter);
        TextView dateDispensedTxView = (TextView) convertView.findViewById(R.id.dateDispensedAdapter);

        medNameTxView.setText(medNameString);
        daysSupplyTxView.setText(daysSupplyString);
        doseTxView.setText(doseString);
        dateDispensedTxView.setText(dateDispensedString);

        return convertView;

    }
}


