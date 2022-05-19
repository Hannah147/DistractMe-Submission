package com.example.distractme.ui.other_resources;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.distractme.R;
import com.example.distractme.ui.authentication.GuestViewProfile;
import com.example.distractme.ui.authentication.ViewProfile;
import com.example.distractme.ui.emergencyhelplines.EmergencyHelplineActivity;
import com.example.distractme.ui.login.LoginActivity;
import com.example.distractme.ui.mentalhealthtest.OnlineMentalHealthTest;
import com.example.distractme.ui.model.Quote;
import com.example.distractme.ui.quote_data.QuoteAdapter;
import com.example.distractme.ui.quote_data.QuoteData;
import com.example.distractme.ui.quote_data.QuoteListAsync;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class OthersFragment extends Fragment {

    private OthersViewModel profileViewModel;
    Boolean guestLogin, guestProfile;
    private FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    private QuoteAdapter quoteAdapter;
    private ViewPager viewPager;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 10000;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(OthersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_others, container, false);

        quoteAdapter = new QuoteAdapter(getParentFragmentManager(), getFragments());

        viewPager = root.findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        Button btn_viewprofile = (Button) root.findViewById(R.id.btn_viewprofile);

        btn_viewprofile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                firebaseAuth = FirebaseAuth.getInstance();
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if(user!=null){
                            Intent intent = new Intent(getContext(), ViewProfile.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent();
                            intent.setClass(getActivity(), GuestViewProfile.class);
                            getActivity().startActivity(intent);

                        }


            }
        });

        Button btn_logout = (Button) root.findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        Button btn_testLinks = (Button) root.findViewById(R.id.btn_testlinks);

        btn_testLinks.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), OnlineMentalHealthTest.class);
                getActivity().startActivity(intent);
            }
        });

        Button btn_emergencyHelplines = (Button) root.findViewById(R.id.btn_EmergencyHelplines);

        btn_emergencyHelplines.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), EmergencyHelplineActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return root;
    }

    private List<Fragment> getFragments(){
        final List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsync() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for(int i = 0; i < quotes.size(); i++){
                    quote_fragment quoteFragment = quote_fragment.newInstance(
                            quotes.get(i).getText(),
                            quotes.get(i).getAuthor());

                    fragmentList.add(quoteFragment);
                }

                quoteAdapter.notifyDataSetChanged();
            }
        });

        return fragmentList;
    }
}