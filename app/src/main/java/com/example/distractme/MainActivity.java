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

//public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
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

    Fragment fragmentOthers;
    Fragment fragmentTracker;
    Fragment fragmentDistraction;
    Fragment fragmentHome;

    FragmentTransaction clearTransaction = getSupportFragmentManager().beginTransaction();

//    private LocationManager locationMangaer = null;
//    private LocationListener locationListener = null;

//    private Button btnGetLocation = null;
//    private EditText editLocation = null;
//    private ProgressBar pb = null;

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

//        fragmentHome = new HomeFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentHome).commit();
//
//        fragmentDistraction = new DistractionsFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentDistraction).commit();
//
//        fragmentTracker = new TrackerFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentTracker).commit();
//
//        fragmentOthers = new OthersFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentOthers).commit();

//        mDatabase.child(currentUserID).child("CONSENT").setValue(false);


//        consent = false;

//        DatabaseReference checkConsent = usersDatabase.child(currentUserID);
//
//        String consentstr = checkConsent.child("CONSENT").va();
//        checkConsent.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Boolean consentcheck = (Boolean) dataSnapshot.getValue();
//                if(consentcheck == true) {
//                    consent = true;
//                } else if(consentcheck == false) {
//                    consent = false;
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("users").child(currentUserID);
//        ref.addListenerForSingleValueEvent(new ValueEventListener(){
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                consentcheck=dataSnapshot.child("CONSENT").getValue().toString();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//        getConsent();
//        Toast.makeText(getApplicationContext(), "check consent (outside): " + consentcheck, Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(), "check user: " + currentUserID, Toast.LENGTH_LONG).show();
        if(currentUserID != null){
            getConsent();
//            Toast.makeText(getApplicationContext(), "check consent (user): " + consent, Toast.LENGTH_LONG).show();
        } else {
//            consent = false;
//            Toast.makeText(getApplicationContext(), "check consent (other): " + consent, Toast.LENGTH_LONG).show();
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

//        navView.setOnNavigationItemSelectedListener(this);
//        navView.bringToFront();

        Intent i = getIntent();
        String fragmentName = i.getStringExtra("fragment");
        String distractions = "FRAGMENT_DISTRACTIONS";
        Log.e("Test1", "Test1" + fragmentName);
//        if(fragmentName != null && fragmentName.equals(distractions)){
//            Fragment fragmentDistraction = new DistractionsFragment();
//            FragmentTransaction transactionDistraction = getSupportFragmentManager().beginTransaction();
//            transactionDistraction.add(R.id.container, fragmentDistraction, "second");
//            transactionDistraction.commit();
//        }

//        if(fragmentName != null) {
//            switch(fragmentName){
//                case "FRAGMENT_HOME":
//                    FragmentTransaction transactionHome = getSupportFragmentManager().beginTransaction();
//                    transactionHome.replace(R.id.container, fragmentHome, "home");
//                    navView.setSelectedItemId(R.id.navigation_home);
//                    transactionHome.addToBackStack(null);
//                    transactionHome.hide(fragmentTracker);
//                    transactionHome.hide(fragmentDistraction);
//                    transactionHome.hide(fragmentOthers);
//                    transactionHome.commit();
//                    break;
//                case "FRAGMENT_DISTRACTIONS":
//                    FragmentTransaction transactionDistraction = getSupportFragmentManager().beginTransaction();
//                    transactionDistraction.replace(R.id.container, fragmentDistraction, "distraction");
//                    navView.setSelectedItemId(R.id.navigation_distractions);
//                    transactionDistraction.addToBackStack(null);
//                    transactionDistraction.hide(fragmentTracker);
//                    transactionDistraction.hide(fragmentHome);
//                    transactionDistraction.hide(fragmentOthers);
//                    transactionDistraction.commit();
//                    break;
//                case "FRAGMENT_TRACKER":
//                    FragmentTransaction transactionTracker = getSupportFragmentManager().beginTransaction();
//                    transactionTracker.replace(R.id.container, fragmentTracker, "tracker");
//                    navView.setSelectedItemId(R.id.navigation_tracker);
//                    transactionTracker.addToBackStack(null);
//                    transactionTracker.hide(fragmentDistraction);
//                    transactionTracker.hide(fragmentHome);
//                    transactionTracker.hide(fragmentOthers);
//                    transactionTracker.commit();
//                    break;
//                case "FRAGMENT_OTHERS":
//                    FragmentTransaction transactionOthers = getSupportFragmentManager().beginTransaction();
//                    transactionOthers.replace(R.id.container, fragmentOthers, "others");
//                    navView.setSelectedItemId(R.id.navigation_others);
//                    transactionOthers.hide(fragmentDistraction);
//                    transactionOthers.hide(fragmentHome);
//                    transactionOthers.hide(fragmentTracker);
//                    transactionOthers.addToBackStack(null);
//                    transactionOthers.commit();
//                    break;
//            }
        }

//        clearTransaction.detach(fragmentOthers);
//        clearTransaction.detach(fragmentTracker);
//        clearTransaction.detach(fragmentDistraction);


//        clearTransaction.detach(fragmentHome);



