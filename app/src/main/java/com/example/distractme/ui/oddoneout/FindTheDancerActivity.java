package com.example.distractme.ui.oddoneout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.R;

public class FindTheDancerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_dancer);
    }

    public void success(View view) {
        final Dialog SuccessDialog = new Dialog(FindTheDancerActivity.this);
        SuccessDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        SuccessDialog.setContentView(R.layout.customdialogdancer);
        SuccessDialog.setTitle("Success Dialog");

        Button close = (Button)SuccessDialog.findViewById(R.id.close);
        Button next = (Button)SuccessDialog.findViewById(R.id.next);

        close.setEnabled(true);
        next.setEnabled(true);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuccessDialog.cancel();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked next!", Toast.LENGTH_LONG).show();
            }
        });

        SuccessDialog.show();

    }
}