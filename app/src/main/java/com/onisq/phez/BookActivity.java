package com.onisq.phez;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;

public class BookActivity extends AppCompatActivity {

    PDFView pdfView;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final String smallerthemeString;
        final String themeString;
        String themeToShow;


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                themeString= null;
                smallerthemeString = null;
            } else {
                smallerthemeString = extras.getString("SMALLER_THEME_STRING");
                themeString= extras.getString("THEME_STRING");
            }
        } else {
            themeString= (String) savedInstanceState.getSerializable("THEME_STRING");
            smallerthemeString = (String) savedInstanceState.getSerializable("SMALLER_THEME_STRING");
        }

        String command = "SELECT pdf FROM " + themeString + " WHERE theme = '" + smallerthemeString + "'" ;

        //setting db
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

        //Selecting theme


        Cursor cursor = mDb.rawQuery(command, null);
        cursor.moveToFirst();
        themeToShow = cursor.getString(0);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset(themeToShow + ".pdf").load();
    }
}
