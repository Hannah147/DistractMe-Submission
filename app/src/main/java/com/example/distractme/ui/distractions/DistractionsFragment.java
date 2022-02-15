package com.example.distractme.ui.distractions;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.distractme.R;
import com.example.distractme.ui.breathing.BreatheInActivity;
import com.example.distractme.ui.drawing.DrawingActivity;
import com.example.distractme.ui.grounding.FiveThingsSeeActivity;
import com.example.distractme.ui.youtube.YoutubeActivity;

public class DistractionsFragment extends Fragment {

    private DistractionsViewModel distractionsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        distractionsViewModel =
                ViewModelProviders.of(this).get(DistractionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_distractions, container, false);
        Button btn_youtube = (Button) root.findViewById(R.id.btn_youtube);

        btn_youtube.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), YoutubeActivity.class);
                getActivity().startActivity(intent);

            }
        });

        ImageView ivYoutube = (ImageView) root.findViewById(R.id.ivYoutube);

        ivYoutube.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), YoutubeActivity.class);
                getActivity().startActivity(intent);

            }
        });


        Button btn_54321 = (Button) root.findViewById(R.id.btn_54321);
        btn_54321.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FiveThingsSeeActivity.class);
                getActivity().startActivity(intent);
            }
        });

        ImageView iv54321 = (ImageView) root.findViewById(R.id.ivSenses);

        iv54321.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FiveThingsSeeActivity.class);
                getActivity().startActivity(intent);
            }
        });

        Button btn_breathing = (Button) root.findViewById(R.id.btn_breathing);
        btn_breathing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                // set title
                alertDialogBuilder.setTitle("Breathing Exercise");
                alertDialogBuilder.setCancelable(false);
                // set dialog message
                alertDialogBuilder
                        .setMessage("Focus on the Ripples as you Breathe :)")
                        .setCancelable(true)
                        .setNeutralButton( "Okay",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                                Intent intent = new Intent();
                                intent.setClass(getActivity(), BreatheInActivity.class);
                                getActivity().startActivity(intent);
                            }
                        });



                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
//                Uri uri = Uri.parse("http://www.google.com"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//                Intent intent = new Intent(getContext(), BreathingFragment.class);
//                startActivity(intent);
//                finish();

//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.mobile_navigation, BreathingFragment.class, null)
//                        .setReorderingAllowed(true)
//                        .addToBackStack("name") // name can be null
//                        .commit();

//                Fragment fragment = new tasks();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.content_frame, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

//                Intent intent = new Intent();
//                intent.setClass(getActivity(), BreathingFragment.class);
//                getActivity().startActivity(intent);
            }
        });

        Button btn_draw = (Button) root.findViewById(R.id.btn_draw);
        btn_draw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Uri uri = Uri.parse("http://www.itsligo.ie"); // missing 'http://' will cause crashed
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);

                Intent intent = new Intent();
                intent.setClass(getActivity(), DrawingActivity.class);
                getActivity().startActivity(intent);

            }
        });
        return root;
    }


}