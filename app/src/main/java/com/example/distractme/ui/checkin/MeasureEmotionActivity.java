package com.example.distractme.ui.checkin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.R;
import com.google.android.gms.tasks.Continuation;
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

public class MeasureEmotionActivity extends AppCompatActivity {
    private TextView resultTextView;
    private EditText inputEditText;
    private ExecutorService executorService;
    private ScrollView scrollView;
    private Button predictButton;

    float positiveResult;
    String moodResult, answerCheck;

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
    }

    /** Send input text to TextClassificationClient and get the classify messages. */
    private void classify(final String text) {
        executorService.execute(
                () -> {
                    // TODO 7: Run sentiment analysis on the input text
                    List<Category> results = textClassifier.classify(text);

                    // TODO 8: Convert the result to a human-readable text
                    String textToShow = "Input: " + text + "\nOutput:\n";
                    for (int i = 0; i < results.size(); i++) {
                        Category result = results.get(i);
                        textToShow +=
                                String.format("    %s: %s\n", result.getLabel(), result.getScore());
                        positiveResult = result.getScore();
                    }
                    textToShow += "---------\n";


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

//                    Toast.makeText(
//                            this,
//                            "Positive Result: " + positiveResult,
//                            Toast.LENGTH_LONG)
//                            .show();

//                    Boolean found = Arrays.asList(answerCheck.split(" ")).contains("suicidal");

                    Boolean found = false;

//                    for (int i = 0; i < dangerousWords.size(); i++) {
//                        if (dangerousWords.get(i).contains(answerCheck)) {
//                            System.out.println(dangerousWords.get(i));
//                            found = true;
//                        }
//                    }

//                    if(Arrays.asList(dangerousWords).contains(answerCheck.split(" "))) {
//                        found = true;
//                    }

                    for (int i = 0; i < dangerousWords.size(); i++) {

                        if (answerCheck.toLowerCase().contains(dangerousWords.get(i).toLowerCase())) {

                            found = true;

                        } else {

                            System.out.println("not found..!");

                        }
                    }
                    if(found){
                        Toast.makeText(
                                this,
                                "DANGER",
                                Toast.LENGTH_LONG)
                                .show();
                    } else {

                        if (positiveResult == 1) {
                            Toast.makeText(
                                    this,
                                    "I'm glad you're having such a good day!",
                                    Toast.LENGTH_LONG)
                                    .show();

                        } else if (positiveResult < 0.1) {
                            Toast.makeText(
                                    this,
                                    "I'm sorry you're having such a bad day. How can we help?",
                                    Toast.LENGTH_LONG)
                                    .show();
                        } else if (positiveResult < 0.4 && positiveResult > 0.1) {
                            Toast.makeText(
                                    this,
                                    "You seem to be having a difficult time. How can we help?",
                                    Toast.LENGTH_LONG)
                                    .show();
                        } else if (positiveResult > 0.4 && positiveResult < 0.6) {
                            Toast.makeText(
                                    this,
                                    "Your day seems to be going alright. How can we help?",
                                    Toast.LENGTH_LONG)
                                    .show();
                        } else if (positiveResult > 0.6 && positiveResult < 1) {
                            Toast.makeText(
                                    this,
                                    "You seem to be having a good day! How can we help?",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }

                    }
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
}
