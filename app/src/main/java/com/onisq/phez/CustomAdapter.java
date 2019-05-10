package com.onisq.phez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<FormulaItem> {

    private ArrayList<FormulaItem> dataSet;
    private Context mContext;


    private static class ViewHolder {
        TextView theme;
        TextView definition;
        ImageView formula;
    }


    public CustomAdapter(ArrayList<FormulaItem> data, Context context) {
        super(context, R.layout.formula_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    private int lastPosition = -1;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FormulaItem formulaItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.formula_item, parent, false);
            viewHolder.theme = (TextView) convertView.findViewById(R.id.formula_theme);
            viewHolder.definition = (TextView) convertView.findViewById(R.id.formula_definition);
            viewHolder.formula = (ImageView) convertView.findViewById(R.id.formula_math);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.theme.setText(formulaItem.getTheme());
        viewHolder.definition.setText(formulaItem.getDefinition());
        int resID = mContext.getResources().getIdentifier(formulaItem.getFormula(), "drawable", mContext.getPackageName());
        if (resID != 0) {//The associated resource identifier. Returns 0 if no such resource was found. (0 is not a valid resource ID.)
            viewHolder.formula.setImageResource(resID);
        }
        return convertView;
    }



}


