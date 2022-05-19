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

public class BreatheInRepeatActivity extends AppCompatActivity {

    Boolean back_button = false;
    TextView tv_breathe_in_repeat;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe_in_repeat);
        tv_breathe_in_repeat = findViewById(R.id.tv_breathe_in_repeat);

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
                intent.setClass(BreatheInRepeatActivity.this, BreatheOutActivity.class);
                startActivity(intent);
            }
        }, 5000);

    }

    public void return_to_distractions(View view) {
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        back_button = true;
        handler.removeCallbacks(runnable);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        rippleBackground.stopRippleAnimation();
        BreatheInRepeatActivity.this.finish();
        finishAffinity();
        finish();
        startActivity(intent);
    }

}