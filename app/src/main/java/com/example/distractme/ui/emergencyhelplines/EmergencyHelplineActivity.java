package com.example.distractme.ui.emergencyhelplines;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.other_resources.OthersFragment;

public class EmergencyHelplineActivity extends AppCompatActivity {

    TextView tvHeading, tvBody;
    String TextHelplineHeading, TextHelplineBody, EmergencyNumbersHeading, EmergencyNumbersBody,SamaritansHeading, SamaritansBody, PietaHeading, PietaBody, ChildlineHeading, ChildlineBody, AwareHelplineHeading, AwareHelplineBody;
    Integer event;
    Button btn_choose_event, btn_choose_event_2, btn_choose_event_3, btn_emergencyHelplines;
    private OthersFragment OthersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_helpline);

        tvBody = findViewById(R.id.tvBody);
        tvHeading = findViewById(R.id.tvHeading);
        btn_choose_event = findViewById(R.id.btn_open);
        btn_choose_event_2 = findViewById(R.id.btn_open_2);
        btn_choose_event_3 = findViewById(R.id.btn_open_3);
        btn_emergencyHelplines = findViewById(R.id.btn_EmergencyServices);

        tvHeading.setVisibility(View.INVISIBLE);
        tvBody.setVisibility(View.INVISIBLE);

        btn_choose_event.setVisibility(View.INVISIBLE);
        btn_choose_event_2.setVisibility(View.INVISIBLE);
        btn_choose_event_3.setVisibility(View.INVISIBLE);

        showEmergencyNumbers();


    }

