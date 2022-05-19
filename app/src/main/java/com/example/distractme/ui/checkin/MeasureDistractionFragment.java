package com.example.distractme.ui.checkin;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.distractme.R;
import com.example.distractme.ui.breathing.BreatheInActivity;
import com.example.distractme.ui.drawing.DrawingActivity;
import com.example.distractme.ui.googlemaps.MapsActivity;
import com.example.distractme.ui.grounding.FiveThingsSeeActivity;
import com.example.distractme.ui.oddoneout.FindTheDogActivity;
import com.example.distractme.ui.youtube.YoutubeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MeasureDistractionFragment extends Fragment {
    BottomNavigationView navView;
    Boolean youtube, breathing, grounding, drawing, oddoneout, gosomewhere, clickedback;
    Button btn_youtube, btn_54321, btn_breathing, btn_draw, btn_oddoneout, btn_somewhere, btn_back, btn_checkin;
    ImageView ivYoutube, iv54321, ivBreathing, ivDraw, ivOddoneout, ivSomewhere;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_measure_distraction, container, false);

        btn_checkin = (Button) getActivity().findViewById(R.id.predict_button);
        btn_back = (Button) root.findViewById(R.id.btn_back);
        btn_youtube = (Button) root.findViewById(R.id.btn_youtube);
        ivYoutube = (ImageView) root.findViewById(R.id.ivYoutube);
        btn_54321 = (Button) root.findViewById(R.id.btn_54321);
        iv54321 = (ImageView) root.findViewById(R.id.ivSenses);
        btn_breathing = (Button) root.findViewById(R.id.btn_breathing);
        ivBreathing = (ImageView) root.findViewById(R.id.ivBreathing);
        btn_draw = (Button) root.findViewById(R.id.btn_draw);
        ivDraw = (ImageView) root.findViewById(R.id.ivDraw);
        btn_oddoneout = (Button) root.findViewById(R.id.btn_oddoneout);
        ivOddoneout = (ImageView) root.findViewById(R.id.ivOddOneOut);
        btn_somewhere = (Button) root.findViewById(R.id.btn_map);
        ivSomewhere = (ImageView) root.findViewById(R.id.ivMap);

        navView = root.findViewById(R.id.nav_view);

        MeasureEmotionActivity activity = (MeasureEmotionActivity) getActivity();

        youtube = activity.getYoutube();
        breathing = activity.getBreathing();
        grounding = activity.getGrounding();
        drawing = activity.getDrawing();
        oddoneout = activity.getOddoneout();
        gosomewhere = activity.getGoSomewhere();

        Toast.makeText(
                getActivity(),
                "Youtube: " + youtube + "Breathing: " + breathing + "Grounding:" + grounding + "Drawing:" + drawing + "oddoneout:" + oddoneout + "go somewhere:" + gosomewhere,
                Toast.LENGTH_LONG)
                .show();

        CheckRecommended();

        btn_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clickedback = true;
                Bundle clickedData = new Bundle();
                clickedData.putBoolean("clickedback", clickedback);
                Intent intent = getActivity().getIntent();
                intent.putExtras(clickedData);

                youtube = false;
                breathing = false;
                drawing = false;
                grounding = false;
                oddoneout = false;
                gosomewhere = false;
                btn_checkin.setVisibility(View.VISIBLE);
                getFragmentManager().beginTransaction().remove(MeasureDistractionFragment.this).commit();
            }
        });


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

        btn_breathing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AlertDialogCustom));
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


        ivBreathing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
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


