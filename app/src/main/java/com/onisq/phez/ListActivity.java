package com.onisq.phez;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.io.IOException;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private ListView lv;
    private Button formulaBtn;
    private SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightModeState() == true){
            setTheme(R.style.darkTheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Getting theme
        final String themeString;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                themeString= null;
            } else {
                themeString= extras.getString("THEME_STRING");
            }
        } else {
            themeString= (String) savedInstanceState.getSerializable("THEME_STRING");
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

        final ArrayList<Theme> themes = new ArrayList<>();
        String command = "SELECT * FROM " + themeString;
        Cursor cursor = mDb.rawQuery(command, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            themes.add(new Theme(cursor.getString(0)));
            cursor.moveToNext();
        }


        lv = (ListView) findViewById(R.id.lvThemeList);
     //   ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, themes );
        ThemeAdapter themeAdapter = new ThemeAdapter(themes,ListActivity.this);
        lv.setAdapter(themeAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(), "Вы выбрали " + themes.get(position) , Toast.LENGTH_SHORT).show();
                Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
                animation1.setDuration(200);
                view.startAnimation(animation1);
                Intent i;
                i = new Intent(getApplicationContext(), BookActivity.class);
                i.putExtra("THEME_STRING", themeString);
                i.putExtra("SMALLER_THEME_STRING", themes.get(position).getName());


                startActivity(i);
            }
        });

        formulaBtn = (Button) findViewById(R.id.formulaThemeBTN);

        formulaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii;
                ii = new Intent(getApplicationContext(), FormulaActivity.class);
                ii.putExtra("THEME_STRING", themeString);
                startActivity(ii);
            }
        });

    }


}
