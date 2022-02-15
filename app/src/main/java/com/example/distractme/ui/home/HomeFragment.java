package com.example.distractme.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.distractme.R;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    String currentDay, currentMonth, currentDate;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView tvCurrentDay = root.findViewById(R.id.tvCurrentDay);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        int year = calendar.get(Calendar.YEAR);

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

        tvCurrentDay.setText(currentDay + " " + currentMonth + " " + currentDate + " " + year);

        return root;
    }
}