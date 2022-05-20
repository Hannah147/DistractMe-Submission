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

    ListView lv_5_things, lv_4_things, lv_3_things, lv_2_things, lv_1_thing;

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
