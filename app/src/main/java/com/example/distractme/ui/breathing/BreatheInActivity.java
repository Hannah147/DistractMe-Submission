//package com.example.distractme;
////
////import android.content.DialogInterface;
////import android.content.Intent;
////import android.os.Bundle;
////import android.os.CountDownTimer;
////import android.os.Handler;
////import android.view.View;
////import android.view.animation.AlphaAnimation;
////import android.widget.ImageView;
////import android.widget.TextView;
////import android.widget.Toast;
////
////import androidx.appcompat.app.AlertDialog;
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.skyfishjy.library.RippleBackground;
////
////public class BreatheInActivity extends AppCompatActivity {
////
////    Integer i = 0;
////    TextView tv_breathe_in;
////    AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );
////    AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_breathe_in);
////        tv_breathe_in = findViewById(R.id.tv_breathe_in);
////
////        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BreatheInActivity.this);
////        // set title
////        alertDialogBuilder.setTitle("Breathing Exercise");
////        alertDialogBuilder.setCancelable(false);
////        // set dialog message
////        alertDialogBuilder
////                .setMessage("Focus on the Ripples as you Breathe :)")
////                .setCancelable(true)
////                .setNeutralButton( "Okay",new DialogInterface.OnClickListener() {
////                    public void onClick(DialogInterface dialog,int id) {
////                        dialog.cancel();
////                        new CountDownTimer(1000, 100) {
////
////                            public void onTick(long millisUntilFinished) {
////                                final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
////                                ImageView imageView=(ImageView)findViewById(R.id.centerImage);
////                                imageView.setOnClickListener(new View.OnClickListener() {
////                                    @Override
////                                    public void onClick(View view) {
////                                        if(i == 0) {
//////                            tv_breathe_in.setText("Breathe In...");
////                                            tv_breathe_in.startAnimation(fadeIn);
////                                            fadeIn.setDuration(1200);
////                                            fadeIn.setFillAfter(true);
////                                            rippleBackground.startRippleAnimation();
////                                            i++;
////                                        } else if (i == 1) {
////                                            rippleBackground.stopRippleAnimation();
//////                            tv_breathe_in.startAnimation(fadeOut);
//////                            fadeOut.setDuration(1200);
//////                            fadeOut.setFillAfter(true);
//////                            fadeOut.setStartOffset(4200+fadeIn.getStartOffset());
////                                            Intent intent = new Intent();
////                                            intent.setClass(getApplicationContext(), BreatheInActivity.class);
////                                            startActivity(intent);
////                                            i = 0;
////                                        }
////                                    }
////                                });                //here you can have your logic to set text to edittext
////                            }
////
////                            public void onFinish() {
////                                final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
////                                final Handler handler = new Handler();
////                                handler.postDelayed(new Runnable() {
////                                    @Override
////                                    public void run() {
////                                        rippleBackground.stopRippleAnimation();
////                                        Intent intent = new Intent();
////                                        intent.setClass(getApplicationContext(), BreatheOutActivity.class);
////                                        startActivity(intent);
////
////
////                                    }
////                                }, 5000);
////
////                            }
////
////                        }.start();
////
////                    }
////                });
////
////
////
////        // create alert dialog
////        AlertDialog alertDialog = alertDialogBuilder.create();
////
////        // show it
////        alertDialog.show();
////
//////        BottomNavigationView navView = findViewById(R.id.nav_view);
//////        // Passing each menu ID as a set of Ids because each
//////        // menu should be considered as top level destinations.
//////        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//////                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_distractions, R.id.navigation_tracker)
//////                .build();
//////        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//////        NavigationUI.setupWithNavController(navView, navController);
////
////
////
////
////
////
//////        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
//////        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
//////        imageView.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////                if(i == 0) {
//////                    rippleBackground.startRippleAnimation();
//////                    i++;
//////                } else if (i == 1) {
//////                    rippleBackground.stopRippleAnimation();
//////                    i = 0;
//////                }
//////            }
//////        });
////
//////        final Handler handler = new Handler();
//////        handler.postDelayed(new Runnable() {
//////            @Override
//////            public void run() {
//////                rippleBackground.stopRippleAnimation();
//////                i=0;
//////            }
//////        }, 5000);
////
////    }
////
////    public void start_animation(View view) {
//////        CardView cardViewCircular = (CardView) findViewById(R.id.cv_round);
//////        cardViewCircular.animate().scaleYBy(30f).scaleXBy(30f); //deflating is -50f
//////        cardViewCircular.animate().scaleYBy(-50f).scaleXBy(-50f); //deflating is -50f
////
//////        Button btn_animation = (Button) findViewById(R.id.btn_animation);
//////        Animation sgAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink_grow);
//////        btn_animation.startAnimation(sgAnimation);
////
////    }
////}
//package com.example.distractme;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.os.Handler;
//import android.view.View;
//import android.view.animation.AlphaAnimation;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import com.example.distractme.ui.distractions.DistractionsFragment;
//import com.skyfishjy.library.RippleBackground;
//
//public class BreatheInActivity extends AppCompatActivity {
//
//    Integer i = 0;
//    Boolean back_button = false;
//    TextView tv_breathe_in;
//    AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );
//    AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_breathe_in);
//        tv_breathe_in = findViewById(R.id.tv_breathe_in);
//
//                        new CountDownTimer(1000, 100) {
//
//                            public void onTick(long millisUntilFinished) {
//                                final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
//                                ImageView imageView=(ImageView)findViewById(R.id.centerImage);
//                                imageView.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        if(i == 0) {
////                            tv_breathe_in.setText("Breathe In...");
//                                            tv_breathe_in.startAnimation(fadeIn);
//                                            fadeIn.setDuration(1200);
//                                            fadeIn.setFillAfter(true);
//                                            rippleBackground.startRippleAnimation();
//                                            i++;
//                                        } else if (i == 1) {
//                                            rippleBackground.stopRippleAnimation();
////                            tv_breathe_in.startAnimation(fadeOut);
////                            fadeOut.setDuration(1200);
////                            fadeOut.setFillAfter(true);
////                            fadeOut.setStartOffset(4200+fadeIn.getStartOffset());
//                                            Intent intent = new Intent();
//                                            intent.setClass(BreatheInActivity.this, BreatheOutActivity.class);
////                                            if(back_button = true) {
////                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                                            intent.putExtra("EXIT", true);
////                                            }
//                                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                                            startActivity(intent);
//                                            BreatheInActivity.this.finish();
//                                            i = 0;
//                                        }
//                                    }
//                                });                //here you can have your logic to set text to edittext
//                            }
//
//                            public void onFinish() {
//                                final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
//                                final Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        rippleBackground.stopRippleAnimation();
//                                        Intent intent = new Intent();
//                                        intent.setClass(BreatheInActivity.this, BreatheOutActivity.class);
////                                        if(back_button = true) {
////                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////                                        intent.putExtra("EXIT", true);
////                                        }
//                                        startActivity(intent);
//                                        BreatheInActivity.this.finish();
//
//
//                                    }
//                                }, 5000);
//
//                            }
//
//                        }.start();
//
//
//
////        BottomNavigationView navView = findViewById(R.id.nav_view);
////        // Passing each menu ID as a set of Ids because each
////        // menu should be considered as top level destinations.
////        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
////                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_distractions, R.id.navigation_tracker)
////                .build();
////        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
////        NavigationUI.setupWithNavController(navView, navController);
//
//
//
//
//
//
////        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
////        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
////        imageView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                if(i == 0) {
////                    rippleBackground.startRippleAnimation();
////                    i++;
////                } else if (i == 1) {
////                    rippleBackground.stopRippleAnimation();
////                    i = 0;
////                }
////            }
////        });
//
////        final Handler handler = new Handler();
////        handler.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                rippleBackground.stopRippleAnimation();
////                i=0;
////            }
////        }, 5000);
//
//        if(getIntent().getBooleanExtra("EXIT", false)) {
//            finish();
//        }
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
////        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        intent.putExtra("EXIT", true);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
////        rippleBackground.stopRippleAnimation();
//        startActivity(intent);
//        BreatheInActivity.this.finish();
//        finishAffinity();
//        finish();
//    }
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

public class BreatheInActivity extends AppCompatActivity {

    Integer i = 0;
    Boolean back_to_distraction = false;
    TextView tv_breathe_in;
    AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
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




//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_distractions, R.id.navigation_tracker)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);






//        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
//        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(i == 0) {
//                    rippleBackground.startRippleAnimation();
//                    i++;
//                } else if (i == 1) {
//                    rippleBackground.stopRippleAnimation();
//                    i = 0;
//                }
//            }
//        });

//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                rippleBackground.stopRippleAnimation();
//                i=0;
//            }
//        }, 5000);
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
        back_to_distraction = true;
        handler.removeCallbacks(runnable);
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtra("back_to_distraction", back_to_distraction);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("EXIT", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        rippleBackground.stopRippleAnimation();
        BreatheInActivity.this.finish();
        finishAffinity();
        finish();
        startActivity(intent);
    }
}