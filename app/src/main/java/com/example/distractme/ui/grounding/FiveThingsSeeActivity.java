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

public class FiveThingsSeeActivity extends AppCompatActivity {

    CheckBox cb_1st_see, cb_2nd_see, cb_3rd_see, cb_4th_see, cb_5th_see;
    EditText et_1st_see, et_2nd_see, et_3rd_see, et_4th_see, et_5th_see;
    String first_see, second_see, third_see, fourth_see, fifth_see;
    Boolean check_all = false;

    ArrayList<String> FiveThingsSee = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_things_see);

        cb_1st_see = (CheckBox) findViewById(R.id.cb_1st_see);
        cb_2nd_see = (CheckBox) findViewById(R.id.cb_2nd_see);
        cb_3rd_see = (CheckBox) findViewById(R.id.cb_3rd_see);
        cb_4th_see = (CheckBox) findViewById(R.id.cb_4th_see);
        cb_5th_see = (CheckBox) findViewById(R.id.cb_5th_see);

        et_1st_see = (EditText) findViewById(R.id.et_1st_see);
        et_2nd_see = (EditText) findViewById(R.id.et_2nd_see);
        et_3rd_see = (EditText) findViewById(R.id.et_3rd_see);
        et_4th_see = (EditText) findViewById(R.id.et_4th_see);
        et_5th_see = (EditText) findViewById(R.id.et_5th_see);


        et_1st_see.addTextChangedListener(new TextWatcher() {

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
                if (et_1st_see.toString() != null) {
                    cb_1st_see.setChecked(true);
                }
            }

        });

        et_2nd_see.addTextChangedListener(new TextWatcher() {

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
                if (et_2nd_see.toString() != null) {
                    cb_2nd_see.setChecked(true);
                }
            }

        });

        et_3rd_see.addTextChangedListener(new TextWatcher() {

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
                if (et_3rd_see.toString() != null) {
                    cb_3rd_see.setChecked(true);
                }
            }

        });

        et_4th_see.addTextChangedListener(new TextWatcher() {

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
                if (et_4th_see.toString() != null) {
                    cb_4th_see.setChecked(true);
                }
            }

        });

        et_5th_see.addTextChangedListener(new TextWatcher() {

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
                if (et_5th_see.toString() != null) {
                    cb_5th_see.setChecked(true);
                }
            }

        });

    }

    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(FiveThingsSeeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void check_if_checked() {
        if (cb_1st_see.isChecked() == true && cb_2nd_see.isChecked()== true && cb_3rd_see.isChecked()== true && cb_4th_see.isChecked()== true && cb_5th_see.isChecked()== true) {
            check_all = true;
        } else if(cb_1st_see.isChecked()== true && cb_2nd_see.isChecked()== true && cb_3rd_see.isChecked()== true && cb_4th_see.isChecked()== true) {
            Toast.makeText(this, "Think of 1 More Thing You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else if(cb_1st_see.isChecked()== true && cb_2nd_see.isChecked()== true && cb_3rd_see.isChecked()== true) {
            Toast.makeText(this, "Think of 2 More Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else if(cb_1st_see.isChecked()== true && cb_2nd_see.isChecked()== true) {
            Toast.makeText(this, "Think of 3 More Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else if(cb_1st_see.isChecked()== true) {
            Toast.makeText(this, "Think of 4 More Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else {
            Toast.makeText(this, "Think of 5 Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        }
    }

    public void next_page(View view) {
        if(cb_1st_see.isChecked() == true && cb_2nd_see.isChecked()== true && cb_3rd_see.isChecked()== true && cb_4th_see.isChecked()== true && cb_5th_see.isChecked()== true) {
            first_see = et_1st_see.getText().toString();
            second_see = et_2nd_see.getText().toString();
            third_see = et_3rd_see.getText().toString();
            fourth_see = et_4th_see.getText().toString();
            fifth_see = et_5th_see.getText().toString();
            FiveThingsSee.add(first_see);
            FiveThingsSee.add(second_see);
            FiveThingsSee.add(third_see);
            FiveThingsSee.add(fourth_see);
            FiveThingsSee.add(fifth_see);
//        TextView tv_revise;
//        tv_revise = findViewById(R.id.tv_revise);
//        tv_revise.setText(first_see);
            Intent intentFourThings = new Intent();
            intentFourThings.setClass(FiveThingsSeeActivity.this, FourThingsTouchActivity.class);
//        Intent reviseFive = new Intent(this, GroundingActivity.class);
            intentFourThings.putStringArrayListExtra("FiveThingsSee", FiveThingsSee);
            startActivity(intentFourThings);
        }else if(cb_1st_see.isChecked()== true && cb_2nd_see.isChecked()== true && cb_3rd_see.isChecked()== true && cb_4th_see.isChecked()== true) {
            Toast.makeText(this, "Think of 1 More Thing You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else if(cb_1st_see.isChecked()== true && cb_2nd_see.isChecked()== true && cb_3rd_see.isChecked()== true) {
            Toast.makeText(this, "Think of 2 More Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else if(cb_1st_see.isChecked()== true && cb_2nd_see.isChecked()== true) {
            Toast.makeText(this, "Think of 3 More Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else if(cb_1st_see.isChecked()== true) {
            Toast.makeText(this, "Think of 4 More Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        } else {
            Toast.makeText(this, "Think of 5 Things You Can See!", Toast.LENGTH_LONG).show();
            check_all = false;
        }
    }
}
