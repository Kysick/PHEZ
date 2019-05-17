package com.onisq.phez;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class FragmentHome   extends Fragment {

    View v;
    TextView tvPB;
    Button formula;
    Button settings;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    public FragmentHome() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);

        SharedPref sharedPref;
        sharedPref = new SharedPref(getContext());
        if(sharedPref.loadNightModeState() == true){
            getActivity().setTheme(R.style.darkTheme);
        }
        else getActivity().setTheme(R.style.AppTheme);

        mDBHelper = new DatabaseHelper(getContext());

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        Cursor cursor = mDb.rawQuery("select * from stats", null);
        cursor.moveToFirst();
        int Score = cursor.getInt(cursor.getColumnIndex("Points"));


        ProgressBar progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        progressBar.setProgress(Score);


        formula =  (Button) v.findViewById(R.id.formulaBTN);
        formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(getActivity(), FormulaActivity.class);
                startActivity(i);
            }
        });

        settings = (Button) v.findViewById(R.id.settingsBTN);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii;
                ii = new Intent(getActivity(), SettingsActivity.class);
                startActivity(ii);
            }
        });

        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, Score);
        animation.setDuration(1);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        tvPB = (TextView) v.findViewById(R.id.tvPB);
        tvPB.setText(Score + " exp");

        return v;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
