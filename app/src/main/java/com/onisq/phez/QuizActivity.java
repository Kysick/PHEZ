package com.onisq.phez;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class QuizActivity extends AppCompatActivity {

    private EditText editText;

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
    static final private int QUIZ_COUNT = 5;
    SharedPref sharedPref;


    ArrayList<ArrayList<String>> arrQuiz = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {


        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightModeState() == true){
            setTheme(R.style.darkTheme);
        }
        else setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);

        final String themeString;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                themeString= null;
            } else {
                themeString = extras.getString("THEME_TASK");
            }
        } else {
            themeString = (String) savedInstanceState.getSerializable("THEME_TASK");
        }

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

        int themeInt = Integer.parseInt(themeString);
        switch (themeInt){
            case 1: case 4: case 7: case 10: case 13: case 16: case 19: case 22: case 25: case 28: case 31:
                setContentView(R.layout.activity_quiz1);

                numQ = (TextView) findViewById(R.id.numQ);
                question = (TextView) findViewById(R.id.question);
                ansbtn1 = (Button) findViewById(R.id.ansbtn1);
                ansbtn2 = (Button) findViewById(R.id.ansbtn2);
                ansbtn3 = (Button) findViewById(R.id.ansbtn3);
                ansbtn4 = (Button) findViewById(R.id.ansbtn4);

                String commandB = "SELECT * FROM tasks " + "WHERE themeID = '" + themeString + "'";
                Cursor cursorB = mDb.rawQuery(commandB, null);
                cursorB.moveToFirst();
                while (!cursorB.isAfterLast()) {
                    ArrayList<String> arrTmp = new ArrayList<>();
                    arrTmp.add(cursorB.getString(cursorB.getColumnIndex("question")));
                    arrTmp.add(cursorB.getString(cursorB.getColumnIndex("ans1")));
                    arrTmp.add(cursorB.getString(cursorB.getColumnIndex("ans2")));
                    arrTmp.add(cursorB.getString(cursorB.getColumnIndex("ans3")));
                    arrTmp.add(cursorB.getString(cursorB.getColumnIndex("ans4")));
                    arrQuiz.add(arrTmp);
                    cursorB.moveToNext();
                }

                showNextBronze();
                break;
            case 2: case 5: case 8: case 11: case 14: case 17: case 20: case 23: case 26: case 29: case 32:
                setContentView(R.layout.activity_quiz2);
                showNextSilver();
                break;
            case 3: case 6: case 9: case 12: case 15: case 18: case 21: case 24: case 27: case 30: case 33:
                setContentView(R.layout.activity_quiz3);

                numQ = (TextView) findViewById(R.id.numQ);
                question = (TextView) findViewById(R.id.question);
                editText = (EditText) findViewById(R.id.answer);

                editText.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (event.getAction() == KeyEvent.ACTION_DOWN){
                            if(keyCode ==  KeyEvent.KEYCODE_ENTER){
                                checkAnswerGold();
                            }
                        }
                        return false;
                    }
                });
                String commandG = "SELECT * FROM tasks " + "WHERE themeID = '" + themeString + "'";
                Cursor cursorG = mDb.rawQuery(commandG, null);
                cursorG.moveToFirst();
                while (!cursorG.isAfterLast()) {
                    ArrayList<String> arrTmp = new ArrayList<>();
                    arrTmp.add(cursorG.getString(cursorG.getColumnIndex("question")));
                    arrTmp.add(cursorG.getString(cursorG.getColumnIndex("ans1")));
                    arrQuiz.add(arrTmp);
                    cursorG.moveToNext();
                }
                showNextGold();
                break;
        }
    }

    public void showNextBronze(){
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
    public void showNextSilver(){

    }
    public void showNextGold(){
        numQ.setText("Question " + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(arrQuiz.size());

        ArrayList<String> quiz = arrQuiz.get(randomNum);

        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        arrQuiz.remove(randomNum);
    }

    public void checkAnswerBronze(View view){

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
                    showNextBronze();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    public void checkAnswerSilver(){

    }
    public void checkAnswerGold(){

        String answer = editText.getText().toString().toLowerCase();

        String alert;
        if(answer.equals(rightAnswer)){
            alert = "Your right";
            rightAnswerCount++;
        }else{
            alert = "Your wrong";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alert);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText.setText("");
                if(arrQuiz.size() < 1  ){
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("RIGHT_ANSWER", rightAnswerCount);
                    startActivity(i);
                }else{
                    quizCount++;
                    showNextGold();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
