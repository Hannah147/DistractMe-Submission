package com.example.distractme.ui.tracker;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.tracker.TrackerViewModel;

public class TrackerFragment extends Fragment {

    private TrackerViewModel TrackerViewModel;
    Activity mTracker = this.getActivity();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrackerViewModel =
                ViewModelProviders.of(this).get(TrackerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tracker, container, false);
        final TextView textView = root.findViewById(R.id.text_tracker);
        TrackerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
/*
                Toast.makeText(getActivity(), "How are you today?", Toast.LENGTH_LONG).show();
*/


            }
        });
/*
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
        alertDialog.setTitle("Hello!");
        alertDialog.setMessage("How Are You Today?");
        */
/*alertDialog.setPositiveButton(AlertDialog.BUTTON_NEUTRAL, "Good",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Bad",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });*//*


        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed Cancel button. Write Logic Here
                        Toast.makeText(getApplicationContext(),
                                "You clicked on YES", Toast.LENGTH_SHORT)
                                .show();
                    }
                });
// Setting Positive Yes Btn
        alertDialog.setNeutralButton("NO",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed No button. Write Logic Here
                        Toast.makeText(getApplicationContext(),
                                "You clicked on NO", Toast.LENGTH_SHORT)
                                .show();
                    }
                });
// Setting Positive "Cancel" Btn
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed Cancel button. Write Logic Here
                        Toast.makeText(getApplicationContext(),
                                "You clicked on Cancel", Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        alertDialog.show();
*/
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getActivity());
        // set title
        alertDialogBuilder.setTitle("Hello!");
        alertDialogBuilder.setCancelable(true);
        // set dialog message
        alertDialogBuilder
                .setMessage("How Are You Today?")
                .setCancelable(true)
                .setPositiveButton( "Good",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                        Toast.makeText(getActivity(), "That's Great News!", Toast.LENGTH_LONG).show();

                    }
                })
                .setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Not Great",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                        Toast.makeText(getActivity(), "Sorry to Hear That, Let us Help!", Toast.LENGTH_LONG).show();

                    }
                });



        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
        return root;
    }


}