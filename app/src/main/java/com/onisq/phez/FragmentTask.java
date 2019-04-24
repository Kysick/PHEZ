package com.onisq.phez;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTask  extends Fragment implements View.OnClickListener {

    View v;
    Button btnQuiz;
    private Fragment fragment;

    public FragmentTask() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_task, container, false);

        btnQuiz = (Button) v.findViewById(R.id.btnQuiz);

        btnQuiz.setOnClickListener(this);

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
            case R.id.btnQuiz:
                i = new Intent(getActivity(), QuizActivity.class);
                startActivity(i);
                break;
        }
    }
}
