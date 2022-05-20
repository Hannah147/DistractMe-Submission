package com.example.distractme.ui.oddoneout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.grounding.FourThingsTouchActivity;

public class FindTheDogActivity extends AppCompatActivity {

    ImageView odd_dog_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_dog);

        odd_dog_out = findViewById(R.id.iv_found_me);
    }

    public void success(View view) {
        final Dialog SuccessDialog = new Dialog(FindTheDogActivity.this);
        SuccessDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        SuccessDialog.setContentView(R.layout.customdialogdog);
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
                Intent intent = new Intent();
                intent.setClass(FindTheDogActivity.this, FindTheSkunkActivity.class);
                startActivity(intent);

            }
        });

        SuccessDialog.show();

    }

    public void return_to_distractions(View view) {
        Intent intent = new Intent();
        intent.setClass(FindTheDogActivity.this, MainActivity.class);
//        String distractionsFragment = "FRAGMENT_DISTRACTIONS";
//        intent.putExtra("fragment", distractionsFragment);
        startActivity(intent);

    }
}