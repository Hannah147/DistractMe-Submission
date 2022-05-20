package com.example.distractme.ui.tracker;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.distractme.R;
import com.example.distractme.ui.adapter.RecyclerViewAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TrackerFragment extends Fragment {

    private TrackerViewModel TrackerViewModel;
    Activity mTracker = this.getActivity();
    String currentMood;
    ArrayList<String> allMoodEvents = new ArrayList<>();
    ArrayList<Integer> allMoodsArray = new ArrayList<>();
    RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    Boolean moodClicked = false;
    ImageView ivMoodAdded;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String currentUserID;
    FirebaseDatabase database;

    private TrackerFragment trackerFragment;

    private ArrayList<String> userMoods = new ArrayList<String>();
    private DatabaseReference usersDatabase;
    MoodInfo moodInfo;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrackerViewModel =
                ViewModelProviders.of(this).get(TrackerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tracker, container, false);
        TextView tvQuestion = root.findViewById(R.id.tvQuestion);

        database = FirebaseDatabase.getInstance("https://distractme-39056-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference().child("users");

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        if(mAuth != null) {
            currentUserID = user.getUid();
        } else{
            Log.e("User", "not found...");
        }

        recyclerView = root.findViewById(R.id.rvMoods);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final RecyclerViewAdapter.MyClickListener mcl = new RecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        };

        usersDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        usersDatabase.child(currentUserID).child("TrackedMoods").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    boolean isInterested = (Boolean)postSnapshot.getValue();
                    if (isInterested){
                        userMoods.add(postSnapshot.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        List<String> moods = new ArrayList<>();
        DatabaseReference moodRef = mDatabase.child(currentUserID).child("TrackedMoods");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String mood = ds.getKey();
                    moods.add(mood);
                }
                Log.d("MoodLog", String.valueOf(moods));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        moodRef.addListenerForSingleValueEvent(eventListener);

        adapter = new RecyclerViewAdapter(getContext(), moods, ivMoodAdded, allMoodsArray, mcl);

        recyclerView.setAdapter(adapter);
        View rootRecycle = inflater.inflate(R.layout.recyclerview_row, container, false);

        ivMoodAdded = (ImageView) rootRecycle.findViewById(R.id.ivMoodAdded);
//                ivMoodAdded = (ImageView) rootRecycle.findViewById(R.id.ivMoodAdded);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Hello!");
        alertDialogBuilder.setCancelable(true);
        // set dialog message
        alertDialogBuilder
                .setMessage("How Are You Today?")
                .setCancelable(true)
                .setPositiveButton( "Good",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                        Toast.makeText(getActivity(), "That's Great News!", Toast.LENGTH_LONG).show();

                    }
                })
                .setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Not Great",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                        Toast.makeText(getActivity(), "Sorry to Hear That, Let us Help!", Toast.LENGTH_LONG).show();

                    }
                });



        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        ImageView ivUpsetFace = (ImageView) root.findViewById(R.id.ivUpsetFace);
        ImageView ivSadFace = (ImageView) root.findViewById(R.id.ivSadFace);
        ImageView ivNeutralFace = (ImageView) root.findViewById(R.id.ivNeutralFace);
        ImageView ivHappyFace = (ImageView) root.findViewById(R.id.ivHappyFace);
        ImageView ivExtremelyHappyFace = (ImageView) root.findViewById(R.id.ivExtremelyHappyFace);

        ColorMatrix BWmatrix = new ColorMatrix();
        BWmatrix.setSaturation(0);
        ColorMatrixColorFilter BWfilter = new ColorMatrixColorFilter(BWmatrix);

        ColorMatrix Colourmatrix = new ColorMatrix();
        Colourmatrix.setSaturation(1);
        ColorMatrixColorFilter Colourfilter = new ColorMatrixColorFilter(Colourmatrix);

        ivUpsetFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivUpsetFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Upset";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(1);
            }
        });

        ivSadFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivSadFace.setColorFilter(Colourfilter);

                ivUpsetFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Sad";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(2);
            }
        });

        ivNeutralFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivNeutralFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivUpsetFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Neutral";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(3);
            }
        });

        ivHappyFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivHappyFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivUpsetFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Happy";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(4);
            }
        });

        ivExtremelyHappyFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivExtremelyHappyFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivUpsetFace.setColorFilter(BWfilter);

                currentMood = "Extremely Happy";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(5);
            }
        });

        Button btnAddMoodEvent = (Button) root.findViewById(R.id.btnAddMoodEvent);
        EditText etMoodEvent = (EditText) root.findViewById(R.id.etMoodEvent);

        ImageButton btn_refresh = (ImageButton) root.findViewById(R.id.btnRefresh);

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                adapter.notifyDataSetChanged();
            }
        });
        btnAddMoodEvent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    currentUserID = user.getUid();
                }

                if(moodClicked == true && etMoodEvent.getText().toString() != null) {
                    adapter.notifyDataSetChanged();
                    String moodEvent = etMoodEvent.getText().toString();
                    Toast.makeText(getActivity(), "Check length: " + allMoodEvents.size(), Toast.LENGTH_LONG).show();
                    allMoodEvents.add(moodEvent);

                    mDatabase.child(currentUserID).child("TrackedMoods").child(moodEvent).setValue(currentMood);

                    moods.add(moodEvent);

                    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance("https://distractme-39056-default-rtdb.europe-west1.firebasedatabase.app/");
                    DatabaseReference db=firebaseDatabase.getReference().child("users").child(currentUserID);

                    String finalMoodEvent = moodEvent;
                    db.orderByChild("TrackedMoods").equalTo("Neutral").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){

                                Log.d("user exits","usere hai");
                                String value =dataSnapshot.child(finalMoodEvent).getValue().toString();

                                if(value.equals("Neutral") && value != null){
                                    Log.d("MoodFound",value);


                                }else{

                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) { }
                    });


                    adapter.notifyDataSetChanged();
                    moodClicked = false;
                    moodEvent = "";

                    ivExtremelyHappyFace.setColorFilter(Colourfilter);
                    ivSadFace.setColorFilter(Colourfilter);
                    ivNeutralFace.setColorFilter(Colourfilter);
                    ivHappyFace.setColorFilter(Colourfilter);
                    ivUpsetFace.setColorFilter(Colourfilter);
                    etMoodEvent.setText("");
                    tvQuestion.setText("");

                }else {
                    Toast.makeText(getActivity(), "Please Select Your Mood", Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


}