package com.example.distractme.ui.checkin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.emergencyhelplines.EmergencyHelplineActivity;
import com.google.android.gms.tasks.Continuation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.common.modeldownload.FirebaseModelManager;
import com.google.firebase.ml.custom.FirebaseCustomRemoteModel;

import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.text.nlclassifier.NLClassifier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;

public class MeasureEmotionActivity extends AppCompatActivity {
    private TextView resultTextView;
    private EditText inputEditText;
    private ExecutorService executorService;
    private ScrollView scrollView;
    private Button predictButton;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String currentUserID;
    FirebaseDatabase database;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    int counter = 0;

    float positiveResult;
    String moodResult, answerCheck;

    Boolean youtube, breathing, grounding, drawing, oddoneout, gosomewhere, emergency;
    Boolean switched = true;

    Button btn_checkin;

    List<String> dangerousWords = new ArrayList<String>();

    // TODO 5: Define a NLClassifier variable
    private NLClassifier textClassifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure_emotion);
        dangerousWords.add("suicide");
        dangerousWords.add("kill myself");
        dangerousWords.add("suicidal");

        btn_checkin = findViewById(R.id.predict_button);

        executorService = Executors.newSingleThreadExecutor();
        resultTextView = findViewById(R.id.result_text_view);
        inputEditText = findViewById(R.id.input_text);
        scrollView = findViewById(R.id.scroll_view);

        predictButton = findViewById(R.id.predict_button);
        predictButton.setOnClickListener(
                (View v) -> {
                    classify(inputEditText.getText().toString());
                    answerCheck = inputEditText.getText().toString();

                });

        // TODO 3: Call the method to download TFLite model
        downloadModel("sentiment_analysis");

        database = FirebaseDatabase.getInstance("https://distractme-39056-default-rtdb.europe-west1.firebasedatabase.app/");
        mDatabase = database.getReference().child("users");

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        if(mAuth != null) {
            currentUserID = user.getUid();
        } else{
            Log.e("User", "not found...");
        }

        getSupportFragmentManager().addOnBackStackChangedListener(new androidx.fragment.app.FragmentManager.OnBackStackChangedListener()
        {
            public void onBackStackChanged()
            {
                Bundle clickedData = getIntent().getExtras();
                if (clickedData != null)
                {
                    Boolean clickedback = clickedData.getBoolean("clickedback");
                }
                else if (clickedData == null)
                {
                    Toast.makeText(MeasureEmotionActivity.this, "Bundle is null", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /** Send input text to TextClassificationClient and get the classify messages. */
    private void classify(final String text) {
        executorService.execute(
                () -> {
                    // TODO 7: Run sentiment analysis on the input text
                    List<Category> results = textClassifier.classify(text);
                    counter++;
                    // TODO 8: Convert the result to a human-readable text
                    String textToShow = counter + ") " + text + "\n";
                    for (int i = 0; i < results.size(); i++) {
                        Category result = results.get(i);;
                        positiveResult = result.getScore();
                    }

                    mDatabase.child(currentUserID).child("WordAnalysis").child(text).setValue(true);


                    // Show classification result on screen
                    showResult(textToShow);
//                    Intent intent = new Intent();
//                    intent.setClass(this, TestActivity.class);
//                    intent.putExtra("text", resultsStr);
//                    startActivity(intent);

                });
    }

    /** Show classification result on the screen. */
    private void showResult(final String textToShow) {
        // Run on UI thread as we'll updating our app UI
        runOnUiThread(
                () -> {
                    // Append the result to the UI.
                    resultTextView.append(textToShow);

                    // Clear the input text.
                    inputEditText.getText().clear();

                    // Scroll to the bottom to show latest entry's classification result.
                    scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));

                    Boolean found = false;


                    for (int i = 0; i < dangerousWords.size(); i++) {

                        if (answerCheck.toLowerCase().contains(dangerousWords.get(i).toLowerCase())) {

                            found = true;

                        } else {

                            System.out.println("not found..!");

                        }
                    }
                    if(found){
                        emergency = true;

                        if(emergency) {
                            Toast.makeText(
                                    this,
                                    "DANGER",
                                    Toast.LENGTH_LONG)
                                    .show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent();
                                    intent.setClass(MeasureEmotionActivity.this, EmergencyHelplineActivity.class);
                                    intent.putExtra("emergency", emergency);
                                    startActivity(intent);

                                }
                            }, 4000);
                        }
                    } else {

                        if (positiveResult == 1) {
                            Toast.makeText(
                                    this,
                                    "I'm glad you're having such a good day!" + positiveResult,
                                    Toast.LENGTH_LONG)
                                    .show();
                            youtube = true;
                            breathing = false;
                            grounding = false;
                            drawing = true;
                            oddoneout = false;
                            gosomewhere = true;
                        } else if (positiveResult < 0.1) {
                            Toast.makeText(
                                    this,
                                    "I'm sorry you're having such a bad day. How can we help?" + positiveResult,
                                    Toast.LENGTH_LONG)
                                    .show();
                            youtube = true;
                            breathing = true;
                            grounding = true;
                            drawing = true;
                            oddoneout = true;
                            gosomewhere = true;

                        } else if (positiveResult < 0.4 && positiveResult > 0.1) {
                            Toast.makeText(
                                    this,
                                    "You seem to be having a difficult time. How can we help?" + positiveResult,
                                    Toast.LENGTH_LONG)
                                    .show();

                            youtube = false;
                            breathing = true;
                            grounding = true;
                            drawing = true;
                            oddoneout = true;
                            gosomewhere = true;
                        } else if (positiveResult > 0.4 && positiveResult < 0.6) {
                            Toast.makeText(
                                    this,
                                    "Your day seems to be going alright. How can we help?" + positiveResult,
                                    Toast.LENGTH_LONG)
                                    .show();
                            youtube = true;
                            breathing = true;
                            grounding = false;
                            drawing = true;
                            oddoneout = false;
                            gosomewhere = true;
                        } else if (positiveResult > 0.6 && positiveResult < 1) {
                            Toast.makeText(
                                    this,
                                    "You seem to be having a good day! How can we help?" + positiveResult,
                                    Toast.LENGTH_LONG)
                                    .show();
                            youtube = true;
                            breathing = false;
                            grounding = false;
                            drawing = true;
                            oddoneout = false;
                            gosomewhere = true;
                        }

                    }

                    goToDistractions();
                });
    }

    // TODO 2: Implement a method to download TFLite model from Firebase
    /** Download model from Firebase ML. */
    private synchronized void downloadModel(String modelName) {
        final FirebaseCustomRemoteModel remoteModel =
                new FirebaseCustomRemoteModel
                        .Builder(modelName)
                        .build();
        FirebaseModelDownloadConditions conditions =
                new FirebaseModelDownloadConditions.Builder()
                        .requireWifi()
                        .build();
        final FirebaseModelManager firebaseModelManager = FirebaseModelManager.getInstance();
        firebaseModelManager
                .download(remoteModel, conditions)
                .continueWithTask(task ->
                        firebaseModelManager.getLatestModelFile(remoteModel)
                )
                .continueWith(executorService, (Continuation<File, Void>) task -> {
                    // Initialize a text classifier instance with the model
                    File modelFile = task.getResult();

                    // TODO 6: Initialize a TextClassifier with the downloaded model
                    textClassifier = NLClassifier.createFromFile(modelFile);

                    // Enable predict button
                    predictButton.setEnabled(true);
                    return null;
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(
                            this,
                            "Model download failed, please check your connection.",
                            Toast.LENGTH_LONG)
                            .show();
                    predictButton.setEnabled(false);
                });
    }

    public void goToDistractions() {
//        Intent intent = new Intent(MeasureEmotionActivity.this, MainActivity.class);
//        intent.putExtra("switched", switched);
//        startActivity(intent);


        // ----------------------- code that did work -------------------------------
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MeasureDistractionFragment hello = new MeasureDistractionFragment();
        fragmentTransaction.add(R.id.fragment_container, hello, "Distraction");
        fragmentTransaction.commit();
        btn_checkin.setVisibility(View.INVISIBLE);

        // -------------------
        // ---- code that did work ------------------------------

//        Fragment fragment = MeasureDistractionFragment.newInstance();
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        transaction.replace(R.id.container_layout, fragment).commit();        btn_checkin.setVisibility(View.INVISIBLE);


        //                    HomeFragment fragment = new HomeFragment();
//                    Bundle bundle = new Bundle();
//                    bundle.putBoolean("switched", switched);
//                    fragment.setArguments(bundle);

//        MeasureDistractionFragment fragment = new MeasureDistractionFragment();
//        Bundle bundle = new Bundle();
//        bundle.putBoolean("youtube", youtube);
//        bundle.putBoolean("breathing", breathing);
//        bundle.putBoolean("grounding", grounding);
//        bundle.putBoolean("drawing", drawing);
//        bundle.putBoolean("oddoneout", oddoneout);
//        bundle.putBoolean("gosomewhere", gosomewhere);
//        fragment.setArguments(bundle);
    }

    public Boolean getYoutube() {
        return youtube;
    }

    public Boolean getBreathing() {
        return breathing;
    }

    public Boolean getGrounding() {
        return grounding;
    }

    public Boolean getDrawing() {
        return drawing;
    }

    public Boolean getOddoneout() {
        return oddoneout;
    }

    public Boolean getGoSomewhere() {
        return gosomewhere;
    }

    public void goHome(View view) {
        Intent intent = new Intent();
        intent.setClass(MeasureEmotionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
