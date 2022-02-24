//package com.example.distractme.ui.tracker;
//
//        import android.app.Activity;
//        import android.content.DialogInterface;
//        import android.graphics.ColorMatrix;
//        import android.graphics.ColorMatrixColorFilter;
//        import android.os.Bundle;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//        import androidx.annotation.NonNull;
//        import androidx.appcompat.app.AlertDialog;
//        import androidx.fragment.app.Fragment;
//        import androidx.lifecycle.ViewModelProviders;
//        import androidx.recyclerview.widget.LinearLayoutManager;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.example.distractme.R;
//        import com.example.distractme.ui.adapter.RecyclerViewAdapter;
//
//        import java.util.ArrayList;
//
//public class TrackerFragment extends Fragment {
//
//    private TrackerViewModel TrackerViewModel;
//    Activity mTracker = this.getActivity();
//    String currentMood;
//    ArrayList<String> allMoodEvents = new ArrayList<>();
//    ArrayList<Integer> allMoodsArray = new ArrayList<>();
//    RecyclerViewAdapter adapter;
//    private RecyclerView recyclerView;
//    Boolean moodClicked = false;
//    ImageView ivMoodAdded;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        TrackerViewModel =
//                ViewModelProviders.of(this).get(TrackerViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_tracker, container, false);
//        TextView tvQuestion = root.findViewById(R.id.tvQuestion);
//
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                getActivity());
//        // set title
//        alertDialogBuilder.setTitle("Hello!");
//        alertDialogBuilder.setCancelable(true);
//        // set dialog message
//        alertDialogBuilder
//                .setMessage("How Are You Today?")
//                .setCancelable(true)
//                .setPositiveButton( "Good",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        dialog.cancel();
//                        Toast.makeText(getActivity(), "That's Great News!", Toast.LENGTH_LONG).show();
//
//                    }
//                })
//                .setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                })
//                .setNegativeButton("Not Great",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        dialog.cancel();
//                        Toast.makeText(getActivity(), "Sorry to Hear That, Let us Help!", Toast.LENGTH_LONG).show();
//
//                    }
//                });
//
//
//
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//        // show it
//        alertDialog.show();
//
//        /*
//        Code to make image black and white
//         */
////        Button btnBW = (Button) root.findViewById(R.id.btnBW);
////
////        ImageView ivBW = (ImageView) root.findViewById(R.id.ivCalm);
////        btnBW.setOnClickListener(new View.OnClickListener()
////        {
////            @Override
////            public void onClick(View v)
////            {
////                ColorMatrix matrix = new ColorMatrix();
////                matrix.setSaturation(0);
////
////                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
////                ivBW.setColorFilter(filter);
////
////            }
////        });
//
////        Button btnNormal = (Button) root.findViewById(R.id.btnNormal);
////
////        btnNormal.setOnClickListener(new View.OnClickListener()
////        {
////            @Override
////            public void onClick(View v)
////            {
////                ColorMatrix matrix = new ColorMatrix();
////                matrix.setSaturation(1);
////
////                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
////                ivBW.setColorFilter(filter);
////
////            }
////        });
///*
//End of code to make black and white
// */
//
//        ImageView ivUpsetFace = (ImageView) root.findViewById(R.id.ivUpsetFace);
//        ImageView ivSadFace = (ImageView) root.findViewById(R.id.ivSadFace);
//        ImageView ivNeutralFace = (ImageView) root.findViewById(R.id.ivNeutralFace);
//        ImageView ivHappyFace = (ImageView) root.findViewById(R.id.ivHappyFace);
//        ImageView ivExtremelyHappyFace = (ImageView) root.findViewById(R.id.ivExtremelyHappyFace);
//
//        ColorMatrix BWmatrix = new ColorMatrix();
//        BWmatrix.setSaturation(0);
//        ColorMatrixColorFilter BWfilter = new ColorMatrixColorFilter(BWmatrix);
//
//        ColorMatrix Colourmatrix = new ColorMatrix();
//        Colourmatrix.setSaturation(1);
//        ColorMatrixColorFilter Colourfilter = new ColorMatrixColorFilter(Colourmatrix);
//
////        ivMoodAdded.setImageResource(R.drawable.a_calming_image);
//        ivUpsetFace.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ivUpsetFace.setColorFilter(Colourfilter);
//
//                ivSadFace.setColorFilter(BWfilter);
//                ivNeutralFace.setColorFilter(BWfilter);
//                ivHappyFace.setColorFilter(BWfilter);
//                ivExtremelyHappyFace.setColorFilter(BWfilter);
//
//                currentMood = "Upset";
//                tvQuestion.setText("What made you feel " + currentMood + "?");
//                moodClicked = true;
//                allMoodsArray.add(1);
////                ivMoodAdded.setImageResource(R.drawable.upset_face);
//            }
//        });
//
//        ivSadFace.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ivSadFace.setColorFilter(Colourfilter);
//
//                ivUpsetFace.setColorFilter(BWfilter);
//                ivNeutralFace.setColorFilter(BWfilter);
//                ivHappyFace.setColorFilter(BWfilter);
//                ivExtremelyHappyFace.setColorFilter(BWfilter);
//
//                currentMood = "Sad";
//                tvQuestion.setText("What made you feel " + currentMood + "?");
//                moodClicked = true;
//                allMoodsArray.add(2);
////                ivMoodAdded.setImageResource(R.drawable.sad_face);
//            }
//        });
//
//        ivNeutralFace.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ivNeutralFace.setColorFilter(Colourfilter);
//
//                ivSadFace.setColorFilter(BWfilter);
//                ivUpsetFace.setColorFilter(BWfilter);
//                ivHappyFace.setColorFilter(BWfilter);
//                ivExtremelyHappyFace.setColorFilter(BWfilter);
//
//                currentMood = "Neutral";
//                tvQuestion.setText("What made you feel " + currentMood + "?");
//                moodClicked = true;
//                allMoodsArray.add(3);
////                ivMoodAdded.setImageResource(R.drawable.neutral_face);
//            }
//        });
//
//        ivHappyFace.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ivHappyFace.setColorFilter(Colourfilter);
//
//                ivSadFace.setColorFilter(BWfilter);
//                ivNeutralFace.setColorFilter(BWfilter);
//                ivUpsetFace.setColorFilter(BWfilter);
//                ivExtremelyHappyFace.setColorFilter(BWfilter);
//
//                currentMood = "Happy";
//                tvQuestion.setText("What made you feel " + currentMood + "?");
//                moodClicked = true;
//                allMoodsArray.add(4);
////                ivMoodAdded.setImageResource(R.drawable.happy_face);
//            }
//        });
//
//        ivExtremelyHappyFace.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ivExtremelyHappyFace.setColorFilter(Colourfilter);
//
//                ivSadFace.setColorFilter(BWfilter);
//                ivNeutralFace.setColorFilter(BWfilter);
//                ivHappyFace.setColorFilter(BWfilter);
//                ivUpsetFace.setColorFilter(BWfilter);
//
//                currentMood = "Extremely Happy";
//                tvQuestion.setText("What made you feel " + currentMood + "?");
//                moodClicked = true;
//                allMoodsArray.add(5);
////                ivMoodAdded.setImageResource(R.drawable.extremely_happy_face);
//            }
//        });
//
//        Button btnAddMoodEvent = (Button) root.findViewById(R.id.btnAddMoodEvent);
//        EditText etMoodEvent = (EditText) root.findViewById(R.id.etMoodEvent);
//
//        btnAddMoodEvent.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                recyclerView = root.findViewById(R.id.rvMoods);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                adapter = new RecyclerViewAdapter(getContext(), allMoodEvents, ivMoodAdded, allMoodsArray);
////        adapter.setClickListener((RecyclerViewAdapter.ItemClickListener) getActivity());
//                recyclerView.setAdapter(adapter);
//                View rootRecycle = inflater.inflate(R.layout.recyclerview_row, container, false);
//
//                ivMoodAdded = (ImageView) rootRecycle.findViewById(R.id.ivMoodAdded);
//
////                ivMoodAdded = (ImageView) rootRecycle.findViewById(R.id.ivMoodAdded);
//                if(moodClicked == true) {
//                    String moodEvent = etMoodEvent.getText().toString();
//                    allMoodEvents.add(moodEvent);
//                    moodEvent = "";
//
//
////                    switch(currentMood) {
////                    case "Upset":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
////                        ivMoodAdded.setImageResource(R.drawable.upset_face);
////                        break;
////                    case "Sad":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
////                        ivMoodAdded.setImageResource(R.drawable.sad_face);
////                        break;
////                    case "Neutral":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
////                        ivMoodAdded.setImageResource(R.drawable.neutral_face);
////                        break;
////                    case "Happy":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
////                        ivMoodAdded.setImageResource(R.drawable.happy_face);
////                        break;
////                    case "Extremely Happy":
//////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
////                        ivMoodAdded.setImageResource(R.drawable.extremely_happy_face);
////                        break;
////
////
////                }
//                    ivExtremelyHappyFace.setColorFilter(Colourfilter);
//                    ivSadFace.setColorFilter(Colourfilter);
//                    ivNeutralFace.setColorFilter(Colourfilter);
//                    ivHappyFace.setColorFilter(Colourfilter);
//                    ivUpsetFace.setColorFilter(Colourfilter);
//                    etMoodEvent.setText("");
////                    currentMood = "";
//                    tvQuestion.setText("");
////                    allMoodsArray.clear();
//
//
//                }else {
//                    Toast.makeText(getActivity(), "Please Select Your Mood", Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });
//
//        return root;
//    }
//
//    public void onItemClick(View view, int position) {
//        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
//    }
//
//
//}
//
//
//
//
//
package com.example.distractme.ui.tracker;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.distractme.R;
import com.example.distractme.ui.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class TrackerFragment extends Fragment {

    private TrackerViewModel TrackerViewModel;
    Activity mTracker = this.getActivity();
    String currentMood;
    ArrayList<String> allMoodEvents = new ArrayList<>();
    ArrayList<Integer> allMoodsArray = new ArrayList<>();
    RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    Boolean moodClicked = false;
    ImageView ivMoodAdded;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrackerViewModel =
                ViewModelProviders.of(this).get(TrackerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tracker, container, false);
        TextView tvQuestion = root.findViewById(R.id.tvQuestion);


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
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

        /*
        Code to make image black and white
         */
//        Button btnBW = (Button) root.findViewById(R.id.btnBW);
//
//        ImageView ivBW = (ImageView) root.findViewById(R.id.ivCalm);
//        btnBW.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ColorMatrix matrix = new ColorMatrix();
//                matrix.setSaturation(0);
//
//                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
//                ivBW.setColorFilter(filter);
//
//            }
//        });

//        Button btnNormal = (Button) root.findViewById(R.id.btnNormal);
//
//        btnNormal.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                ColorMatrix matrix = new ColorMatrix();
//                matrix.setSaturation(1);
//
//                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
//                ivBW.setColorFilter(filter);
//
//            }
//        });
/*
End of code to make black and white
 */

        ImageView ivUpsetFace = (ImageView) root.findViewById(R.id.ivUpsetFace);
        ImageView ivSadFace = (ImageView) root.findViewById(R.id.ivSadFace);
        ImageView ivNeutralFace = (ImageView) root.findViewById(R.id.ivNeutralFace);
        ImageView ivHappyFace = (ImageView) root.findViewById(R.id.ivHappyFace);
        ImageView ivExtremelyHappyFace = (ImageView) root.findViewById(R.id.ivExtremelyHappyFace);

        ColorMatrix BWmatrix = new ColorMatrix();
        BWmatrix.setSaturation(0);
        ColorMatrixColorFilter BWfilter = new ColorMatrixColorFilter(BWmatrix);

        ColorMatrix Colourmatrix = new ColorMatrix();
        Colourmatrix.setSaturation(1);
        ColorMatrixColorFilter Colourfilter = new ColorMatrixColorFilter(Colourmatrix);

//        ivMoodAdded.setImageResource(R.drawable.a_calming_image);
        ivUpsetFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivUpsetFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Upset";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(1);
//                ivMoodAdded.setImageResource(R.drawable.upset_face);
            }
        });

        ivSadFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivSadFace.setColorFilter(Colourfilter);

                ivUpsetFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Sad";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(2);
