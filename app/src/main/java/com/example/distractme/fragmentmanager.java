package com.example.distractme;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.distractme.ui.distractions.DistractionsFragment;

public class fragmentmanager extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new DistractionsFragment()).commit();
        }
    }
}
