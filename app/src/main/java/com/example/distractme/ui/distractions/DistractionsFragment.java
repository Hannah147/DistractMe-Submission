package com.example.distractme.ui.distractions;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.breathing.BreatheInActivity;
import com.example.distractme.ui.drawing.DrawingActivity;
import com.example.distractme.ui.googlemaps.MapsActivity;
import com.example.distractme.ui.grounding.FiveThingsSeeActivity;
import com.example.distractme.ui.oddoneout.FindTheDogActivity;
import com.example.distractme.ui.youtube.YoutubeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DistractionsFragment extends Fragment {

    private DistractionsViewModel distractionsViewModel;
    BottomNavigationView navView;
    Boolean youtube = true, breathing = true, grounding = true, drawing = true, oddoneout = true, gosomewhere = true, comeFromMeasure = true, switched;
    Button btn_youtube, btn_54321, btn_breathing, btn_draw, btn_oddoneout, btn_somewhere;
    ImageView ivYoutube, iv54321, ivBreathing, ivDraw, ivOddoneout, ivSomewhere;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        distractionsViewModel =
                ViewModelProviders.of(this).get(DistractionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_distractions, container, false);
        btn_youtube = (Button) root.findViewById(R.id.btn_youtube);

        navView = root.findViewById(R.id.nav_view);

        switched=((MainActivity)getContext()).getSwitched();

        switched = false;

        if(!comeFromMeasure) {
            youtube = getArguments().getBoolean("youtube");
            breathing = getArguments().getBoolean("breathing");
            grounding = getArguments().getBoolean("grounding");
            drawing = getArguments().getBoolean("drawing");
            oddoneout = getArguments().getBoolean("oddoneout");
            gosomewhere = getArguments().getBoolean("gosomewhere");
        } else {

        }

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

        ivYoutube = (ImageView) root.findViewById(R.id.ivYoutube);

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


        btn_54321 = (Button) root.findViewById(R.id.btn_54321);
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

        iv54321 = (ImageView) root.findViewById(R.id.ivSenses);

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

        btn_breathing = (Button) root.findViewById(R.id.btn_breathing);
        btn_breathing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
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
            }
        });

        ivBreathing = (ImageView) root.findViewById(R.id.ivBreathing);

        ivBreathing.setOnClickListener(new View.OnClickListener()
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
            }
        });

        btn_draw = (Button) root.findViewById(R.id.btn_draw);
        btn_draw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), DrawingActivity.class);
                getActivity().startActivity(intent);

            }
        });

        ivDraw = (ImageView) root.findViewById(R.id.ivDraw);

        ivDraw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), DrawingActivity.class);
                getActivity().startActivity(intent);

            }
        });

        btn_oddoneout = (Button) root.findViewById(R.id.btn_oddoneout);
        btn_oddoneout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FindTheDogActivity.class);
                getActivity().startActivity(intent);
            }
        });

        ivOddoneout = (ImageView) root.findViewById(R.id.ivOddOneOut);
        ivOddoneout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FindTheDogActivity.class);
                getActivity().startActivity(intent);
            }
        });

        btn_somewhere = (Button) root.findViewById(R.id.btn_map);
        btn_somewhere.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MapsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        ivSomewhere = (ImageView) root.findViewById(R.id.ivMap);
        ivSomewhere.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MapsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return root;
    }

    public void CheckRecommended() {
        if(!youtube) {
            btn_youtube.setVisibility(View.INVISIBLE);
            ivYoutube.setVisibility(View.INVISIBLE);
        }

        if(!breathing) {
            btn_breathing.setVisibility(View.INVISIBLE);
            ivBreathing.setVisibility(View.INVISIBLE);
        }

        if(!grounding) {
            btn_54321.setVisibility(View.INVISIBLE);
            iv54321.setVisibility(View.INVISIBLE);
        }

        if(!drawing) {
            btn_draw.setVisibility(View.INVISIBLE);
            ivDraw.setVisibility(View.INVISIBLE);
        }

        if(!oddoneout) {
            btn_oddoneout.setVisibility(View.INVISIBLE);
            ivOddoneout.setVisibility(View.INVISIBLE);
        }

        if(!gosomewhere) {
            btn_somewhere.setVisibility(View.INVISIBLE);
            ivSomewhere.setVisibility(View.INVISIBLE);
        }
    }
}