package com.example.distractme.ui.grounding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;

import java.util.ArrayList;
import java.util.Collections;

public class GroundingActivity extends AppCompatActivity {

//    TextView tv_5_things, tv_4_things, tv_3_things, tv_2_things, tv_1_thing;

    ListView lv_5_things, lv_4_things, lv_3_things, lv_2_things, lv_1_thing;
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

        lv_5_things = findViewById(R.id.lv_5_things);
        lv_4_things = findViewById(R.id.lv_4_things);
        lv_3_things = findViewById(R.id.lv_3_things);
        lv_2_things = findViewById(R.id.lv_2_things);
        lv_1_thing = findViewById(R.id.lv_1_thing);

//        tv_5_things = findViewById(R.id.tv_5_things);
//        tv_4_things = findViewById(R.id.tv_4_things);
//        tv_3_things = findViewById(R.id.tv_3_things);
//        tv_2_things = findViewById(R.id.tv_2_things);
//        tv_1_thing = findViewById(R.id.tv_1_thing);


//        tv_5_things.setText(FiveThingsSee.get(0) + ", " + FiveThingsSee.get(1) + ", " + FiveThingsSee.get(2) + ", " + FiveThingsSee.get(3) + ", " +FiveThingsSee.get(4));
//        tv_4_things.setText(FourThingsTouch.get(0) + ", " +FourThingsTouch.get(1) + ", " + FourThingsTouch.get(2) + ", " +FourThingsTouch.get(3));
//        tv_3_things.setText(ThreeThingsHear.get(0) + ", " +ThreeThingsHear.get(1) + ", " + ThreeThingsHear.get(2));
//        tv_2_things.setText(TwoThingsSmell.get(0) + ", " + TwoThingsSmell.get(1));
//        tv_1_thing.setText(OneThingTaste);

        ArrayAdapter<String> arrayAdapter5Things = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_listview, FiveThingsSee);
        lv_5_things.setAdapter(arrayAdapter5Things);

        ArrayList<String> finalFiveThingsSee = FiveThingsSee;
        lv_5_things.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = finalFiveThingsSee.get(position);
                Toast.makeText(getApplicationContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> arrayAdapter4Things = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_listview, FourThingsTouch);
        lv_4_things.setAdapter(arrayAdapter4Things);

        ArrayList<String> finalFourThingsTouch = FourThingsTouch;
        lv_4_things.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = finalFourThingsTouch.get(position);
                Toast.makeText(getApplicationContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> arrayAdapter3Things = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_listview, ThreeThingsHear);
        lv_3_things.setAdapter(arrayAdapter3Things);

        ArrayList<String> finalThreeThingsHear = ThreeThingsHear;
        lv_3_things.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = finalThreeThingsHear.get(position);
                Toast.makeText(getApplicationContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> arrayAdapter2Things = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_listview, TwoThingsSmell);
        lv_2_things.setAdapter(arrayAdapter2Things);

        ArrayList<String> finalTwoThingsSmell = TwoThingsSmell;
        lv_2_things.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = finalTwoThingsSmell.get(position);
                Toast.makeText(getApplicationContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> arrayAdapter1Thing = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_listview, Collections.singletonList(OneThingTaste));
        lv_1_thing.setAdapter(arrayAdapter1Thing);

        String finalOneThingTaste = OneThingTaste;
        lv_1_thing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = finalOneThingTaste;
                Toast.makeText(getApplicationContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
            }
        });
    }


    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(GroundingActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
