package com.onisq.phez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nishant.math.MathView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<FormulaItem> {

    private ArrayList<FormulaItem> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView theme;
        TextView  definition;
        MathView formula;
    }


    public CustomAdapter(ArrayList<FormulaItem> data, Context context){
        super(context, R.layout.formula_item, data);
        this.dataSet = data;
        this.mContext=context;
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
            viewHolder.formula = (MathView) convertView.findViewById(R.id.formula_math);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        viewHolder.theme.setText(formulaItem.getTheme());
        viewHolder.definition.setText(formulaItem.getDefinition());
        viewHolder.formula.setText(formulaItem.getFormula());


        return convertView;


    }





}


