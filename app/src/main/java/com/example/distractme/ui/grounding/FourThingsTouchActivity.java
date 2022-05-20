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

public class FourThingsTouchActivity extends AppCompatActivity {

    CheckBox cb_1st_touch, cb_2nd_touch, cb_3rd_touch, cb_4th_touch;
    EditText et_1st_touch, et_2nd_touch, et_3rd_touch, et_4th_touch;
    String first_touch, second_touch, third_touch, fourth_touch, fifth_touch;

    ArrayList<String> FourThingsTouch = new ArrayList<String>();
    ArrayList<String> FiveThingsSee = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_things_touch);

        FiveThingsSee = getIntent().getExtras().getStringArrayList("FiveThingsSee");

        cb_1st_touch = (CheckBox) findViewById(R.id.cb_1st_touch);
        cb_2nd_touch = (CheckBox) findViewById(R.id.cb_2nd_touch);
        cb_3rd_touch = (CheckBox) findViewById(R.id.cb_3rd_touch);
        cb_4th_touch = (CheckBox) findViewById(R.id.cb_4th_touch);

        et_1st_touch = (EditText) findViewById(R.id.et_1st_touch);
        et_2nd_touch = (EditText) findViewById(R.id.et_2nd_touch);
        et_3rd_touch = (EditText) findViewById(R.id.et_3rd_touch);
        et_4th_touch = (EditText) findViewById(R.id.et_4th_touch);

        et_1st_touch.addTextChangedListener(new TextWatcher() {

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
                if (et_1st_touch != null) {
                    cb_1st_touch.setChecked(true);
                }
            }

        });

        et_2nd_touch.addTextChangedListener(new TextWatcher() {

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
                if (et_2nd_touch != null) {
                    cb_2nd_touch.setChecked(true);
                }
            }

        });

        et_3rd_touch.addTextChangedListener(new TextWatcher() {

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
                if (et_3rd_touch != null) {
                    cb_3rd_touch.setChecked(true);
                }
            }

        });

        et_4th_touch.addTextChangedListener(new TextWatcher() {

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
                if (et_4th_touch != null) {
                    cb_4th_touch.setChecked(true);
                }
            }

        });

        cb_1st_touch.setClickable(false);
        cb_2nd_touch.setClickable(false);
        cb_3rd_touch.setClickable(false);
        cb_4th_touch.setClickable(false);
    }

    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(FourThingsTouchActivity.this, MainActivity.class);
//        String distractionsFragment = "FRAGMENT_DISTRACTIONS";
//        intent.putExtra("fragment", distractionsFragment);
        startActivity(intent);
    }

    public void next_page(View view) {
        if(cb_1st_touch.isChecked() == true && cb_2nd_touch.isChecked()== true && cb_3rd_touch.isChecked()== true && cb_4th_touch.isChecked()== true) {
            first_touch = et_1st_touch.getText().toString();
            second_touch = et_2nd_touch.getText().toString();
            third_touch = et_3rd_touch.getText().toString();
            fourth_touch = et_4th_touch.getText().toString();

            FourThingsTouch.add(first_touch);
            FourThingsTouch.add(second_touch);
            FourThingsTouch.add(third_touch);
            FourThingsTouch.add(fourth_touch);
            Intent intent = new Intent();
            intent.setClass(FourThingsTouchActivity.this, ThreeThingsHearActivity.class);
            intent.putStringArrayListExtra("FiveThingsSee", FiveThingsSee);
            intent.putStringArrayListExtra("FourThingsTouch", FourThingsTouch);
            startActivity(intent);
        }else if(cb_1st_touch.isChecked()== true && cb_2nd_touch.isChecked()== true && cb_3rd_touch.isChecked()== true) {
            Toast.makeText(this, "Think of 1 More Thing You Can Touch!", Toast.LENGTH_LONG).show();
        } else if(cb_1st_touch.isChecked()== true && cb_2nd_touch.isChecked()== true) {
            Toast.makeText(this, "Think of 2 More Things You Can Touch!", Toast.LENGTH_LONG).show();
        } else if(cb_1st_touch.isChecked()== true) {
            Toast.makeText(this, "Think of 3 More Things You Can Touch!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Think of 4 Things You Can Touch!", Toast.LENGTH_LONG).show();
        }
    }

    public void previous_page(View view) {
        Intent intent = new Intent();
        intent.setClass(FourThingsTouchActivity.this, FiveThingsSeeActivity.class);
        startActivity(intent);
    }
}
