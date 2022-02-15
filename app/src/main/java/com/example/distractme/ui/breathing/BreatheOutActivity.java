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

    Integer i = 0;
    Boolean back_button = false;
    TextView tv_breathe_out;
    AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );
    AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
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

    public void start_animation(View view) {
//        CardView cardViewCircular = (CardView) findViewById(R.id.cv_round);
//        cardViewCircular.animate().scaleYBy(30f).scaleXBy(30f); //deflating is -50f
//        cardViewCircular.animate().scaleYBy(-50f).scaleXBy(-50f); //deflating is -50f

//        Button btn_animation = (Button) findViewById(R.id.btn_animation);
//        Animation sgAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_grow);
//        btn_animation.startAnimation(sgAnimation);

    }

    public void return_to_distractions(View view) {
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("EXIT", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        handler.removeCallbacks(runnable);
        rippleBackground.stopRippleAnimation();
        BreatheOutActivity.this.finish();
        finishAffinity();
        finish();
        startActivity(intent);

    }

}