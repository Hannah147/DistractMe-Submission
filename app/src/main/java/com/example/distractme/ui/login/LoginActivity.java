package com.example.distractme.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;

public class LoginActivity extends AppCompatActivity {

    public EditText etUserEmail, etUserPassword;
    String userEmail, userPassword, userConfirmedEmail, userConfirmedPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);

        // change when firebase is setup, just for testing purposes here
//        userConfirmedPassword = "Hannah123";
//        userConfirmedEmail = "hannah14@gmail.com";

        etUserEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (etUserEmail.toString() != null) {
                    userEmail = etUserEmail.getText().toString();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                }
        });

        etUserPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                if (etUserPassword.toString() != null) {
                    userPassword = etUserPassword.getText().toString();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });


    }

    public void login(View view) {
        userEmail = etUserEmail.getText().toString();
        userPassword = etUserPassword.getText().toString();

        if(userEmail == userConfirmedEmail && userPassword == userConfirmedPassword) {
            Toast.makeText(this, "Incorrect Email and Password Entered... Please Try Again.", Toast.LENGTH_LONG).show();
            userEmail = "";
            userPassword = "";
        } else if(userEmail == userConfirmedEmail && userPassword != userConfirmedPassword) {
            Toast.makeText(this, "Incorrect Password Entered... Please Try Again.", Toast.LENGTH_LONG).show();
            userEmail = "";
            userPassword = "";
        } else if(userEmail != userConfirmedEmail && userPassword == userConfirmedPassword) {
            Toast.makeText(this, "Email not Found... Please Try Again.", Toast.LENGTH_LONG).show();
            userEmail = "";
            userPassword = "";
        } else if (userEmail != userConfirmedEmail && userPassword != userConfirmedPassword) {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        }

        userConfirmedPassword = "Hannah123";
        userConfirmedEmail = "hannah14@gmail.com";
    }

    public void proceed(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Proceed as Guest");
        // set dialog message
        alertDialogBuilder
                .setMessage("Are You Sure You Want To Proceed as a Guest?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "Please Select a Different Method.", Toast.LENGTH_LONG).show();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
