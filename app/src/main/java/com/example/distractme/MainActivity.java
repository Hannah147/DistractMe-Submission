package com.example.distractme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.distractme.ui.distractions.DistractionsFragment;
import com.example.distractme.ui.other_resources.OthersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private OthersFragment others;
    Boolean resumed = false, switched = false;
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        switch (getIntent().getStringExtra("EXTRA")) {
//            case "openFragment":
//                getSupportFragmentManager().beginTransaction().replace(R.id.home, new DistractionsFragment()).commit();
//                getSupportActionBar().setTitle("Distractions");
//                break;
//        }

//        Intent i = getIntent();
//        String fragmentName = i.getStringExtra("fragment");
//        String distraction = "distractions";
//        Boolean switched = i.getExtras().getBoolean("switched");

//        Intent i = getIntent();
//        String data = i.getStringExtra("FromReservation");
//
//        if (data != null && data.contentEquals("1")) {
//
//            navView.setFragment(yourFragment);
//        }


//        if(switched == true) {
//            FragmentManager manager = getSupportFragmentManager();
//            manager.beginTransaction().replace(R.id.navigation_home, new DistractionsFragment()).commit();
//            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                    R.id.navigation_home, R.id.navigation_others, R.id.navigation_distractions, R.id.navigation_tracker)
//                    .build();
//            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//            NavigationUI.setupWithNavController(navView, navController);
//            getSupportFragmentManager().beginTransaction()
//                    .add(android.R.id.content, new DistractionsFragment()).commit();


//        } else {

        getSwitched();
//        Integer intentFragment = getIntent().getExtras().getInt("fragment_load");

//        if (intentFragment != null) {
//        } else {
//        switch (intentFragment) {
//            case 4:
//                others = new OthersFragment();
//                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, others).commit();
//                // Load corresponding fragment
//                break;
//        }
//        }
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_home, R.id.navigation_others, R.id.navigation_distractions, R.id.navigation_tracker)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(navView, navController);

//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment others = new OthersFragment();
        Intent i = getIntent();
        Integer fragment_name = i.getIntExtra("fragment_load", 1);
        Integer fragmentNo = 4;
        if(fragment_name != null && fragment_name.equals(fragmentNo)) {
            getSupportFragmentManager().beginTransaction().add(R.id.navigation_home, others).commit();
            Toast.makeText(
                    this,
                    "On resume working " + fragment_name.toString(),
                    Toast.LENGTH_LONG)
                    .show();

        }
//        Intent intent = getIntent();
//        if (intent != null && intent.hasExtra("fragment_load")) {
//            Integer fragmentNo = intent.getExtras().getInt("fragment_load");
//            if (fragmentNo == 4) {
//                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, others).commit();
//            }
//        } else {
//            Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();
//        }

    }

    public Boolean getSwitched(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Boolean switched = extras.getBoolean("switched");
//            Toast.makeText(
//                    this,
//                    "Definitely working " + switched.toString(),
//                    Toast.LENGTH_LONG)
//                    .show();

            //The key argument here must match that used in the other activity

            if(switched) {
//                Fragment distraction = new DistractionsFragment();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();
//                transaction.commit();

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