//package com.example.distractme.ui.home;
//
//import android.Manifest;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.pm.PackageManager;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.provider.Settings;
//import android.util.Log;
//import android.view.ContextThemeWrapper;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.core.app.ActivityCompat;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.lifecycle.ViewModelProviders;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//import com.android.volley.BuildConfig;
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.request.RequestOptions;
//import com.example.distractme.MainActivity;
//import com.example.distractme.R;
//import com.example.distractme.databinding.ActivityMainBinding;
//import com.example.distractme.databinding.FragmentHomeBinding;
//import com.example.distractme.ui.checkin.MeasureEmotionActivity;
//import com.example.distractme.ui.distractions.DistractionsFragment;
//import com.example.distractme.ui.services.LocationMonitoringService;
//import com.example.distractme.Weather;
//import com.example.distractme.ui.weather_data.WeatherTask;
//import com.example.distractme.ui.weather_data.WeatherTaskListener;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GoogleApiAvailability;
//import com.google.android.material.snackbar.Snackbar;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class HomeFragment extends Fragment implements WeatherTaskListener {
//
//    private FragmentHomeBinding binding;
//    private static final String TAG = HomeFragment.class.getSimpleName();
//    private HomeViewModel homeViewModel;
//
//    private boolean mAlreadyStartedService = false;
//    private TextView mMsgView;
//
//    private TextView tvCurrentTemp;
//    private ImageView ivWeatherIcon;
//
//    //Web URL of the JSON file
//    private String mApiKey = "82599e4fceeb909c83edfbd1879cb303";
//    private String mCity = "Dublin";
//    private String mCountry = "IE";
//    String weatherURL;
//
//    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
//
//    String currentDay, currentMonth, currentDate;
//    ListView lvInfo;
//    ArrayList<String> information;
//
//    View root;
//
//    Boolean switched = false;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
////        binding = ActivityMainBinding.inflate(inflater);
////        View view = binding.getRoot();
////        root = inflater.inflate(R.layout.view, container, false);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//
//
//        final TextView tvCurrentDay = binding.getRoot().findViewById(R.id.tvCurrentDay);
//        lvInfo = binding.getRoot().findViewById(R.id.lvInfo);
//        tvCurrentTemp = binding.getRoot().findViewById(R.id.tvCurrentTemp);
//        ivWeatherIcon = binding.getRoot().findViewById(R.id.ivWeatherIcon);
//
//        LocalBroadcastManager.getInstance(getContext()).registerReceiver(
//                new BroadcastReceiver() {
//                    @Override
//                    public void onReceive(Context context, Intent intent) {
//                        String latitude = intent.getStringExtra(LocationMonitoringService.EXTRA_LATITUDE);
//                        String longitude = intent.getStringExtra(LocationMonitoringService.EXTRA_LONGITUDE);
//
//                        Log.d("weatherURL", "Weather URL" + weatherURL);
//
//                        if (latitude != null && longitude != null) {
//                            mMsgView.setText(getString(R.string.msg_location_service_started) + "\n Latitude : " + latitude + "\n Longitude: " + longitude);
////                            weatherURL = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + latitude + "&lon=" + longitude + "&limit=1&APPID=" + mApiKey;
//                            weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&limit=1&APPID=" + mApiKey;
//
////                            weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=51.5072&lon=8.4756&limit=1&APPID=" + mApiKey;
//
//                            new WeatherTask(HomeFragment.this).execute(weatherURL);
//
////                            Log.d("weatherURL", "Weather URL" + weatherURL);
//
//                        }
//                    }
//                }, new IntentFilter(LocationMonitoringService.ACTION_LOCATION_BROADCAST)
//        );
//
//        Log.d("weatherURL", "Weather URL" + weatherURL);
//
//        new WeatherTask(HomeFragment.this).execute(weatherURL);
//
//        final Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                new WeatherTask(HomeFragment.this).execute(weatherURL);
//                Toast.makeText(getContext(), "Weather Task Completed" + weatherURL, Toast.LENGTH_LONG).show();
//            }
//        }, 1000);
//
//
////        final TextView textView = root.findViewById(R.id.text_home);
////        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
////        });
//
//        Toast.makeText(getContext(), "Working? :", Toast.LENGTH_LONG).show();
//
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_WEEK);
//        int month = calendar.get(Calendar.MONTH);
//        int date = calendar.get(Calendar.DATE);
//        int year = calendar.get(Calendar.YEAR);
//
//
//        SetDate(day, month, date);
//
//        tvCurrentDay.setText(currentDay + " " + currentMonth + " " + currentDate + " " + year);
//
//        information = new ArrayList<String>();
//
//        getInfo();
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, information);
//        lvInfo.setAdapter(arrayAdapter);
//
//        lvInfo.setOnTouchListener(new ListView.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        // Disallow ScrollView to intercept touch events.
//                        v.getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        // Allow ScrollView to intercept touch events.
//                        v.getParent().requestDisallowInterceptTouchEvent(false);
//                        break;
//                }
//
//                // Handle ListView touch events.
//                v.onTouchEvent(event);
//                return true;
//            }
//        });
//        lvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedInfo = information.get(position);
//                Toast.makeText(getContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
//                if(selectedInfo == "Depression") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/clinical-depression/clinical-depression-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Anxiety") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/anxiety.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Panic Attack") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/how-to-deal-with-panic-attacks.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Social Anxiety") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/social-anxiety-social-phobia.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Generalised Anxiety Disorder in Adults") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/generalised-anxiety-disorder-in-adults/generalised-anxiety-disorder-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Postnatal Depression") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/postnatal-depression/postnatal-depression.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Insomnia") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/insomnia.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Self-Harm") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/self-harm/self-harm-types-and-signs.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Phobias") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/phobias/phobias-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Eating Disorders") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/eating-disorders.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Depression in Children and Teenagers") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/wellbeing/mental-health/depression-in-children-and-teenagers.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Alcohol and Mental Health") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/wellbeing/alcohol/mental-health/how-alcohol-affects-your-mental-health.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Bipolar Disorder") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/bipolar-disorder/bipolar-disorder-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Seasonal Affective Disorder (SAD)") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/seasonal-affective-disorder/seasonal-affective-disorder-sad-treatment.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
//
//            }
//        });
//
//        Button btn_TellUs = (Button) binding.getRoot().findViewById(R.id.btnTellUs);
//
//        btn_TellUs.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
//                // set title
//                alertDialogBuilder.setTitle("Word Analysis");
//                // set dialog message
//                alertDialogBuilder
//                        .setMessage("By answering how you are, we can analyse your response, and suggest distractions. Are you alright with this?")
//                        .setCancelable(false)
//                        .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog,int id) {
//                                Intent intent = new Intent();
//                                intent.setClass(getActivity(), MeasureEmotionActivity.class);
//                                getActivity().startActivity(intent);
//                            }
//                        })
//                        .setNegativeButton("No, I'll choose myself.",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog,int id) {
//                                final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                                ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
//                                ft.addToBackStack(null);
//                                ft.commit();
//                            }
//                        });
//
//                // create alert dialog
//                AlertDialog alertDialog = alertDialogBuilder.create();
//
//                // show it
//                alertDialog.show();
//            }
//        });
//
//        Button btn_StraightDistractions = (Button) binding.getRoot().findViewById(R.id.btnStraightDistractions);
//
//        btn_StraightDistractions.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });
//
//        switched=((MainActivity)getContext()).getSwitched();
//        if(switched) {
//            final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//            ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
//            ft.addToBackStack(null);
//            ft.commit();
//        }
//
//        switched = false;
//        return binding.getRoot();
//    }
//
//    public void onActivityCreated (Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            Boolean i = bundle.getBoolean("switched", switched);
//            String checkSwitched = switched.toString();
//            Toast.makeText(getContext(), "Switched Status : " + checkSwitched, Toast.LENGTH_LONG).show();
//
//        }
//
//        if (switched == true) {
//            Fragment newFragment = new DistractionsFragment();
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//            transaction.replace(R.id.fragment_container_view_tag, newFragment);
//            transaction.addToBackStack(null);
//
//            transaction.commit();
//        }
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        startStep1();
//    }
//
//
//    /**
//     * Step 1: Check Google Play services
//     */
//    private void startStep1() {
//
//        //Check whether this user has installed Google play service which is being used by Location updates.
//        if (isGooglePlayServicesAvailable()) {
//
//            //Passing null to indicate that it is executing for the first time.
//            startStep2(null);
//
//        } else {
//            Toast.makeText(getContext(), R.string.no_google_playservice_available, Toast.LENGTH_LONG).show();
//        }
//    }
//
//
//    /**
//     * Step 2: Check & Prompt Internet connection
//     */
//    private Boolean startStep2(DialogInterface dialog) {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//
//        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
//            promptInternetConnect();
//            return false;
//        }
//
//
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//
//        //Yes there is active internet connection. Next check Location is granted by user or not.
//
//        if (checkPermissions()) { //Yes permissions are granted by the user. Go to the next step.
//            startStep3();
//        } else {  //No user has not granted the permissions yet. Request now.
//            requestPermissions();
//        }
//        return true;
//    }
//
//    /**
//     * Show A Dialog with button to refresh the internet state.
//     */
//    private void promptInternetConnect() {
//        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getContext());
//        builder.setTitle(R.string.title_alert_no_intenet);
//        builder.setMessage(R.string.msg_alert_no_internet);
//
//        String positiveText = getString(R.string.btn_label_refresh);
//        builder.setPositiveButton(positiveText,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                        //Block the Application Execution until user grants the permissions
//                        if (startStep2(dialog)) {
//
//                            //Now make sure about location permission.
//                            if (checkPermissions()) {
//
//                                //Step 2: Start the Location Monitor Service
//                                //Everything is there to start the service.
//                                startStep3();
//                            } else if (!checkPermissions()) {
//                                requestPermissions();
//                            }
//
//                        }
//                    }
//                });
//
//        androidx.appcompat.app.AlertDialog dialog = builder.create();
//        dialog.show();
//    }
//
//    /**
//     * Step 3: Start the Location Monitor Service
//     */
//    private void startStep3() {
//
//        //And it will be keep running until you close the entire application from task manager.
//        //This method will executed only once.
//
//        if (!mAlreadyStartedService && mMsgView != null) {
//
//            mMsgView.setText(R.string.msg_location_service_started);
//
//            //Start location sharing service to app server.........
//            Intent intent = new Intent(getContext(), LocationMonitoringService.class);
//            getActivity().startService(intent);
//
//            mAlreadyStartedService = true;
//            //Ends................................................
//        }
//    }
//
//    /**
//     * Return the availability of GooglePlayServices
//     */
//    public boolean isGooglePlayServicesAvailable() {
//        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
//        int status = googleApiAvailability.isGooglePlayServicesAvailable(getContext());
//        if (status != ConnectionResult.SUCCESS) {
//            if (googleApiAvailability.isUserResolvableError(status)) {
//                googleApiAvailability.getErrorDialog(this, status, 2404).show();
//            }
//            return false;
//        }
//        return true;
//    }
//
//
//    /**
//     * Return the current state of the permissions needed.
//     */
//    private boolean checkPermissions() {
//        int permissionState1 = ActivityCompat.checkSelfPermission(getContext(),
//                android.Manifest.permission.ACCESS_FINE_LOCATION);
//
//        int permissionState2 = ActivityCompat.checkSelfPermission(getContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION);
//
//        return permissionState1 == PackageManager.PERMISSION_GRANTED && permissionState2 == PackageManager.PERMISSION_GRANTED;
//
//    }
//
//    /**
//     * Start permissions requests.
//     */
//    private void requestPermissions() {
//
//        boolean shouldProvideRationale =
//                ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
//                        android.Manifest.permission.ACCESS_FINE_LOCATION);
//
//        boolean shouldProvideRationale2 =
//                ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
//                        Manifest.permission.ACCESS_COARSE_LOCATION);
//
//
//        // Provide an additional rationale to the img_user. This would happen if the img_user denied the
//        // request previously, but didn't check the "Don't ask again" checkbox.
//        if (shouldProvideRationale || shouldProvideRationale2) {
//            Log.i(TAG, "Displaying permission rationale to provide additional context.");
//            showSnackbar(R.string.permission_rationale,
//                    android.R.string.ok, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            // Request permission
//                            ActivityCompat.requestPermissions(getActivity(),
//                                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
//                                    REQUEST_PERMISSIONS_REQUEST_CODE);
//                        }
//                    });
//        } else {
//            Log.i(TAG, "Requesting permission");
//            // Request permission. It's possible this can be auto answered if device policy
//            // sets the permission in a given state or the img_user denied the permission
//            // previously and checked "Never ask again".
//            ActivityCompat.requestPermissions(getActivity(),
//                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
//                    REQUEST_PERMISSIONS_REQUEST_CODE);
//        }
//    }
//
//
//    /**
//     * Shows a {@link Snackbar}.
//     *
//     * @param mainTextStringId The id for the string resource for the Snackbar text.
//     * @param actionStringId   The text of the action item.
//     * @param listener         The listener associated with the Snackbar action.
//     */
//    private void showSnackbar(final int mainTextStringId, final int actionStringId,
//                              View.OnClickListener listener) {
//        Snackbar.make(
//                binding.getRoot().findViewById(android.R.id.content),
//                getString(mainTextStringId),
//                Snackbar.LENGTH_INDEFINITE)
//                .setAction(getString(actionStringId), listener).show();
//    }
//
//    /**
//     * Callback received when a permissions request has been completed.
//     */
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        Log.i(TAG, "onRequestPermissionResult");
//        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
//            if (grantResults.length <= 0) {
//                // If img_user interaction was interrupted, the permission request is cancelled and you
//                // receive empty arrays.
//                Log.i(TAG, "User interaction was cancelled.");
//            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                Log.i(TAG, "Permission granted, updates requested, starting location updates");
//                startStep3();
//
//            } else {
//                // Permission denied.
//
//                // Notify the img_user via a SnackBar that they have rejected a core permission for the
//                // app, which makes the Activity useless. In a real app, core permissions would
//                // typically be best requested during a welcome-screen flow.
//
//                // Additionally, it is important to remember that a permission might have been
//                // rejected without asking the img_user for permission (device policy or "Never ask
//                // again" prompts). Therefore, a img_user interface affordance is typically implemented
//                // when permissions are denied. Otherwise, your app could appear unresponsive to
//                // touches or interactions which have required permissions.
//                showSnackbar(R.string.permission_denied_explanation,
//                        R.string.settings, new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                // Build intent that displays the App settings screen.
//                                Intent intent = new Intent();
//                                intent.setAction(
//                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                                Uri uri = Uri.fromParts("package",
//                                        BuildConfig.APPLICATION_ID, null);
//                                intent.setData(uri);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(intent);
//                            }
//                        });
//            }
//        }
//    }
//
//
//    @Override
//    public void onDestroy() {
//
//
//        //Stop location sharing service to app server.........
//
//        getActivity().stopService(new Intent(getContext(), LocationMonitoringService.class));
//        mAlreadyStartedService = false;
//        //Ends................................................
//
//
//        super.onDestroy();
//    }
//
//    public void getInfo()
//    {
//        information.add("Depression");
//        information.add("Depression in Children and Teenagers");
//        information.add("Depression in Young People");
//        information.add("Anxiety");
//        information.add("Panic Attack");
//        information.add("Social Anxiety");
//        information.add("Generalised Anxiety Disorder in Adults");
//        information.add("Seasonal Affective Disorder (SAD)");
//        information.add("Bipolar Disorder");
//        information.add("Alcohol and Mental Health");
//        information.add("Eating Disorders");
//        information.add("Phobias");
//        information.add("Self-Harm");
//        information.add("Insomnia");
//        information.add("Postnatal Depression");
//
//
//    }
//
//    public void SetDate(int day, int month, int date) {
//        switch (day) {
//            case Calendar.MONDAY:
//                currentDay = "Monday";
//                break;
//            case Calendar.TUESDAY:
//                currentDay = "Tuesday";
//                break;
//            case Calendar.WEDNESDAY:
//                currentDay = "Wednesday";
//                break;
//            case Calendar.THURSDAY:
//                currentDay = "Thursday";
//                break;
//            case Calendar.FRIDAY:
//                currentDay = "Friday";
//                break;
//            case Calendar.SATURDAY:
//                currentDay = "Saturday";
//                break;
//            case Calendar.SUNDAY:
//                currentDay = "Sunday";
//                break;
//        }
//
//        switch (month) {
//            case Calendar.JANUARY:
//                currentMonth = "January";
//                break;
//            case Calendar.FEBRUARY:
//                currentMonth = "February";
//                break;
//            case Calendar.MARCH:
//                currentMonth = "March";
//                break;
//            case Calendar.APRIL:
//                currentMonth = "April";
//                break;
//            case Calendar.MAY:
//                currentMonth = "May";
//                break;
//            case Calendar.JUNE:
//                currentMonth = "June";
//                break;
//            case Calendar.JULY:
//                currentMonth = "July";
//                break;
//            case Calendar.AUGUST:
//                currentMonth = "August";
//                break;
//            case Calendar.SEPTEMBER:
//                currentMonth = "September";
//                break;
//            case Calendar.OCTOBER:
//                currentMonth = "October";
//                break;
//            case Calendar.NOVEMBER:
//                currentMonth = "November";
//                break;
//            case Calendar.DECEMBER:
//                currentMonth = "December";
//                break;
//
//        }
//
//        switch(date) {
//            case 1:
//            case 21:
//            case 31:
//                currentDate = date + "st";
//                break;
//            case 2:
//            case 22:
//                currentDate = date + "nd";
//                break;
//            case 3:
//            case 23:
//                currentDate = date + "rd";
//                break;
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
//            case 10:
//            case 11:
//            case 12:
//            case 13:
//            case 14:
//            case 15:
//            case 16:
//            case 17:
//            case 18:
//            case 19:
//            case 20:
//            case 24:
//            case 25:
//            case 27:
//            case 28:
//            case 29:
//            case 30:
//                currentDate = date + "th";
//                break;
//
//
//        }
//    }
//
//    @Override
//    public void onWeatherTaskPreExecute() {
//        binding.myLoadingLayout.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void onWeatherTaskPostExecute(Weather Weather) {
//        if (Weather != null)
//        {
////            binding.cityTextView.setText(mCity);
////            binding.countryTextView.setText(mCountry);
//
////            binding.weatherConditionTextView.setText(myWeather.getWeatherCondition());
////            binding.weatherDescriptionTextView.setText(myWeather.getWeatherDescription());
//
//            int temp = Math.round(Weather.getTemperature() - 273.15f);
//            String tempStr = String.valueOf(temp);
//            binding.tvCurrentTemp.setText(tempStr);
//
//            String imgUrl = "http://openweathermap.org/img/wn/" + Weather.getWeatherIconStr() + "@2x.png";
//
//            Glide.with(getContext())
//                    .asBitmap()
//                    .load(imgUrl)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
//                    .into(binding.ivWeatherIcon);
//        }
//        binding.myLoadingLayout.setVisibility(View.GONE);
//    }
//}













