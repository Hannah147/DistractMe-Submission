//package com.example.distractme;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.os.Handler;
//import android.view.View;
//import android.view.animation.AlphaAnimation;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import com.example.distractme.ui.distractions.DistractionsFragment;
//import com.skyfishjy.library.RippleBackground;
//
//public class BreatheInRepeatActivity extends AppCompatActivity {
//
//    Integer i = 0;
//    Boolean back_button = false;
//    TextView tv_breathe_in_repeat;
//    AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );
//    AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_breathe_in_repeat);
//        tv_breathe_in_repeat = findViewById(R.id.tv_breathe_in_repeat);
//
//        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
//        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
//        fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
//        tv_breathe_in_repeat.startAnimation(fadeIn);
//        fadeIn.setDuration(1200);
//        fadeIn.setFillAfter(true);
//        rippleBackground.startRippleAnimation();
//
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                rippleBackground.stopRippleAnimation();
////                fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
////                tv_breathe_out.startAnimation(fadeOut);
////                fadeOut.setDuration(1200);
////                fadeOut.setFillAfter(true);
////                fadeOut.setStartOffset(4200+fadeIn.getStartOffset());
//                i=0;
//                Intent intent = new Intent();
//                intent.setClass(BreatheInRepeatActivity.this, BreatheOutActivity.class);
////                if(back_button = true) {
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                intent.putExtra("EXIT", true);
////                }
//                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivity(intent);
//                BreatheInRepeatActivity.this.finish();
//
//            }
//        }, 5000);
//
//
//        new CountDownTimer(1000, 100) {
//
//                public void onTick(long millisUntilFinished) {
////                final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
////                ImageView imageView=(ImageView)findViewById(R.id.centerImage);
////                rippleBackground.startRippleAnimation();
//            }
//
//            public void onFinish() {
////                final Handler handler = new Handler();
////                handler.postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////                        rippleBackground.stopRippleAnimation();
////                        i=0;
////                    }
////                }, 5000);
//
//            }
//
//        };
//
//        if(getIntent().getBooleanExtra("EXIT", false)) {
//            finish();
//        }
//
//    }
//
//    public void start_animation(View view) {
////        CardView cardViewCircular = (CardView) findViewById(R.id.cv_round);
////        cardViewCircular.animate().scaleYBy(30f).scaleXBy(30f); //deflating is -50f
////        cardViewCircular.animate().scaleYBy(-50f).scaleXBy(-50f); //deflating is -50f
//
////        Button btn_animation = (Button) findViewById(R.id.btn_animation);
////        Animation sgAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_grow);
////        btn_animation.startAnimation(sgAnimation);
//
//    }
//
//    public void return_to_distractions(View view) {
//        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
//        back_button = true;
//        Intent intent = new Intent();
//        intent.setClass(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("EXIT", true);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        rippleBackground.stopRippleAnimation();
//        startActivity(intent);
//        BreatheInRepeatActivity.this.finish();
//        finishAffinity();
//        finish();
//    }
//
//}

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

    Integer i = 0;
    Boolean back_button = false;
    TextView tv_breathe_in_repeat;
    AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );
    AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
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