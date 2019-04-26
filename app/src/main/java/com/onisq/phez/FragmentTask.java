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
    private CardView quizKinematics1, quizKinematics2, quizKinematics3;
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



        //OnclickListener for each card
        quizKinematics1.setOnClickListener(this);
        quizKinematics2.setOnClickListener(this);
        quizKinematics3.setOnClickListener(this);



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
        }
    }
}
