package com.example.distractme.ui.consent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConsentActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String currentUserID;
    FirebaseDatabase database;
    Boolean consent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent);

        database = FirebaseDatabase.getInstance("https://distractme-39056-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference().child("users");

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        if(mAuth != null) {
            currentUserID = user.getUid();
        } else{
            Log.e("User", "not found...");
        }
    }

    public void giveConsent(View view) {
        consent = true;
        mDatabase.child(currentUserID).child("CONSENT").setValue(true);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    public void doNotGiveConsent(View view) {
        consent = false;
        mDatabase.child(currentUserID).child("CONSENT").setValue(false);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

}