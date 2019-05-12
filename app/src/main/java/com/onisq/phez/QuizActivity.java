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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
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

    private CheckBox ans1;
    private CheckBox ans2;
    private CheckBox ans3;
    private CheckBox ans4;
    private CheckBox ans5;
    private CheckBox ans6;
    private Button submitBtn;

    private EditText editText;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<String> selection = new ArrayList<>();
    ArrayList<ArrayList<String>> arrQuiz = new ArrayList<>();
    ArrayList<String> Quiz = new ArrayList<>();
    ArrayList<String> rightAns = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
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

            //BronzeQuiz
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

            //SilverQuiz
            case 2: case 5: case 8: case 11: case 14: case 17: case 20: case 23: case 26: case 29: case 32:
                setContentView(R.layout.activity_quiz2);

                numQ = (TextView) findViewById(R.id.numQ);
                question = (TextView) findViewById(R.id.question);
                ans1 = (CheckBox) findViewById(R.id.ansbtn1);
                ans2 = (CheckBox) findViewById(R.id.ansbtn2);
                ans3 = (CheckBox) findViewById(R.id.ansbtn3);
                ans4 = (CheckBox) findViewById(R.id.ansbtn4);
                ans5 = (CheckBox) findViewById(R.id.ansbtn5);
                ans6 = (CheckBox) findViewById(R.id.ansbtn6);
                submitBtn = (Button) findViewById(R.id.submitBtn);

                String commandS = "SELECT * FROM tasks " + "WHERE themeID = '" + themeString + "'";
                Cursor cursorS = mDb.rawQuery(commandS, null);
                cursorS.moveToFirst();
                while (!cursorS.isAfterLast()) {
                    ArrayList<String> arrTmp = new ArrayList<>();
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("question")));
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("ans1")));
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("ans2")));
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("ans3")));
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("ans4")));
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("ans5")));
                    arrTmp.add(cursorS.getString(cursorS.getColumnIndex("ans6")));
                    arrQuiz.add(arrTmp);
                    cursorS.moveToNext();
                }
                showNextSilver();
                break;

            //GoldQuiz
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
        numQ.setText("Вопрос " + quizCount);

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
        numQ.setText("Вопрос " + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(arrQuiz.size());

        ArrayList<String> quiz = arrQuiz.get(randomNum);
        question.setText(quiz.get(0));

        rightAns.add(quiz.get(1));
        rightAns.add(quiz.get(2));

        quiz.remove(0);
        Collections.shuffle(quiz);

        ans1.setText(quiz.get(0));
        ans2.setText(quiz.get(1));
        ans3.setText(quiz.get(2));
        ans4.setText(quiz.get(3));
        ans5.setText(quiz.get(4));
        ans6.setText(quiz.get(5));

        Quiz.addAll(quiz);

        arrQuiz.remove(randomNum);
    }

    public void showNextGold(){
        numQ.setText("Вопрос " + quizCount);

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

    public void checkAnswerSilver(View view){

        Collections.sort(rightAns);
        Collections.sort(selection);

        String alert;
        if(selection.equals(rightAns)){
            alert = "Your right";
            rightAnswerCount++;
        }else{
            alert = "Your wrong";
        }

        Quiz.clear();
        selection.clear();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alert);
        builder.setMessage("Answer : " + rightAns);
        rightAns.clear();
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ans1.setChecked(false);
                ans2.setChecked(false);
                ans3.setChecked(false);
                ans4.setChecked(false);
                ans5.setChecked(false);
                ans6.setChecked(false);
                if(quizCount == QUIZ_COUNT){
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("RIGHT_ANSWER", rightAnswerCount);
                    startActivity(i);
                }else{
                    quizCount++;
                    showNextSilver();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }

    public  void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.ansbtn1:
                if(checked) {
                    selection.add(Quiz.get(0));
                }else{
                    selection.remove(Quiz.get(0));
                }
                break;
            case R.id.ansbtn2:
                if(checked) {
                    selection.add(Quiz.get(1));
                }else{
                    selection.remove(Quiz.get(1));
                }
                break;
            case R.id.ansbtn3:
                if(checked) {
                    selection.add(Quiz.get(2));
                }else{
                    selection.remove(Quiz.get(2));
                }
                break;
            case R.id.ansbtn4:
                if(checked) {
                    selection.add(Quiz.get(3));
                }else{
                    selection.remove(Quiz.get(3));
                }
                break;
            case R.id.ansbtn5:
                if(checked) {
                    selection.add(Quiz.get(4));
                }else{
                    selection.remove(Quiz.get(4));
                }
                break;
            case R.id.ansbtn6:
                if(checked) {
                    selection.add(Quiz.get(5));
                }else{
                    selection.remove(Quiz.get(5));
                }
                break;
        }
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
                if(quizCount == QUIZ_COUNT){
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
