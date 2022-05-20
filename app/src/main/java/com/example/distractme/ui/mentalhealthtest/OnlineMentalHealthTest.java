package com.example.distractme.ui.mentalhealthtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;

public class OnlineMentalHealthTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_mental_health_test);
    }

    public void goToDepressionTest(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Depression Test");
        // set dialog message
        alertDialogBuilder
                .setMessage("This is not an official diagnosis. Do you wish to take the test for Depression?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Uri uri = Uri.parse("https://screening.mhanational.org/screening-tools/depression/?ref");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    public void goToAnxietyTest(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Anxiety Test");
        // set dialog message
        alertDialogBuilder
                .setMessage("This is not an official diagnosis. Do you wish to take the test for Anxiety?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Uri uri = Uri.parse("https://screening.mhanational.org/screening-tools/anxiety/?ref"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void goToAddictionTest(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Addiction Test");
        // set dialog message
        alertDialogBuilder
                .setMessage("This is not an official diagnosis. Do you wish to take the test for Addiction?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Uri uri = Uri.parse("https://screening.mhanational.org/screening-tools/addiction/?ref"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void goToBipolarTest(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Bipolar Test");
        // set dialog message
        alertDialogBuilder
                .setMessage("This is not an official diagnosis. Do you wish to take the test for Bipolar?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Uri uri = Uri.parse("https://screening.mhanational.org/screening-tools/bipolar/?ref"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void goToEatingDisorderTest(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Eating Disorder Test");
        // set dialog message
        alertDialogBuilder
                .setMessage("This is not an official diagnosis. Do you wish to take the test for an Eating Disorder?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Uri uri = Uri.parse("https://screening.mhanational.org/screening-tools/eating-disorder/?ref"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void return_to_home(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
//        String othersFragment = "FRAGMENT_OTHERS";
//        intent.putExtra("fragment", othersFragment);
        startActivity(intent);
    }
}