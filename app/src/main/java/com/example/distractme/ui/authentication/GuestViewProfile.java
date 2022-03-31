package com.example.distractme.ui.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.R;
import com.example.distractme.ui.login.LoginActivity;

public class GuestViewProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_view_profile);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToRegister(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Register.class);
        startActivity(intent);
    }
}