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
import android.widget.Toast;

public class FragmentTask  extends Fragment implements View.OnClickListener {

    View v;
    private CardView
            quizKinematics1, quizKinematics2, quizKinematics3,
            quizDynamics1, quizDynamics2, quizDynamics3,
            quizLaws1,quizLaws2,quizLaws3,
            quizStatic1,quizStatic2,quizStatic3,
            quizVolatility1,quizVolatility2,quizVolatility3,
            quizMolecularPhysics1,quizMolecularPhysics2,quizMolecularPhysics3,
            quizTermoDynamics1,quizTermoDynamics2,quizTermoDynamics3,
            quizElectricity1,quizElectricity2,quizElectricity3,
            quizElectricCurrent1,quizElectricCurrent2,quizElectricCurrent3,
            quizMagnetic1,quizMagnetic2,quizMagnetic3,
            quizElectroMagnetic1,quizElectroMagnetic2,quizElectroMagnetic3;
    private Fragment fragment;

    public FragmentTask() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_task, container, false);
        SharedPref sharedPref;
        sharedPref = new SharedPref(getContext());
        if(sharedPref.loadNightModeState() == true){
            getActivity().setTheme(R.style.darkTheme);
        }
        else getActivity().setTheme(R.style.AppTheme);

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


        quizMolecularPhysics1 = (CardView) v.findViewById(R.id.QuizMolecularPhysics1);
        quizMolecularPhysics2 = (CardView) v.findViewById(R.id.QuizMolecularPhysics2);
        quizMolecularPhysics3 = (CardView) v.findViewById(R.id.QuizMolecularPhysics3);

        quizTermoDynamics1 = (CardView) v.findViewById(R.id.QuizTermoDynamics1);
        quizTermoDynamics2 = (CardView) v.findViewById(R.id.QuizTermoDynamics2);
        quizTermoDynamics3 = (CardView) v.findViewById(R.id.QuizTermoDynamics3);

        quizElectricity1 = (CardView) v.findViewById(R.id.QuizElectricity1);
        quizElectricity2 = (CardView) v.findViewById(R.id.QuizElectricity2);
        quizElectricity3 = (CardView) v.findViewById(R.id.QuizElectricity3);

        quizElectricCurrent1 = (CardView) v.findViewById(R.id.QuizElectricCurrent1);
        quizElectricCurrent2 = (CardView) v.findViewById(R.id.QuizElectricCurrent2);
        quizElectricCurrent3 = (CardView) v.findViewById(R.id.QuizElectricCurrent3);

        quizMagnetic1 = (CardView) v.findViewById(R.id.QuizMagnetic1);
        quizMagnetic2 = (CardView) v.findViewById(R.id.QuizMagnetic2);
        quizMagnetic3 = (CardView) v.findViewById(R.id.QuizMagnetic3);

        quizElectroMagnetic1 = (CardView) v.findViewById(R.id.QuizElectroMagnetic1);
        quizElectroMagnetic2 = (CardView) v.findViewById(R.id.QuizElectroMagnetic2);
        quizElectroMagnetic3 = (CardView) v.findViewById(R.id.QuizElectroMagnetic3);


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

        quizMolecularPhysics1.setOnClickListener(this);
        quizMolecularPhysics2.setOnClickListener(this);
        quizMolecularPhysics3.setOnClickListener(this);

        quizTermoDynamics1.setOnClickListener(this);
        quizTermoDynamics2.setOnClickListener(this);
        quizTermoDynamics3.setOnClickListener(this);

        quizElectricity1.setOnClickListener(this);
        quizElectricity2.setOnClickListener(this);
        quizElectricity3.setOnClickListener(this);

        quizElectricCurrent1.setOnClickListener(this);
        quizElectricCurrent2.setOnClickListener(this);
        quizElectricCurrent3.setOnClickListener(this);

        quizMagnetic1.setOnClickListener(this);
        quizMagnetic2.setOnClickListener(this);
        quizMagnetic3.setOnClickListener(this);

        quizElectroMagnetic1.setOnClickListener(this);
        quizElectroMagnetic2.setOnClickListener(this);
        quizElectroMagnetic3.setOnClickListener(this);

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

            /*case R.id.QuizLawsOfSaving1:
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

            case R.id.QuizMolecularPhysics1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "16");
                startActivity(i);
                break;
            case R.id.QuizMolecularPhysics2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "17");
                startActivity(i);
                break;
            case R.id.QuizMolecularPhysics3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "18");
                startActivity(i);
                break;

            case R.id.QuizTermoDynamics1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "19");
                startActivity(i);
                break;
            case R.id.QuizTermoDynamics2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "20");
                startActivity(i);
                break;
            case R.id.QuizTermoDynamics3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "21");
                startActivity(i);
                break;

            case R.id.QuizElectricity1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "22");
                startActivity(i);
                break;
            case R.id.QuizElectricity2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "23");
                startActivity(i);
                break;
            case R.id.QuizElectricity3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "24");
                startActivity(i);
                break;

            case R.id.QuizElectricCurrent1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "25");
                startActivity(i);
                break;
            case R.id.QuizElectricCurrent2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "26");
                startActivity(i);
                break;
            case R.id.QuizElectricCurrent3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "27");
                startActivity(i);
                break;

            case R.id.QuizMagnetic1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "28");
                startActivity(i);
                break;
            case R.id.QuizMagnetic2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "29");
                startActivity(i);
                break;
            case R.id.QuizMagnetic3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "30");
                startActivity(i);
                break;

            case R.id.QuizElectroMagnetic1:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "31");
                startActivity(i);
                break;
            case R.id.QuizElectroMagnetic2:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "32");
                startActivity(i);
                break;
            case R.id.QuizElectroMagnetic3:
                i = new Intent(getActivity(), QuizActivity.class);
                i.putExtra("THEME_TASK", "33");
                startActivity(i);
                break;*/
                default:
                    Toast.makeText(getContext(), "Work in progress", Toast.LENGTH_SHORT).show();
        }
    }
}
