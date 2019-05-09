package com.onisq.phez;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTask  extends Fragment implements View.OnClickListener {

    View v;
    Button btnQuiz;
    private CardView quizKinematics1, quizKinematics2, quizKinematics3, quizDynamics1, quizDynamics2,
    quizDynamics3, quizLaws1,quizLaws2,quizLaws3,quizStatic1,quizStatic2,quizStatic3,
            quizVolatility1,quizVolatility2,quizVolatility3;



    private Fragment fragment;

    public FragmentTask() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_task, container, false);




        //Setting cards
        quizKinematics1 = (CardView) v.findViewById(R.id.QuizKinematics1);
        quizKinematics2 = (CardView) v.findViewById(R.id.QuizKinematics2);
        quizKinematics3 = (CardView) v.findViewById(R.id.QuizKinematics3);

        quizDynamics1 = (CardView) v.findViewById(R.id.QuizDynamics1);
        quizDynamics2 = (CardView) v.findViewById(R.id.QuizDynamics2);
        quizDynamics3 = (CardView) v.findViewById(R.id.QuizDynamics3);

        quizLaws1 = (CardView) v.findViewById(R.id.QuizLawsOfSaving1);
        quizLaws2 = (CardView) v.findViewById(R.id.QuizLawsOfSaving2);
        quizLaws3 = (CardView) v.findViewById(R.id.QuizLawsOfSaving3);

        quizStatic1 = (CardView) v.findViewById(R.id.QuizStatic1);
        quizStatic2 = (CardView) v.findViewById(R.id.QuizStatic2);
        quizStatic3 = (CardView) v.findViewById(R.id.QuizStatic3);

        quizVolatility1 = (CardView) v.findViewById(R.id.QuizVolatility1);
        quizVolatility2 = (CardView) v.findViewById(R.id.QuizVolatility2);
        quizVolatility3 = (CardView) v.findViewById(R.id.QuizVolatility3);



        //OnclickListener for each card
        quizKinematics1.setOnClickListener(this);
        quizKinematics2.setOnClickListener(this);
        quizKinematics3.setOnClickListener(this);

        quizDynamics1.setOnClickListener(this);
        quizDynamics2.setOnClickListener(this);
        quizDynamics3.setOnClickListener(this);

        quizLaws1.setOnClickListener(this);
        quizLaws2.setOnClickListener(this);
        quizLaws3.setOnClickListener(this);

        quizStatic1.setOnClickListener(this);
        quizStatic2.setOnClickListener(this);
        quizStatic3.setOnClickListener(this);

        quizVolatility1.setOnClickListener(this);
        quizVolatility2.setOnClickListener(this);
        quizVolatility3.setOnClickListener(this);


        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.QuizKinematics1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "1");
                startActivity(i);
                break;
            case R.id.QuizKinematics2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "2");
                startActivity(i);
                break;
            case R.id.QuizKinematics3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "3");
                startActivity(i);
                break;
            case R.id.QuizDynamics1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "4");
                startActivity(i);
                break;
            case R.id.QuizDynamics2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "5");
                startActivity(i);
                break;

            case R.id.QuizDynamics3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "6");
                startActivity(i);
                break;
            case R.id.QuizLawsOfSaving1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "7");
                startActivity(i);
                break;
            case R.id.QuizLawsOfSaving2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "8");
                startActivity(i);
                break;
            case R.id.QuizLawsOfSaving3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "9");
                startActivity(i);
                break;
            case R.id.QuizStatic1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "10");
                startActivity(i);
                break;
            case R.id.QuizStatic2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "11");
                startActivity(i);
                break;
            case R.id.QuizStatic3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "12");
                startActivity(i);
                break;
            case R.id.QuizVolatility1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "13");
                startActivity(i);
                break;
            case R.id.QuizVolatility2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "14");
                startActivity(i);
                break;
            case R.id.QuizVolatility3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "15");
                startActivity(i);
                break;
                default:
        }
    }
}
