package com.onisq.phez;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class FormulaActivity extends AppCompatActivity {


    ArrayList<FormulaItem> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        listView=(ListView)findViewById(R.id.formula_list);

        dataModels= new ArrayList<>();

        mDBHelper = new DatabaseHelper(this);

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


        //Selecting from theme table
        final String themeString;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                themeString= "";
            } else {
                themeString= extras.getString("THEME_STRING");
            }
        } else {
            themeString= (String) savedInstanceState.getSerializable("THEME_STRING");
        }
        String place;




        switch (themeString){
            case("themesKinematics"):
                place = "WHERE theme = 'Кинематика'";
                break;
            case("themesDynamics"):
                place = "WHERE theme = 'Динамика'";
                break;
            case("themesElectricCurrent"):
                place = "WHERE theme = 'Электрический ток'";
                break;
            case("themesElectricity"):
                place = "WHERE theme = 'Электричество'";
                break;
            case("themesElectroMagnetic"):
                place = "WHERE theme = 'Электромагнетизм'";
                break;
            case("themesLawOfSaving"):
                place = "WHERE theme = 'Законы сохранения'";
                break;
            case("themesMagnetic"):
                place = "WHERE theme = 'Магнетизм'";
                break;
            case("themesMolecularPhysics"):
                place = "WHERE theme = 'Молекулярная физика'";
                break;
            case("themesStatic"):
                place = "WHERE theme = 'Статика'";
                break;
            case("themesTermoDynamic"):
                place = "WHERE theme = 'Термодинамика'";
                break;
            case("themesVolatility"):
                place = "WHERE theme = 'Колебания и волны'";
                break;
            default:
               place = "";
        }




        final ArrayList<String> themes = new ArrayList<>();
        String command = "SELECT * FROM formulas " + place;
        Cursor cursor = mDb.rawQuery(command, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            dataModels.add(new FormulaItem(cursor.getString(2),cursor.getString(1),cursor.getString(0)));
           cursor.moveToNext();
        }


       // dataModels.add(new FormulaItem("Кинематика","Закон Бойля – Мариотта (изотермический процесс)", "a011_atom"  ));

        adapter= new CustomAdapter(dataModels,getApplicationContext());
        listView.setAdapter(adapter);


    }



}
