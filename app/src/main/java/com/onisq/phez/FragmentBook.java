package com.onisq.phez;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentBook   extends Fragment implements View.OnClickListener {

    View v;
    private CardView kinematicsCard, dynamicsCard, lawOfSavingCard,
            staticCard, volatilityCard, molecularPhysicsCard,termoDynamicsCard, electricityCard, electricCurrentCard,
            magneticCard, electroMagneticCard;
    private Fragment fragment;
    private  Bundle args;
    public FragmentBook() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_book, container, false);
        kinematicsCard =  (CardView) v.findViewById(R.id.kinematicsId);
        dynamicsCard =  (CardView)  v.findViewById(R.id.dynamicsId);
        lawOfSavingCard = (CardView) v.findViewById(R.id.lawOfSavingId);
        staticCard =  (CardView) v.findViewById(R.id.staticId);
        volatilityCard = (CardView) v.findViewById(R.id.volatilityId);
        molecularPhysicsCard =  (CardView)v.findViewById(R.id.molecularPhysicsId);
        termoDynamicsCard =  (CardView)v.findViewById(R.id.termoDynamicsId);
        electricityCard =  (CardView)v.findViewById(R.id.electricityId);
        electricCurrentCard = (CardView) v.findViewById(R.id.electricCurrentId);
        magneticCard =  (CardView)v.findViewById(R.id.magneticId);
        electroMagneticCard =  (CardView)v.findViewById(R.id.electroMagneticId);

        kinematicsCard.setOnClickListener(this);



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
            case R.id.kinematicsId :

                i = new Intent(getActivity(), ListActivity.class);
                i.putExtra("STRING_I_NEED", "themesKinematics");
                startActivity(i);
                break;






        }


    }
}