//    @Override
//    protected void onNewIntent(Intent intent){
//        super.onNewIntent(intent);
//        btn_emergencyHelplines = findViewById(R.id.btn_EmergencyServices);
//        Boolean emergency = intent.getExtras().getBoolean("emergency");
//            if(emergency) {
//                btn_emergencyHelplines.performClick();
//                btn_emergencyHelplines.setPressed(true);
//            }
//
//    }



    public void showTextHelpline(View view) {
        TextHelplineHeading = "Text About It - 50808";
        TextHelplineBody = "50808 is a free, anonymous, 24/7 messaging service providing everything from a calming chat to immediate support. " +
                "50808 provides a safe space where you’re listened to by a trained Volunteer. You’ll message back and forth, only sharing what you feel comfortable with. " +
                "By asking questions, listening to you and responding with support, they will help you sort through your feelings until you both feel you are now in a calm, safe place.";

        tvBody.setText(TextHelplineBody);
        tvHeading.setText(TextHelplineHeading);
        btn_choose_event.setText("Text 50808");

        btn_choose_event_2.setVisibility(View.INVISIBLE);
        btn_choose_event_3.setVisibility(View.INVISIBLE);
        tvHeading.setVisibility(View.VISIBLE);
        tvBody.setVisibility(View.VISIBLE);
        btn_choose_event.setVisibility(View.VISIBLE);

        event = 1;

    }

    public void showEmergencyNumbers() {
        EmergencyNumbersHeading = "Telephone Emergency Services";
        EmergencyNumbersBody = "Are you in need of emergency help?" +
                "Please call either 999 or 112.";

        tvHeading.setText(EmergencyNumbersHeading);
        tvBody.setText(EmergencyNumbersBody);
        btn_choose_event.setText("Call 999");
        btn_choose_event_2.setText("Call 112");
        btn_choose_event_3.setText("Text 999");

        tvHeading.setVisibility(View.VISIBLE);
        tvBody.setVisibility(View.VISIBLE);
        btn_choose_event.setVisibility(View.VISIBLE);
        btn_choose_event_2.setVisibility(View.VISIBLE);
        btn_choose_event_3.setVisibility(View.VISIBLE);

        event = 2;

    }

    public void showSamaritans(View view) {
        SamaritansBody = "Every 10 seconds, Samaritans responds to a call for help. Samaritans is the only charity in Ireland offering emotional support 24 hours a day, 365 days a year, " +
                "to anyone who is in distress, lonely, struggling to cope or feeling suicidal. For confidential, non-judgemental support: \nFreephone 116 123, \nEmail jo@samaritans.ie,\nOr visit your nearest branch.";
        SamaritansHeading = "Samaritans";

        tvBody.setText(SamaritansBody);
        tvHeading.setText(SamaritansHeading);

        btn_choose_event_3.setVisibility(View.INVISIBLE);
        tvHeading.setVisibility(View.VISIBLE);
        tvBody.setVisibility(View.VISIBLE);
        btn_choose_event.setVisibility(View.VISIBLE);
        btn_choose_event_2.setVisibility(View.VISIBLE);

        btn_choose_event.setText("Call 116 123");
        btn_choose_event_2.setText("Email");

        event = 3;

    }

    public void showPieta(View view) {
        PietaBody = "Pieta provides a professional one-to-one therapeutic service to people who are in suicidal distress, those who engage in self-harm, " +
                "and those bereaved by suicide. All of their services are provided free of charge and no referral is needed.\nYou can call for free on 1800 247 247 or text HELP to 51444";
        PietaHeading = "Pieta";

        tvBody.setText(PietaBody);
        tvHeading.setText(PietaHeading);

        btn_choose_event_2.setVisibility(View.INVISIBLE);
        tvHeading.setVisibility(View.VISIBLE);
        tvBody.setVisibility(View.VISIBLE);
        btn_choose_event.setVisibility(View.VISIBLE);
        btn_choose_event_3.setVisibility(View.VISIBLE);

        btn_choose_event.setText("Call 1800 247 247");
        btn_choose_event_3.setText("Text HELP to 51444");

        event = 4;
    }

    public void showAwareHelpline(View view) {
        AwareHelplineBody = "The Aware Support Line service is a free service and is available to anyone, aged 18 years and over, who is seeking support and information about issues relating to their own mood or " +
                "the mood of a friend or family member, or who experiences depression, anxiety or bipolar disorder. You can call for free on 1800 80 48 48, 7 days a week.";
        AwareHelplineHeading = "Aware";

        tvBody.setText(AwareHelplineBody);
        tvHeading.setText(AwareHelplineHeading);

        btn_choose_event_3.setVisibility(View.INVISIBLE);
        btn_choose_event_2.setVisibility(View.INVISIBLE);
        tvHeading.setVisibility(View.VISIBLE);
        tvBody.setVisibility(View.VISIBLE);
        btn_choose_event.setVisibility(View.VISIBLE);

        btn_choose_event.setText("Call 1800 80 48 48");

        event = 5;

    }

    public void showChildline(View view) {
        ChildlineBody = "If you are under 18 you can talk with Childline in confidence, about anything that might be on your mind by phone, web chat or text. You can call for free on 1800 66 6666 or text HELP to 50101";
        ChildlineHeading = "Childline";

        tvHeading.setText(ChildlineHeading);
        tvBody.setText(ChildlineBody);

        btn_choose_event_2.setVisibility(View.INVISIBLE);
        tvHeading.setVisibility(View.VISIBLE);
        tvBody.setVisibility(View.VISIBLE);
        btn_choose_event.setVisibility(View.VISIBLE);
        btn_choose_event_3.setVisibility(View.VISIBLE);

        btn_choose_event.setText("Call 1800 66 6666");
        btn_choose_event_3.setText("Text HELP to 50101");

        event = 6;
    }

    void openText (View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "50808", null)));
    }

    void openNumbers (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:999"));
        startActivity(intent);
    }

    void openNumbers2 (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:112"));
        startActivity(intent);
    }

    void openNumbers3 (View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "999", null)));
    }

    void openSamaritans (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:116 123"));
        startActivity(intent);
    }

    void openSamaritans2 (View view) {
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + "" + "&body=" + "" + "&to=" + "jo@samaritans.ie");
        testIntent.setData(data);
        startActivity(testIntent);
    }

    void openPieta (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1800 247 247"));
        startActivity(intent);
    }

    void openPieta2 (View view) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", "51444");
        smsIntent.putExtra("sms_body","HELP");
        startActivity(smsIntent);
    }

    void openChildline (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1800 66 6666"));
        startActivity(intent);

    }

    void openChildline2 (View view) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", "50101");
        smsIntent.putExtra("sms_body","HELP");
        startActivity(smsIntent);
    }

    void openAware (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:1800 80 48 48"));
        startActivity(intent);
    }

    // first button
    public void choose_event(View view) {
        if (event == 1) {
            openText(view);
        } else if(event == 2) {
            openNumbers(view);
        } else if(event == 3) {
            openSamaritans(view);
        } else if(event == 4) {
            openPieta(view);
        } else if(event == 6) {
            openChildline(view);
        } else if(event == 5) {
            openAware(view);
        }

    }

    // second button
    public void choose_event_2(View view) {
        if (event == 1) {
            openText(view);
        } else if(event == 2) {
            openNumbers2(view);
        } else if(event == 3) {
            openSamaritans2(view);
        } else if(event == 4) {
            openPieta(view);
        } else if(event == 6) {
            openChildline(view);
        } else if(event == 5) {
            openAware(view);
        }
    }

    // third button
    public void choose_event_3(View view) {
        if (event == 1) {
            openText(view);
        } else if(event == 2) {
            openNumbers3(view);
        } else if(event == 3) {
            openSamaritans(view);
        } else if(event == 4) {
            openPieta2(view);
        } else if(event == 6) {
            openChildline2(view);
        } else if(event == 5) {
            openAware(view);
        }
    }

    public void backToOthers(View view) {
        Integer fragment_load;
        fragment_load = 4;
        Intent i = new Intent(EmergencyHelplineActivity.this, MainActivity.class);
        i.putExtra("fragment_load", fragment_load);
        startActivity(i);
// Now start your activity
    }
}