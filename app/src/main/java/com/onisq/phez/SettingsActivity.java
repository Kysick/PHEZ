package com.onisq.phez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    private Switch mySwitch;
    SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightModeState() == true){
            setTheme(R.style.darkTheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mySwitch = (Switch)findViewById(R.id.myswitch);
        if(sharedPref.loadNightModeState() == true){
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sharedPref.setNightModeState(true);
                    recreate();
                }
                else{
                    sharedPref.setNightModeState(false);
                    recreate();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
