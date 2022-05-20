package com.example.distractme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.distractme.ui.consent.ConsentActivity;
import com.example.distractme.ui.distractions.DistractionsFragment;
import com.example.distractme.ui.home.HomeFragment;
import com.example.distractme.ui.other_resources.OthersFragment;
import com.example.distractme.ui.tracker.TrackerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String currentUserID;
    FirebaseDatabase database;
    FirebaseFirestore mStore;
    StorageReference storageReference;
    private DatabaseReference usersDatabase;
    boolean consent;
    String consentcheck;
    String intentFragment;
    private OthersFragment others;
    Boolean resumed = false, switched = false;
    BottomNavigationView bottomNav;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        database = FirebaseDatabase.getInstance("https://distractme-39056-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference().child("users");
        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        if(mAuth != null) {
            currentUserID = user.getUid();
        } else{
            Log.e("User", "not found...");
        }
        usersDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        if(currentUserID != null){
            getConsent();
        }

        if(consent = false) {
            Intent intent = new Intent();
            intent.setClass(this, ConsentActivity.class);
            startActivity(intent);
        }


        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_home, R.id.navigation_others, R.id.navigation_distractions, R.id.navigation_tracker)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(navView, navController);

        Intent i = getIntent();
        String fragmentName = i.getStringExtra("fragment");
        String distractions = "FRAGMENT_DISTRACTIONS";
        Log.e("Test1", "Test1" + fragmentName);
        }

    public void getConsent() {

        usersDatabase.child(currentUserID).child("CONSENT").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    consent = (Boolean)postSnapshot.getValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public Boolean getSwitched(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Boolean switched = extras.getBoolean("switched");
            if(switched) {
                Fragment fragment = new DistractionsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment, "second");
                transaction.addToBackStack(null);
                transaction.commit();

                switched = false;
                }
        }

        return this.switched;
    }
}