package com.example.distractme.ui.grounding;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;

import java.util.ArrayList;

public class OneThingTasteActivity extends AppCompatActivity {

    CheckBox cb_1st_taste;
    EditText et_1st_taste;
    String first_taste;

    ArrayList<String> TwoThingsSmell = new ArrayList<String>();
    ArrayList<String> ThreeThingsHear = new ArrayList<String>();
    ArrayList<String> FourThingsTouch = new ArrayList<String>();
    ArrayList<String> FiveThingsSee = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_thing_taste);

        FiveThingsSee = getIntent().getExtras().getStringArrayList("FiveThingsSee");
        FourThingsTouch = getIntent().getExtras().getStringArrayList("FourThingsTouch");
        ThreeThingsHear = getIntent().getExtras().getStringArrayList("ThreeThingsHear");
        TwoThingsSmell = getIntent().getExtras().getStringArrayList("TwoThingsSmell");

        cb_1st_taste = (CheckBox) findViewById(R.id.cb_1st_taste);

        et_1st_taste = (EditText) findViewById(R.id.et_1st_taste);

        et_1st_taste.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (et_1st_taste != null) {
                    cb_1st_taste.setChecked(true);
                }
            }

        });

        cb_1st_taste.setClickable(false);
    }

    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(OneThingTasteActivity.this, MainActivity.class);
//        String distractionsFragment = "FRAGMENT_DISTRACTIONS";
//        intent.putExtra("fragment", distractionsFragment);
        startActivity(intent);
    }

    public void next_page(View view) {
        if(cb_1st_taste.isChecked() == true) {
            first_taste = et_1st_taste.getText().toString();
            Intent intent = new Intent();
            intent.setClass(this, GroundingActivity.class);
            intent.putExtra("OneThingTaste", first_taste);
            intent.putStringArrayListExtra("TwoThingsSmell", TwoThingsSmell);
            intent.putStringArrayListExtra("ThreeThingsHear", ThreeThingsHear);
            intent.putStringArrayListExtra("FourThingsTouch", FourThingsTouch);
            intent.putStringArrayListExtra("FiveThingsSee", FiveThingsSee);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Think of 1 Thing You Can Taste!", Toast.LENGTH_LONG).show();
        }
    }

    public void previous_page(View view) {
        Intent intent = new Intent();
        intent.setClass(OneThingTasteActivity.this, TwoThingsSmellActivity.class);
        startActivity(intent);
    }
}