//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId())
//        {
//            case R.id.navigation_home:
////                FragmentTransaction transactionHome = getSupportFragmentManager().beginTransaction();
////                transactionHome.add(R.id.container, fragmentHome, "home");
////                clearTransaction.remove(fragmentOthers);
////                clearTransaction.remove(fragmentTracker);
////                clearTransaction.remove(fragmentDistraction);
////                transactionHome.commit();
//                getSupportFragmentManager().beginTransaction().show(fragmentHome).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentDistraction).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentTracker).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentOthers).commit();
//                Toast.makeText(this, "Home clicked", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.navigation_distractions:
////                FragmentTransaction transactionDistraction = getSupportFragmentManager().beginTransaction();
////                transactionDistraction.add(R.id.container, fragmentDistraction, "distraction");
////                clearTransaction.remove(fragmentOthers);
////                clearTransaction.remove(fragmentTracker);
////                clearTransaction.remove(fragmentHome);
////                transactionDistraction.commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentHome).commit();
//                getSupportFragmentManager().beginTransaction().show(fragmentDistraction).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentTracker).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentOthers).commit();
//                Toast.makeText(this, "distractions clicked", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.navigation_tracker:
////                FragmentTransaction transactionTracker = getSupportFragmentManager().beginTransaction();
////                transactionTracker.add(R.id.container, fragmentTracker, "tracker");
////                clearTransaction.remove(fragmentOthers);
////                clearTransaction.remove(fragmentHome);
////                clearTransaction.remove(fragmentDistraction);
//                Toast.makeText(this, "tracker clicked", Toast.LENGTH_LONG).show();
////                transactionTracker.commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentHome).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentDistraction).commit();
//                getSupportFragmentManager().beginTransaction().show(fragmentTracker).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentOthers).commit();
//
//                break;
//            case R.id.navigation_others:
////                FragmentTransaction transactionOthers = getSupportFragmentManager().beginTransaction();
////                transactionOthers.add(R.id.container, fragmentOthers, "others");
////                clearTransaction.remove(fragmentHome);
////                clearTransaction.remove(fragmentTracker);
////                clearTransaction.remove(fragmentDistraction);
////                transactionOthers.commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentHome).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentDistraction).commit();
//                getSupportFragmentManager().beginTransaction().hide(fragmentTracker).commit();
//                getSupportFragmentManager().beginTransaction().show(fragmentOthers).commit();
//                Toast.makeText(this, "others clicked", Toast.LENGTH_LONG).show();
//                break;
//        }
//        return true;
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if(counter > 1){
//            Intent i = getIntent();
//            String fragmentName = i.getStringExtra("fragment");
//            String distractions = "FRAGMENT_DISTRACTIONS";
//            Log.e("Test1", "Test1" + fragmentName);
//            if(fragmentName != null && fragmentName.equals(distractions)){
//                Fragment fragmentDistraction = new DistractionsFragment();
//                FragmentTransaction transactionDistraction = getSupportFragmentManager().beginTransaction();
//                transactionDistraction.add(R.id.container, fragmentDistraction, "second");
//                transactionDistraction.commit();
//            }
//            intentFragment = getIntent().getExtras().getString("frgToLoad");
//            switch(intentFragment){
//                case "FRAGMENT_HOME":
//                    Fragment fragmentHome = new HomeFragment();
//                    FragmentTransaction transactionHome = getSupportFragmentManager().beginTransaction();
//                    transactionHome.add(R.id.container, fragmentHome, "second");
//                    transactionHome.commit();
//                    break;
//                case "FRAGMENT_DISTRACTIONS":
//                    Fragment fragmentDistraction = new DistractionsFragment();
//                    FragmentTransaction transactionDistraction = getSupportFragmentManager().beginTransaction();
//                    transactionDistraction.add(R.id.container, fragmentDistraction, "second");
//                    transactionDistraction.commit();
//                    break;
//                case "FRAGMENT_TRACKER":
//                    Fragment fragmentTracker = new TrackerFragment();
//                    FragmentTransaction transactionTracker = getSupportFragmentManager().beginTransaction();
//                    transactionTracker.add(R.id.container, fragmentTracker, "second");
//                    transactionTracker.commit();
//                    break;
//                case "FRAGMENT_OTHERS":
//                    Fragment fragmentOther = new TrackerFragment();
//                    FragmentTransaction transactionOther = getSupportFragmentManager().beginTransaction();
//                    transactionOther.add(R.id.container, fragmentOther, "second");
//                    transactionOther.commit();
//                    break;
//            }
//        }
//
//        counter++;
//        Toast.makeText(getApplicationContext(), "check counter: " + counter, Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(), "check fragment: " + intentFragment, Toast.LENGTH_LONG).show();    }


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
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference orderRef = rootRef.child("users").child(currentUserID).child("CONSENT");
//        orderRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (DataSnapshot ds : task.getResult().getChildren()) {
//                        String key = ds.getKey();
//                        String value = ds.getValue(String.class);
//                        Log.d("TAG", key + ":" + value);
//                    }
//                } else {
//                    Log.d("TAG", task.getException().getMessage()); //Don't ignore potential errors!
//                }
//
//            }
//        });
//        usersDatabase.child(currentUserID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                consent = dataSnapshot.getValue();
//                //do what you want with the email
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        mDatabase.child(currentUserID).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                consent = (Boolean) snapshot.child("CONSENT").getValue(consent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                throw error.toException(); // never ignore errors
//            }
//        });
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