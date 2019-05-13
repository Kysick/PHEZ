package com.onisq.phez;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThemeAdapter extends ArrayAdapter<Theme> {

    private ArrayList<Theme> dataSet;
    private Context mContext;


    private static class ViewHolder {
        TextView theme;
    }


    public ThemeAdapter(ArrayList<Theme> data, Context context) {
        super(context, R.layout.book_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPosition = -1;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Theme theme = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.book_item, parent, false);
            viewHolder.theme = (TextView) convertView.findViewById(R.id.txt_theme);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.theme.setText(theme.getName());
        return convertView;
    }



}