//package com.example.distractme.ui.home;
//
//import android.Manifest;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.pm.PackageManager;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.provider.Settings;
//import android.util.Log;
//import android.view.ContextThemeWrapper;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.core.app.ActivityCompat;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.lifecycle.ViewModelProviders;
//import androidx.localbroadcastmanager.content.LocalBroadcastManager;
//
//import com.android.volley.BuildConfig;
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.request.RequestOptions;
//import com.example.distractme.MainActivity;
//import com.example.distractme.R;
//import com.example.distractme.databinding.ActivityMainBinding;
//import com.example.distractme.databinding.FragmentHomeBinding;
//import com.example.distractme.ui.checkin.MeasureEmotionActivity;
//import com.example.distractme.ui.distractions.DistractionsFragment;
//import com.example.distractme.ui.services.LocationMonitoringService;
//import com.example.distractme.Weather;
//import com.example.distractme.ui.weather_data.WeatherTask;
//import com.example.distractme.ui.weather_data.WeatherTaskListener;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GoogleApiAvailability;
//import com.google.android.material.snackbar.Snackbar;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class HomeFragment extends Fragment implements WeatherTaskListener {
//
//    private FragmentHomeBinding binding;
//    private static final String TAG = HomeFragment.class.getSimpleName();
//    private HomeViewModel homeViewModel;
//
//    private boolean mAlreadyStartedService = false;
//    private TextView mMsgView;
//
//    private TextView tvCurrentTemp;
//    private ImageView ivWeatherIcon;
//
//    //Web URL of the JSON file
//    private String mApiKey = "82599e4fceeb909c83edfbd1879cb303";
//    private String mCity = "Dublin";
//    private String mCountry = "IE";
//    String weatherURL;
//
//    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
//
//    String currentDay, currentMonth, currentDate;
//    ListView lvInfo;
//    ArrayList<String> information;
//
//    View root;
//
//    Boolean switched = false;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
////        binding = ActivityMainBinding.inflate(inflater);
////        View view = binding.getRoot();
////        root = inflater.inflate(R.layout.view, container, false);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//
//
//        final TextView tvCurrentDay = binding.getRoot().findViewById(R.id.tvCurrentDay);
//        lvInfo = binding.getRoot().findViewById(R.id.lvInfo);
//        tvCurrentTemp = binding.getRoot().findViewById(R.id.tvCurrentTemp);
//        ivWeatherIcon = binding.getRoot().findViewById(R.id.ivWeatherIcon);
//
////        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(
////        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(
////                new BroadcastReceiver() {
////                    @Override
////                    public void onReceive(Context context, Intent intent) {
////                        String latitude = intent.getStringExtra(LocationMonitoringService.EXTRA_LATITUDE);
////                        String longitude = intent.getStringExtra(LocationMonitoringService.EXTRA_LONGITUDE);
////
////                        Log.d("weatherURL", "Weather URL" + weatherURL);
////                        Log.d("LatLon", "Lat + Lon" + latitude + longitude);
////
////                        if (latitude != null && longitude != null) {
////                            mMsgView.setText(getString(R.string.msg_location_service_started) + "\n Latitude : " + latitude + "\n Longitude: " + longitude);
//////                            weatherURL = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + latitude + "&lon=" + longitude + "&limit=1&APPID=" + mApiKey;
////                            weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&limit=1&APPID=" + mApiKey;
////
//////                            weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=51.5072&lon=8.4756&limit=1&APPID=" + mApiKey;
////
////                            new WeatherTask(HomeFragment.this).execute(weatherURL);
////
//////                            Log.d("weatherURL", "Weather URL" + weatherURL);
////
////                        }
////                    }
////                }, new IntentFilter(LocationMonitoringService.ACTION_LOCATION_BROADCAST)
////        );
////
//////        Log.d("weatherURL", "Weather URL" + weatherURL);
////
////        new WeatherTask(HomeFragment.this).execute(weatherURL);
////
////        final Handler handler = new Handler(Looper.getMainLooper());
////        handler.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                new WeatherTask(HomeFragment.this).execute(weatherURL);
////                Toast.makeText(getContext(), "Weather Task Completed" + weatherURL, Toast.LENGTH_LONG).show();
////            }
////        }, 1000);
//
//
////        final TextView textView = root.findViewById(R.id.text_home);
////        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
////        });
//
//        Toast.makeText(getContext(), "Working? :", Toast.LENGTH_LONG).show();
//
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_WEEK);
//        int month = calendar.get(Calendar.MONTH);
//        int date = calendar.get(Calendar.DATE);
//        int year = calendar.get(Calendar.YEAR);
//
//
//        SetDate(day, month, date);
//
//        tvCurrentDay.setText(currentDay + " " + currentMonth + " " + currentDate + " " + year);
//
//        information = new ArrayList<String>();
//
//        getInfo();
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, information);
//        lvInfo.setAdapter(arrayAdapter);
//
//        lvInfo.setOnTouchListener(new ListView.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        // Disallow ScrollView to intercept touch events.
//                        v.getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                        // Allow ScrollView to intercept touch events.
//                        v.getParent().requestDisallowInterceptTouchEvent(false);
//                        break;
//                }
//
//                // Handle ListView touch events.
//                v.onTouchEvent(event);
//                return true;
//            }
//        });
//        lvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedInfo = information.get(position);
//                Toast.makeText(getContext(), "Information Selected : "+ selectedInfo,   Toast.LENGTH_LONG).show();
//                if(selectedInfo == "Depression") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/clinical-depression/clinical-depression-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Anxiety") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/anxiety.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Panic Attack") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/how-to-deal-with-panic-attacks.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Social Anxiety") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/social-anxiety-social-phobia.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Generalised Anxiety Disorder in Adults") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/generalised-anxiety-disorder-in-adults/generalised-anxiety-disorder-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Postnatal Depression") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/postnatal-depression/postnatal-depression.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Insomnia") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/insomnia.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Self-Harm") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/self-harm/self-harm-types-and-signs.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Phobias") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/phobias/phobias-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Eating Disorders") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/eating-disorders.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Depression in Children and Teenagers") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/wellbeing/mental-health/depression-in-children-and-teenagers.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Alcohol and Mental Health") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/wellbeing/alcohol/mental-health/how-alcohol-affects-your-mental-health.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Bipolar Disorder") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/bipolar-disorder/bipolar-disorder-symptoms.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                } else if(selectedInfo == "Seasonal Affective Disorder (SAD)") {
//                    Uri uri = Uri.parse("https://www2.hse.ie/conditions/mental-health/seasonal-affective-disorder/seasonal-affective-disorder-sad-treatment.html"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }
//
//            }
//        });
//
//        Button btn_TellUs = (Button) binding.getRoot().findViewById(R.id.btnTellUs);
//
//        btn_TellUs.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AlertDialogCustom));
//                // set title
//                alertDialogBuilder.setTitle("Word Analysis");
//                // set dialog message
//                alertDialogBuilder
//                        .setMessage("By answering how you are, we can analyse your response, and suggest distractions. Are you alright with this?")
//                        .setCancelable(false)
//                        .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog,int id) {
//                                Intent intent = new Intent();
//                                intent.setClass(getActivity(), MeasureEmotionActivity.class);
//                                getActivity().startActivity(intent);
//                            }
//                        })
//                        .setNegativeButton("No, I'll choose myself.",new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog,int id) {
//                                final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                                ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
//                                ft.addToBackStack(null);
//                                ft.commit();
//                            }
//                        });
//
//                // create alert dialog
//                AlertDialog alertDialog = alertDialogBuilder.create();
//
//                // show it
//                alertDialog.show();
//            }
//        });
//
//        Button btn_StraightDistractions = (Button) binding.getRoot().findViewById(R.id.btnStraightDistractions);
//
//        btn_StraightDistractions.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
//                ft.addToBackStack(null);
//                ft.commit();
//            }
//        });
//
//        switched=((MainActivity)getContext()).getSwitched();
//        if(switched) {
//            final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//            ft.replace(R.id.nav_host_fragment, new DistractionsFragment(), "NewFragmentTag");
//            ft.addToBackStack(null);
//            ft.commit();
//        }
//
//        switched = false;
//        return binding.getRoot();
//    }
//
//    public void onActivityCreated (Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            Boolean i = bundle.getBoolean("switched", switched);
//            String checkSwitched = switched.toString();
//            Toast.makeText(getContext(), "Switched Status : " + checkSwitched, Toast.LENGTH_LONG).show();
//
//        }
//
//        if (switched == true) {
//            Fragment newFragment = new DistractionsFragment();
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//            transaction.replace(R.id.fragment_container_view_tag, newFragment);
//            transaction.addToBackStack(null);
//
//            transaction.commit();
//        }
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        startStep1();
//    }
//
//
//    /**
//     * Step 1: Check Google Play services
//     */
//    private void startStep1() {
//
//        //Check whether this user has installed Google play service which is being used by Location updates.
//        if (isGooglePlayServicesAvailable()) {
//
//            //Passing null to indicate that it is executing for the first time.
//            startStep2(null);
//
//        } else {
//            Toast.makeText(getContext(), R.string.no_google_playservice_available, Toast.LENGTH_LONG).show();
//        }
//    }
//
//
//    /**
//     * Step 2: Check & Prompt Internet connection
//     */
//    private Boolean startStep2(DialogInterface dialog) {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//
//        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
//            promptInternetConnect();
//            return false;
//        }
//
//
//        if (dialog != null) {
//            dialog.dismiss();
//        }
//
//        //Yes there is active internet connection. Next check Location is granted by user or not.
//
//        if (checkPermissions()) { //Yes permissions are granted by the user. Go to the next step.
//            startStep3();
//        } else {  //No user has not granted the permissions yet. Request now.
//            requestPermissions();
//        }
//        return true;
//    }
//
//    /**
//     * Show A Dialog with button to refresh the internet state.
//     */
//    private void promptInternetConnect() {
//        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getContext());
//        builder.setTitle(R.string.title_alert_no_intenet);
//        builder.setMessage(R.string.msg_alert_no_internet);
//
//        String positiveText = getString(R.string.btn_label_refresh);
//        builder.setPositiveButton(positiveText,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                        //Block the Application Execution until user grants the permissions
//                        if (startStep2(dialog)) {
//
//                            //Now make sure about location permission.
//                            if (checkPermissions()) {
//
//                                //Step 2: Start the Location Monitor Service
//                                //Everything is there to start the service.
//                                startStep3();
//                            } else if (!checkPermissions()) {
//                                requestPermissions();
//                            }
//
//                        }
//                    }
//                });
//
//        androidx.appcompat.app.AlertDialog dialog = builder.create();
//        dialog.show();
//    }
//
//    /**
//     * Step 3: Start the Location Monitor Service
//     */
//    private void startStep3() {
//
//        //And it will be keep running until you close the entire application from task manager.
//        //This method will executed only once.
//
//        if (!mAlreadyStartedService && mMsgView != null) {
//
//            mMsgView.setText(R.string.msg_location_service_started);
//
//            //Start location sharing service to app server.........
//            Intent intent = new Intent(getContext(), LocationMonitoringService.class);
//            getActivity().startService(intent);
//            Toast.makeText(getContext(), "Lociation Started" + weatherURL, Toast.LENGTH_LONG).show();
//            Log.d("LOCATIONLOL", "Location Started");
//            mAlreadyStartedService = true;
//            //Ends................................................
//        }
//    }
//
//    /**
//     * Return the availability of GooglePlayServices
//     */
//    public boolean isGooglePlayServicesAvailable() {
//        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
//        int status = googleApiAvailability.isGooglePlayServicesAvailable(getContext());
//        if (status != ConnectionResult.SUCCESS) {
//            if (googleApiAvailability.isUserResolvableError(status)) {
//                googleApiAvailability.getErrorDialog(this, status, 2404).show();
//            }
//            return false;
//        }
//        return true;
//    }
//
//
//    /**
//     * Return the current state of the permissions needed.
//     */
//    private boolean checkPermissions() {
//        int permissionState1 = ActivityCompat.checkSelfPermission(getContext(),
//                android.Manifest.permission.ACCESS_FINE_LOCATION);
//
//        int permissionState2 = ActivityCompat.checkSelfPermission(getContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION);
//
//        return permissionState1 == PackageManager.PERMISSION_GRANTED && permissionState2 == PackageManager.PERMISSION_GRANTED;
//
//    }
//
//    /**
//     * Start permissions requests.
//     */
//    private void requestPermissions() {
//
//        boolean shouldProvideRationale =
//                ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
//                        android.Manifest.permission.ACCESS_FINE_LOCATION);
//
//        boolean shouldProvideRationale2 =
//                ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
//                        Manifest.permission.ACCESS_COARSE_LOCATION);
//
//
//        // Provide an additional rationale to the img_user. This would happen if the img_user denied the
//        // request previously, but didn't check the "Don't ask again" checkbox.
//        if (shouldProvideRationale || shouldProvideRationale2) {
//            Log.i(TAG, "Displaying permission rationale to provide additional context.");
//            showSnackbar(R.string.permission_rationale,
//                    android.R.string.ok, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            // Request permission
//                            ActivityCompat.requestPermissions(getActivity(),
//                                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
//                                    REQUEST_PERMISSIONS_REQUEST_CODE);
//                        }
//                    });
//        } else {
//            Log.i(TAG, "Requesting permission");
//            // Request permission. It's possible this can be auto answered if device policy
//            // sets the permission in a given state or the img_user denied the permission
//            // previously and checked "Never ask again".
//            ActivityCompat.requestPermissions(getActivity(),
//                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
//                    REQUEST_PERMISSIONS_REQUEST_CODE);
//        }
//    }
//
//
//    /**
//     * Shows a {@link Snackbar}.
//     *
//     * @param mainTextStringId The id for the string resource for the Snackbar text.
//     * @param actionStringId   The text of the action item.
//     * @param listener         The listener associated with the Snackbar action.
//     */
//    private void showSnackbar(final int mainTextStringId, final int actionStringId,
//                              View.OnClickListener listener) {
//        Snackbar.make(
//                binding.getRoot().findViewById(android.R.id.content),
//                getString(mainTextStringId),
//                Snackbar.LENGTH_INDEFINITE)
//                .setAction(getString(actionStringId), listener).show();
//    }
//
//    /**
//     * Callback received when a permissions request has been completed.
//     */
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        Log.i(TAG, "onRequestPermissionResult");
//        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
//            if (grantResults.length <= 0) {
//                // If img_user interaction was interrupted, the permission request is cancelled and you
//                // receive empty arrays.
//                Log.i(TAG, "User interaction was cancelled.");
//            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                Log.i(TAG, "Permission granted, updates requested, starting location updates");
//                startStep3();
//
//            } else {
//                // Permission denied.
//
//                // Notify the img_user via a SnackBar that they have rejected a core permission for the
//                // app, which makes the Activity useless. In a real app, core permissions would
//                // typically be best requested during a welcome-screen flow.
//
//                // Additionally, it is important to remember that a permission might have been
//                // rejected without asking the img_user for permission (device policy or "Never ask
//                // again" prompts). Therefore, a img_user interface affordance is typically implemented
//                // when permissions are denied. Otherwise, your app could appear unresponsive to
//                // touches or interactions which have required permissions.
//                showSnackbar(R.string.permission_denied_explanation,
//                        R.string.settings, new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                // Build intent that displays the App settings screen.
//                                Intent intent = new Intent();
//                                intent.setAction(
//                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                                Uri uri = Uri.fromParts("package",
//                                        BuildConfig.APPLICATION_ID, null);
//                                intent.setData(uri);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(intent);
//                            }
//                        });
//            }
//        }
//    }
//
//
//    @Override
//    public void onDestroy() {
//
//
//        //Stop location sharing service to app server.........
//
//        getActivity().stopService(new Intent(getContext(), LocationMonitoringService.class));
//        mAlreadyStartedService = false;
//        //Ends................................................
//
//
//        super.onDestroy();
//    }
//
//    public void getInfo()
//    {
//        information.add("Depression");
//        information.add("Depression in Children and Teenagers");
//        information.add("Depression in Young People");
//        information.add("Anxiety");
//        information.add("Panic Attack");
//        information.add("Social Anxiety");
//        information.add("Generalised Anxiety Disorder in Adults");
//        information.add("Seasonal Affective Disorder (SAD)");
//        information.add("Bipolar Disorder");
//        information.add("Alcohol and Mental Health");
//        information.add("Eating Disorders");
//        information.add("Phobias");
//        information.add("Self-Harm");
//        information.add("Insomnia");
//        information.add("Postnatal Depression");
//
//
//    }
//
//    public void SetDate(int day, int month, int date) {
//        switch (day) {
//            case Calendar.MONDAY:
//                currentDay = "Monday";
//                break;
//            case Calendar.TUESDAY:
//                currentDay = "Tuesday";
//                break;
//            case Calendar.WEDNESDAY:
//                currentDay = "Wednesday";
//                break;
//            case Calendar.THURSDAY:
//                currentDay = "Thursday";
//                break;
//            case Calendar.FRIDAY:
//                currentDay = "Friday";
//                break;
//            case Calendar.SATURDAY:
//                currentDay = "Saturday";
//                break;
//            case Calendar.SUNDAY:
//                currentDay = "Sunday";
//                break;
//        }
//
//        switch (month) {
//            case Calendar.JANUARY:
//                currentMonth = "January";
//                break;
//            case Calendar.FEBRUARY:
//                currentMonth = "February";
//                break;
//            case Calendar.MARCH:
//                currentMonth = "March";
//                break;
//            case Calendar.APRIL:
//                currentMonth = "April";
//                break;
//            case Calendar.MAY:
//                currentMonth = "May";
//                break;
//            case Calendar.JUNE:
//                currentMonth = "June";
//                break;
//            case Calendar.JULY:
//                currentMonth = "July";
//                break;
//            case Calendar.AUGUST:
//                currentMonth = "August";
//                break;
//            case Calendar.SEPTEMBER:
//                currentMonth = "September";
//                break;
//            case Calendar.OCTOBER:
//                currentMonth = "October";
//                break;
//            case Calendar.NOVEMBER:
//                currentMonth = "November";
//                break;
//            case Calendar.DECEMBER:
//                currentMonth = "December";
//                break;
//
//        }
//
//        switch(date) {
//            case 1:
//            case 21:
//            case 31:
//                currentDate = date + "st";
//                break;
//            case 2:
//            case 22:
//                currentDate = date + "nd";
//                break;
//            case 3:
//            case 23:
//                currentDate = date + "rd";
//                break;
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
//            case 10:
//            case 11:
//            case 12:
//            case 13:
//            case 14:
//            case 15:
//            case 16:
//            case 17:
//            case 18:
//            case 19:
//            case 20:
//            case 24:
//            case 25:
//            case 27:
//            case 28:
//            case 29:
//            case 30:
//                currentDate = date + "th";
//                break;
//
//
//        }
//    }
//
//    @Override
//    public void onWeatherTaskPreExecute() {
//        binding.myLoadingLayout.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void onWeatherTaskPostExecute(Weather Weather) {
//        if (Weather != null)
//        {
////            binding.cityTextView.setText(mCity);
////            binding.countryTextView.setText(mCountry);
//
////            binding.weatherConditionTextView.setText(myWeather.getWeatherCondition());
////            binding.weatherDescriptionTextView.setText(myWeather.getWeatherDescription());
//
//            int temp = Math.round(Weather.getTemperature() - 273.15f);
//            String tempStr = String.valueOf(temp);
//            binding.tvCurrentTemp.setText(tempStr);
//
//            String imgUrl = "http://openweathermap.org/img/wn/" + Weather.getWeatherIconStr() + "@2x.png";
//
//            Glide.with(getContext())
//                    .asBitmap()
//                    .load(imgUrl)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
//                    .into(binding.ivWeatherIcon);
//        }
//        binding.myLoadingLayout.setVisibility(View.GONE);
//    }
//}












