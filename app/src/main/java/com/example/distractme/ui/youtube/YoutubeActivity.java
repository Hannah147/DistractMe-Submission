package com.example.distractme.ui.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Random;

public class YoutubeActivity extends YouTubeBaseActivity {

    final String[] funnyVideosLess1 = {"nHc288IPFzk", "d6gBu2Zd7Bc", "YnCvkGXAsko", "uznUlgpKBzE", "EJlJPJhttrc", "MUINFs1Sp94", "O5DrAxeeUlI", "FBgLytbB-uE"};
    final String[] calmVideosMore1 = {"lSbF9fq3dz8", "Wr6A78FDy_E", "3clqk2U3T9Y", "kd7KC3PaEaA"};
    final String[] distractingVideosMore1 = {"A5rUhGZk4ds", "IjeKw0B8PG8", "KiwM0Mwc210", "n-pBTuWYb-Y", "fNlpIYbEjkk"};
    private YouTubePlayerView mYouTubePlayerView;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;
    private  YouTubePlayer mYouTubePlayer;

    private final String API_Key = "AIzaSyDzoP7sZLzcLW8cgH69viLec58jtYL1APg";
    private final String Video_Code = "To be replaced";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Button btn_funny = findViewById(R.id.btn_funny);
        Button btn_calm = findViewById(R.id.btn_calm);
        Button btn_distracting = findViewById(R.id.btn_distracting);
        playVideo();

        btn_funny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to randomise youtube link (videoId)
                int randomIndexFunny = new Random().nextInt(funnyVideosLess1.length);
                String random_funny = funnyVideosLess1[randomIndexFunny];
                mYouTubePlayer.cueVideo((random_funny));
            }
        });

        btn_calm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to randomise youtube link (videoId)
                int randomIndexCalm = new Random().nextInt(calmVideosMore1.length);
                String random_calm = calmVideosMore1[randomIndexCalm];
                mYouTubePlayer.cueVideo((random_calm));
            }
        });

        btn_distracting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to randomise youtube link (videoId)
                int randomIndexDistracting = new Random().nextInt(distractingVideosMore1.length);
                String random_distracting = calmVideosMore1[randomIndexDistracting];
                mYouTubePlayer.cueVideo((random_distracting));
            }
        });


    }
    public void playVideo() {
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayerView);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    mYouTubePlayer = youTubePlayer;
                    mYouTubePlayer.cueVideo(Video_Code);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        mYouTubePlayerView.initialize(API_Key, mOnInitializedListener);
    }


    public void return_to_distractions(View view) {
//        Intent intent = new Intent();
//        String distractionsFragment = "FRAGMENT_DISTRACTIONS";
//        intent.putExtra("frgToLoad", distractionsFragment);
//        intent.setClass(YoutubeActivity.this, MainActivity.class);
//        startActivity(intent);
        Intent i = new Intent(YoutubeActivity.this, MainActivity.class);
        String distractionsFragment = "FRAGMENT_DISTRACTIONS";
        i.putExtra("fragment", distractionsFragment);
        startActivity(i);
    }
}