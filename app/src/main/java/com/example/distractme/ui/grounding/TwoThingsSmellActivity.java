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

public class TwoThingsSmellActivity extends AppCompatActivity {

    CheckBox cb_1st_smell, cb_2nd_smell;
    EditText et_1st_smell, et_2nd_smell;
    String first_smell, second_smell;

    ArrayList<String> TwoThingsSmell = new ArrayList<String>();
    ArrayList<String> ThreeThingsHear = new ArrayList<String>();
    ArrayList<String> FourThingsTouch = new ArrayList<String>();
    ArrayList<String> FiveThingsSee = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_things_smell);

        FiveThingsSee = getIntent().getExtras().getStringArrayList("FiveThingsSee");
        FourThingsTouch = getIntent().getExtras().getStringArrayList("FourThingsTouch");
        ThreeThingsHear = getIntent().getExtras().getStringArrayList("ThreeThingsHear");

        cb_1st_smell = (CheckBox) findViewById(R.id.cb_1st_smell);
        cb_2nd_smell = (CheckBox) findViewById(R.id.cb_2nd_smell);

        et_1st_smell = (EditText) findViewById(R.id.et_1st_smell);
        et_2nd_smell = (EditText) findViewById(R.id.et_2nd_smell);

        et_1st_smell.addTextChangedListener(new TextWatcher() {

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
                if (et_1st_smell != null) {
                    cb_1st_smell.setChecked(true);
                }
            }

        });

        et_2nd_smell.addTextChangedListener(new TextWatcher() {

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
                if (et_2nd_smell != null) {
                    cb_2nd_smell.setChecked(true);
                }
            }

        });
    }

    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(TwoThingsSmellActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void next_page(View view) {
        if(cb_1st_smell.isChecked() == true && cb_2nd_smell.isChecked()== true) {
            first_smell = et_1st_smell.getText().toString();
            second_smell = et_2nd_smell.getText().toString();

            TwoThingsSmell.add(first_smell);
            TwoThingsSmell.add(second_smell);
            Intent intent = new Intent();
            intent.setClass(TwoThingsSmellActivity.this, OneThingTasteActivity.class);
            intent.putStringArrayListExtra("TwoThingsSmell", TwoThingsSmell);
            intent.putStringArrayListExtra("ThreeThingsHear", ThreeThingsHear);
            intent.putStringArrayListExtra("FourThingsTouch", FourThingsTouch);
            intent.putStringArrayListExtra("FiveThingsSee", FiveThingsSee);
            startActivity(intent);
        }else if(cb_1st_smell.isChecked()== true) {
            Toast.makeText(this, "Think of 1 More Thing You Can Smell!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Think of 2 Things You Can Smell!", Toast.LENGTH_LONG).show();
        }
    }

    public void previous_page(View view) {
        Intent intent = new Intent();
        intent.setClass(TwoThingsSmellActivity.this, ThreeThingsHearActivity.class);
        startActivity(intent);
    }
}
