package com.onisq.phez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTv;
    TextView totalScoreTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTv = (TextView) findViewById(R.id.resultTv);
        totalScoreTv = (TextView) findViewById(R.id.totalScoreTv);

        int score = getIntent().getIntExtra("RIGHT_ANSWER", 0 );

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = settings.getInt("totalScore", 0);
        totalScore += score;

        resultTv.setText(score + " / 5");
        totalScoreTv.setText("Total Score : " + totalScore);

        //Update Total Score
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();
    }

    public void returnTop(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

}