//                ivMoodAdded.setImageResource(R.drawable.sad_face);
            }
        });

        ivNeutralFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivNeutralFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivUpsetFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Neutral";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(3);
//                ivMoodAdded.setImageResource(R.drawable.neutral_face);
            }
        });

        ivHappyFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivHappyFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivUpsetFace.setColorFilter(BWfilter);
                ivExtremelyHappyFace.setColorFilter(BWfilter);

                currentMood = "Happy";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(4);
//                ivMoodAdded.setImageResource(R.drawable.happy_face);
            }
        });

        ivExtremelyHappyFace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ivExtremelyHappyFace.setColorFilter(Colourfilter);

                ivSadFace.setColorFilter(BWfilter);
                ivNeutralFace.setColorFilter(BWfilter);
                ivHappyFace.setColorFilter(BWfilter);
                ivUpsetFace.setColorFilter(BWfilter);

                currentMood = "Extremely Happy";
                tvQuestion.setText("What made you feel " + currentMood + "?");
                moodClicked = true;
                allMoodsArray.add(5);
//                ivMoodAdded.setImageResource(R.drawable.extremely_happy_face);
            }
        });

        Button btnAddMoodEvent = (Button) root.findViewById(R.id.btnAddMoodEvent);
        EditText etMoodEvent = (EditText) root.findViewById(R.id.etMoodEvent);

        btnAddMoodEvent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                recyclerView = root.findViewById(R.id.rvMoods);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                final RecyclerViewAdapter.MyClickListener mcl = new RecyclerViewAdapter.MyClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getActivity(), "Click Worked!", Toast.LENGTH_LONG).show();
                    }
                };
                adapter = new RecyclerViewAdapter(getContext(), allMoodEvents, ivMoodAdded, allMoodsArray, mcl);
