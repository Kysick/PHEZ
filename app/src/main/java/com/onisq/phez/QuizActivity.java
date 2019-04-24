package com.onisq.phez;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class QuizActivity extends AppCompatActivity {

    private TextView numQ;
    private TextView question;
    private Button ansbtn1;
    private Button ansbtn2;
    private Button ansbtn3;
    private Button ansbtn4;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private String count;
    static final private int QUIZ_COUNT = 2;

    ArrayList<ArrayList<String>> arrQuiz = new ArrayList<>();

    //need to put data
    String quizData[][] = {
            {"Каким символом обозначается скорость?", "v", "T", "S", "a"},
            {"Масса измеряется в:", "кг", "с", "м", "м//с"}
    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        numQ = (TextView) findViewById(R.id.numQ);
        question = (TextView) findViewById(R.id.question);
        ansbtn1 = (Button) findViewById(R.id.ansbtn1);
        ansbtn2 = (Button) findViewById(R.id.ansbtn2);
        ansbtn3 = (Button) findViewById(R.id.ansbtn3);
        ansbtn4 = (Button) findViewById(R.id.ansbtn4);


        for(int i = 0;i < quizData.length; i++){
                ArrayList<String> arrTmp = new ArrayList<>();
                arrTmp.add(quizData[i][0]);
                arrTmp.add(quizData[i][1]);
                arrTmp.add(quizData[i][2]);
                arrTmp.add(quizData[i][3]);
                arrTmp.add(quizData[i][4]);

                arrQuiz.add(arrTmp);
        }
        showNextQuiz();
    }

    public void showNextQuiz(){
        numQ.setText("Question " + quizCount);
        Random random = new Random();

        int randomNum = random.nextInt(arrQuiz.size());

        ArrayList<String> quiz = arrQuiz.get(randomNum);
        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        ansbtn1.setText(quiz.get(0));
        ansbtn2.setText(quiz.get(1));
        ansbtn3.setText(quiz.get(2));
        ansbtn4.setText(quiz.get(3));

        arrQuiz.remove(randomNum);
    }

    public void checkAnswer(View view){

        Button ansBtn = (Button) findViewById(view.getId());
        String btnTx = ansBtn.getText().toString();

        String alert;

        if(btnTx.equals(rightAnswer)){
            alert = "You right";
            rightAnswerCount++;
        }else{
            alert = "You wrong";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alert);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT){
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("RIGHT_ANSWER", rightAnswerCount);
                    startActivity(i);
                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}