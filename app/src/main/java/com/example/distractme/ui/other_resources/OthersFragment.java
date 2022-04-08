package com.example.distractme.ui.other_resources;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.distractme.R;
import com.example.distractme.ui.authentication.GuestViewProfile;
import com.example.distractme.ui.authentication.ViewProfile;
import com.example.distractme.ui.emergencyhelplines.EmergencyHelplineActivity;
import com.example.distractme.ui.login.LoginActivity;
import com.example.distractme.ui.mentalhealthtest.OnlineMentalHealthTest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

public class OthersFragment extends Fragment {

    private static final int GALLERY_INTENT_CODE = 1023 ;
    TextView fullName,email,verifyMsg;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button resendCode;
    Button resetPassLocal,changeProfileImage;
    FirebaseUser user;
    ImageView profileImage;
    StorageReference storageReference;
    private OthersViewModel profileViewModel;
    Boolean guestLogin, guestProfile;
    private FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(OthersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_others, container, false);

//        guestLogin = false;

//        Intent intentGuest = getActivity().getIntent();
//        guestLogin = intentGuest.getExtras().getBoolean("guestLogin");

//        if(guestLogin == true) {
//            guestProfile = true;
//        } else{
//            guestProfile = false;
//        }


        Button btn_viewprofile = (Button) root.findViewById(R.id.btn_viewprofile);

        btn_viewprofile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                if(guestProfile == false) {
//                    Intent intent = new Intent();
//                    intent.setClass(getActivity(), ViewProfile.class);
//                    getActivity().startActivity(intent);
//                }else {
//                    Intent intent = new Intent();
//                    intent.setClass(getActivity(), GuestViewProfile.class);
//                    getActivity().startActivity(intent);
//                }

                firebaseAuth = FirebaseAuth.getInstance();
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if(user!=null){
                            Intent intent = new Intent(getContext(), ViewProfile.class);
                            startActivity(intent);
//                            finish();
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
//                Intent intent = new Intent();
//                intent.setClass(getActivity(), ViewProfile.class);
//                getActivity().startActivity(intent);

                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getContext(), LoginActivity.class));
//                finish();

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
}