//                adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                View rootRecycle = inflater.inflate(R.layout.recyclerview_row, container, false);

                ivMoodAdded = (ImageView) rootRecycle.findViewById(R.id.ivMoodAdded);

//                ivMoodAdded = (ImageView) rootRecycle.findViewById(R.id.ivMoodAdded);
                if(moodClicked == true) {
                    String moodEvent = etMoodEvent.getText().toString();
                    allMoodEvents.add(moodEvent);
                    moodEvent = "";


//                    switch(currentMood) {
//                    case "Upset":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.upset_face));
//                        ivMoodAdded.setImageResource(R.drawable.upset_face);
//                        break;
//                    case "Sad":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.sad_face));
//                        ivMoodAdded.setImageResource(R.drawable.sad_face);
//                        break;
//                    case "Neutral":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.neutral_face));
//                        ivMoodAdded.setImageResource(R.drawable.neutral_face);
//                        break;
//                    case "Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.happy_face));
//                        ivMoodAdded.setImageResource(R.drawable.happy_face);
//                        break;
//                    case "Extremely Happy":
////                        ivMoodAdded.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.extremely_happy_face));
//                        ivMoodAdded.setImageResource(R.drawable.extremely_happy_face);
//                        break;
//
//
//                }
                    ivExtremelyHappyFace.setColorFilter(Colourfilter);
                    ivSadFace.setColorFilter(Colourfilter);
                    ivNeutralFace.setColorFilter(Colourfilter);
                    ivHappyFace.setColorFilter(Colourfilter);
                    ivUpsetFace.setColorFilter(Colourfilter);
                    etMoodEvent.setText("");
//                    currentMood = "";
                    tvQuestion.setText("");
//                    allMoodsArray.clear();


                }else {
                    Toast.makeText(getActivity(), "Please Select Your Mood", Toast.LENGTH_LONG).show();
                }

            }
        });

        return root;
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


}