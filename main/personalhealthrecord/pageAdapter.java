package com.example.personalhealthrecord;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class pageAdapter extends ArrayAdapter<String> {

    String[] activitiesNames;
    int[] iconsItems;
    Context context;

    public pageAdapter(Context context, String[] activitiesNames, int[] iconsItems) {
        super(context, R.layout.listview_item);

        this.activitiesNames = activitiesNames;
        this.iconsItems = iconsItems;
        this.context = context;
    }

    //returns the size of the item inside the list view
    @Override
    public int getCount() {
        return activitiesNames.length;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mFlag.setImageResource(iconsItems[position]);
        mViewHolder.mName.setText(activitiesNames[position]);

        return convertView;

    }

    static class ViewHolder {

        ImageView mFlag;
        TextView mName;
    }

}
