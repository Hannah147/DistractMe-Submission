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

public class BreatheOutActivity extends AppCompatActivity {

    TextView tv_breathe_out;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe_out);
        tv_breathe_out = findViewById(R.id.tv_breathe_out);

        final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content);

        ImageView button = (ImageView) findViewById(R.id.centerImage);
        rippleBackground.startRippleAnimation();
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                rippleBackground.stopRippleAnimation();
                rippleBackground.stopRippleAnimation();
                Intent intent = new Intent();
                intent.setClass(BreatheOutActivity.this, BreatheInRepeatActivity.class);
                startActivity(intent);
            }
        }, 5000);


    }

    public void return_to_distractions(View view) {
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        handler.removeCallbacks(runnable);
        rippleBackground.stopRippleAnimation();
        BreatheOutActivity.this.finish();
        finishAffinity();
        finish();
        startActivity(intent);

    }

}