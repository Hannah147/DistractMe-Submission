package com.example.distractme;

import android.Manifest;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.distractme.ui.consent.ConsentActivity;
import com.example.distractme.ui.consent.ConsentFragment;
import com.example.distractme.ui.distractions.DistractionsFragment;
import com.example.distractme.ui.home.HomeFragment;
import com.example.distractme.ui.other_resources.OthersFragment;
import com.example.distractme.ui.services.LocationMonitoringService;
import com.example.distractme.ui.youtube.YoutubeActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.NoRouteToHostException;

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

    private OthersFragment others;
    Boolean resumed = false, switched = false;
    BottomNavigationView bottomNav;

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
        Toast.makeText(getApplicationContext(), "check consent (outside): " + consentcheck, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "check user: " + currentUserID, Toast.LENGTH_LONG).show();
        if(currentUserID != null){
            getConsent();
            Toast.makeText(getApplicationContext(), "check consent (user): " + consent, Toast.LENGTH_LONG).show();
        } else {
//            consent = false;
            Toast.makeText(getApplicationContext(), "check consent (other): " + consent, Toast.LENGTH_LONG).show();
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