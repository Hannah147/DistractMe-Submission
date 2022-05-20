package com.example.distractme.ui.breathing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.skyfishjy.library.RippleBackground;

public class BreatheInActivity extends AppCompatActivity {

    Boolean back_to_distraction = false;
    TextView tv_breathe_in;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe_in);
        tv_breathe_in = findViewById(R.id.tv_breathe_in);

        final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content);


        ImageView button = (ImageView) findViewById(R.id.centerImage);
        rippleBackground.startRippleAnimation();
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                rippleBackground.stopRippleAnimation();
                Intent intent = new Intent();
                intent.setClass(BreatheInActivity.this, BreatheOutActivity.class);
                startActivity(intent);

            }
        }, 5000);
    }

    public void return_to_distractions(View view) {
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        back_to_distraction = true;
        handler.removeCallbacks(runnable);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
//        String distractionsFragment = "FRAGMENT_DISTRACTIONS";
//        intent.putExtra("fragment", distractionsFragment);
        intent.putExtra("back_to_distraction", back_to_distraction);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        BreatheInActivity.this.finish();
        finishAffinity();
        finish();
        startActivity(intent);
    }
}