package com.example.distractme.ui.home;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.android.volley.BuildConfig;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.databinding.FragmentHomeBinding;
import com.example.distractme.ui.checkin.MeasureEmotionActivity;
import com.example.distractme.ui.distractions.DistractionsFragment;
import com.example.distractme.ui.services.LocationMonitoringService;
import com.example.distractme.Weather;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.snackbar.Snackbar;

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

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

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

//    @Override
//    public void onWeatherTaskPreExecute() {
//        binding.myLoadingLayout.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void onWeatherTaskPostExecute(Weather Weather) {
//        if (Weather != null)
//        {
////            binding.cityTextView.setText(mCity);
////            binding.countryTextView.setText(mCountry);
//
////            binding.weatherConditionTextView.setText(myWeather.getWeatherCondition());
////            binding.weatherDescriptionTextView.setText(myWeather.getWeatherDescription());
//
//            int temp = Math.round(Weather.getTemperature() - 273.15f);
//            String tempStr = String.valueOf(temp);
//            binding.tvCurrentTemp.setText(tempStr);
//
//            String imgUrl = "http://openweathermap.org/img/wn/" + Weather.getWeatherIconStr() + "@2x.png";
//
//            Glide.with(getContext())
//                    .asBitmap()
//                    .load(imgUrl)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
//                    .into(binding.ivWeatherIcon);
//        }
//        binding.myLoadingLayout.setVisibility(View.GONE);
//    }
}