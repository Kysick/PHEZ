package com.onisq.phez;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Getting theme
        String themeString;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                themeString= null;
            } else {
                themeString= extras.getString("STRING_I_NEED");
            }
        } else {
            themeString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        //Setting database

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

        ArrayList<String> themes = new ArrayList<>();
        String command = "SELECT * FROM " + themeString;
        Cursor cursor = mDb.rawQuery(command, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
           themes.add(cursor.getString(0));
            cursor.moveToNext();
        }


        lv = (ListView) findViewById(R.id.lvThemeList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, themes );
        lv.setAdapter(adapter);

    }
}
