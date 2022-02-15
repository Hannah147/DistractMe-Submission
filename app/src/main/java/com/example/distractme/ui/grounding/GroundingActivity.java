package com.example.distractme.ui.grounding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.R;

import java.util.ArrayList;

public class GroundingActivity extends AppCompatActivity {

    TextView tv_5_things, tv_4_things, tv_3_things, tv_2_things, tv_1_thing;

//    Intent i1, i2, i3, i4, i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grounding);

        Intent i = getIntent();

        ArrayList<String> FiveThingsSee = new ArrayList<String>();
        ArrayList<String> FourThingsTouch = new ArrayList<String>();
        ArrayList<String> ThreeThingsHear = new ArrayList<String>();
        ArrayList<String> TwoThingsSmell = new ArrayList<String>();
        String OneThingTaste;

        FiveThingsSee = i.getExtras().getStringArrayList("FiveThingsSee");
        FourThingsTouch = i.getExtras().getStringArrayList("FourThingsTouch");
        ThreeThingsHear = i.getExtras().getStringArrayList("ThreeThingsHear");
        TwoThingsSmell = i.getExtras().getStringArrayList("TwoThingsSmell");
        OneThingTaste = i.getExtras().getString("OneThingTaste");

        tv_5_things = findViewById(R.id.tv_5_things);
        tv_4_things = findViewById(R.id.tv_4_things);
        tv_3_things = findViewById(R.id.tv_3_things);
        tv_2_things = findViewById(R.id.tv_2_things);
        tv_1_thing = findViewById(R.id.tv_1_thing);


        tv_5_things.setText(FiveThingsSee.get(0) + ", " + FiveThingsSee.get(1) + ", " + FiveThingsSee.get(2) + ", " + FiveThingsSee.get(3) + ", " +FiveThingsSee.get(4));
        tv_4_things.setText(FourThingsTouch.get(0) + ", " +FourThingsTouch.get(1) + ", " + FourThingsTouch.get(2) + ", " +FourThingsTouch.get(3));
        tv_3_things.setText(ThreeThingsHear.get(0) + ", " +ThreeThingsHear.get(1) + ", " + ThreeThingsHear.get(2));
        tv_2_things.setText(TwoThingsSmell.get(0) + ", " + TwoThingsSmell.get(1));
        tv_1_thing.setText(OneThingTaste);

    }



}
