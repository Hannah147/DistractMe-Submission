package com.example.distractme.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.checkin.MeasureEmotionActivity;
import com.example.distractme.ui.distractions.DistractionsFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    String currentDay, currentMonth, currentDate;
    ListView lvInfo;
    ArrayList<String> information;

    Boolean switched = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView tvCurrentDay = root.findViewById(R.id.tvCurrentDay);
        lvInfo = root.findViewById(R.id.lvInfo);

        Toast.makeText(getContext(), "Working? :", Toast.LENGTH_LONG).show();

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        int year = calendar.get(Calendar.YEAR);


        SetDate(day, month, date);

        tvCurrentDay.setText(currentDay + " " + currentMonth + " " + currentDate + " " + year);

        information = new ArrayList<String>();

        getInfo();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, information);
        lvInfo.setAdapter(arrayAdapter);

        lvInfo.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
        lvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedInfo = information.get(position);
                Toast.makeText(getContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
                if(selectedInfo == "Depression") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/clinical-depression/clinical-depression-symptoms.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Anxiety") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/anxiety.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Panic Attack") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/how-to-deal-with-panic-attacks.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Social Anxiety") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/social-anxiety-social-phobia.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Generalised Anxiety Disorder in Adults") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/generalised-anxiety-disorder-in-adults/generalised-anxiety-disorder-symptoms.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Postnatal Depression") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/postnatal-depression/postnatal-depression.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Insomnia") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/insomnia.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Self-Harm") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/self-harm/self-harm-types-and-signs.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Phobias") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/phobias/phobias-symptoms.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Eating Disorders") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/eating-disorders.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Depression in Children and Teenagers") {
                    Uri uri = Uri.parse("https://www2.hse.ie/wellbeing/mental-health/depression-in-children-and-teenagers.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Alcohol and Mental Health") {
                    Uri uri = Uri.parse("https://www2.hse.ie/wellbeing/alcohol/mental-health/how-alcohol-affects-your-mental-health.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Bipolar Disorder") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/bipolar-disorder/bipolar-disorder-symptoms.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if(selectedInfo == "Seasonal Affective Disorder (SAD)") {
                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/seasonal-affective-disorder/seasonal-affective-disorder-sad-treatment.html"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });

        Button btn_TellUs = (Button) root.findViewById(R.id.btnTellUs);

        btn_TellUs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
                // set title
                alertDialogBuilder.setTitle("Word Analysis");
                // set dialog message
                alertDialogBuilder
                        .setMessage("By answering how you are, we can analyse your response, and suggest distractions. Are you alright with this?")
                        .setCancelable(false)
                        .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Intent intent = new Intent();
                                intent.setClass(getActivity(), MeasureEmotionActivity.class);
                                getActivity().startActivity(intent);
                            }
                        })
                        .setNegativeButton("No, I'll choose myself.",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                                ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
                                ft.addToBackStack(null);
                                ft.commit();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        Button btn_StraightDistractions = (Button) root.findViewById(R.id.btnStraightDistractions);

        btn_StraightDistractions.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        switched=((MainActivity)getContext()).getSwitched();
        if(switched) {
            final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
            ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
            ft.addToBackStack(null);
            ft.commit();
        }

        switched = false;
        return root;
    }

    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Boolean i = bundle.getBoolean("switched", switched);
            String checkSwitched = switched.toString();
            Toast.makeText(getContext(), "Switched Status : " + checkSwitched, Toast.LENGTH_LONG).show();

        }

        if (switched == true) {
            Fragment newFragment = new DistractionsFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container_view_tag, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }

    }

    public void getInfo()
    {
        information.add("Depression");
        information.add("Depression in Children and Teenagers");
        information.add("Depression in Young People");
        information.add("Anxiety");
        information.add("Panic Attack");
        information.add("Social Anxiety");
        information.add("Generalised Anxiety Disorder in Adults");
        information.add("Seasonal Affective Disorder (SAD)");
        information.add("Bipolar Disorder");
        information.add("Alcohol and Mental Health");
        information.add("Eating Disorders");
        information.add("Phobias");
        information.add("Self-Harm");
        information.add("Insomnia");
        information.add("Postnatal Depression");


    }

    public void SetDate(int day, int month, int date) {
        switch (day) {
            case Calendar.MONDAY:
                currentDay = "Monday";
                break;
            case Calendar.TUESDAY:
                currentDay = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                currentDay = "Wednesday";
                break;
            case Calendar.THURSDAY:
                currentDay = "Thursday";
                break;
            case Calendar.FRIDAY:
                currentDay = "Friday";
                break;
            case Calendar.SATURDAY:
                currentDay = "Saturday";
                break;
            case Calendar.SUNDAY:
                currentDay = "Sunday";
                break;
        }

        switch (month) {
            case Calendar.JANUARY:
                currentMonth = "January";
                break;
            case Calendar.FEBRUARY:
                currentMonth = "February";
                break;
            case Calendar.MARCH:
                currentMonth = "March";
                break;
            case Calendar.APRIL:
                currentMonth = "April";
                break;
            case Calendar.MAY:
                currentMonth = "May";
                break;
            case Calendar.JUNE:
                currentMonth = "June";
                break;
            case Calendar.JULY:
                currentMonth = "July";
                break;
            case Calendar.AUGUST:
                currentMonth = "August";
                break;
            case Calendar.SEPTEMBER:
                currentMonth = "September";
                break;
            case Calendar.OCTOBER:
                currentMonth = "October";
                break;
            case Calendar.NOVEMBER:
                currentMonth = "November";
                break;
            case Calendar.DECEMBER:
                currentMonth = "December";
                break;

        }

        switch(date) {
            case 1:
            case 21:
            case 31:
                currentDate = date + "st";
                break;
            case 2:
            case 22:
                currentDate = date + "nd";
                break;
            case 3:
            case 23:
                currentDate = date + "rd";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 24:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
                currentDate = date + "th";
                break;


        }
    }
}