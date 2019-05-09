package com.onisq.phez;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class ResultActivity extends AppCompatActivity {

    TextView resultTv;
    TextView totalScoreTv;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

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

        resultTv = (TextView) findViewById(R.id.resultTv);
        totalScoreTv = (TextView) findViewById(R.id.totalScoreTv);


        Cursor cursor = mDb.rawQuery("select * from stats", null);
        cursor.moveToFirst();
        int oldScore = cursor.getInt(cursor.getColumnIndex("Points"));
        int score = getIntent().getIntExtra("RIGHT_ANSWER", 0 );
        int finalScore = score + oldScore;

        ContentValues cv = new ContentValues();
        cv.put("Points",finalScore);

        mDb.update("stats", cv,null, null);

        String fscore = Integer.toString(finalScore);

        resultTv.setText(score + " / 5");
        totalScoreTv.setText("Total Score : " + fscore);
    }

    public void returnTop(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
