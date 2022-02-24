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

public class ThreeThingsHearActivity extends AppCompatActivity {

    CheckBox cb_1st_hear, cb_2nd_hear, cb_3rd_hear;
    EditText et_1st_hear, et_2nd_hear, et_3rd_hear;
    String first_hear, second_hear, third_hear;

    ArrayList<String> ThreeThingsHear = new ArrayList<String>();
    ArrayList<String> FourThingsTouch = new ArrayList<String>();
    ArrayList<String> FiveThingsSee = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_things_hear);

        FiveThingsSee = getIntent().getExtras().getStringArrayList("FiveThingsSee");
        FourThingsTouch = getIntent().getExtras().getStringArrayList("FourThingsTouch");

        cb_1st_hear = (CheckBox) findViewById(R.id.cb_1st_hear);
        cb_2nd_hear = (CheckBox) findViewById(R.id.cb_2nd_hear);
        cb_3rd_hear = (CheckBox) findViewById(R.id.cb_3rd_hear);

        et_1st_hear = (EditText) findViewById(R.id.et_1st_hear);
        et_2nd_hear = (EditText) findViewById(R.id.et_2nd_hear);
        et_3rd_hear = (EditText) findViewById(R.id.et_3rd_hear);

        et_1st_hear.addTextChangedListener(new TextWatcher() {

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
                if (et_1st_hear != null) {
                    cb_1st_hear.setChecked(true);
                }
            }

        });

        et_2nd_hear.addTextChangedListener(new TextWatcher() {

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
                if (et_2nd_hear != null) {
                    cb_2nd_hear.setChecked(true);
                }
            }

        });

        et_3rd_hear.addTextChangedListener(new TextWatcher() {

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
                if (et_3rd_hear != null) {
                    cb_3rd_hear.setChecked(true);
                }
            }

        });

        cb_1st_hear.setClickable(false);
        cb_2nd_hear.setClickable(false);
        cb_3rd_hear.setClickable(false);
    }

    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(ThreeThingsHearActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void next_page(View view) {
        if(cb_1st_hear.isChecked() == true && cb_2nd_hear.isChecked()== true && cb_3rd_hear.isChecked()== true) {
            first_hear = et_1st_hear.getText().toString();
            second_hear = et_2nd_hear.getText().toString();
            third_hear = et_3rd_hear.getText().toString();

            ThreeThingsHear.add(first_hear);
            ThreeThingsHear.add(second_hear);
            ThreeThingsHear.add(third_hear);
            Intent intent = new Intent();
            intent.setClass(ThreeThingsHearActivity.this, TwoThingsSmellActivity.class);
            intent.putStringArrayListExtra("ThreeThingsHear", ThreeThingsHear);
            intent.putStringArrayListExtra("FourThingsTouch", FourThingsTouch);
            intent.putStringArrayListExtra("FiveThingsSee", FiveThingsSee);
            startActivity(intent);
        }else if(cb_1st_hear.isChecked()== true && cb_2nd_hear.isChecked()== true) {
            Toast.makeText(this, "Think of 1 More Thing You Can Hear!", Toast.LENGTH_LONG).show();
        } else if(cb_1st_hear.isChecked()== true) {
            Toast.makeText(this, "Think of 2 More Things You Can Hear!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Think of 3 Things You Can Hear!", Toast.LENGTH_LONG).show();
        }
    }

    public void previous_page(View view) {
        Intent intent = new Intent();
        intent.setClass(ThreeThingsHearActivity.this, FourThingsTouchActivity.class);
        startActivity(intent);
    }
}
