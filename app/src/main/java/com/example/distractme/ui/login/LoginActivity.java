package com.example.distractme.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.distractme.MainActivity;
import com.example.distractme.R;
import com.example.distractme.ui.authentication.Register;
import com.example.distractme.ui.consent.ConsentActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn,forgotTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    Boolean guestLogin;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String currentUserID;
    FirebaseDatabase database;
    FirebaseFirestore mStore;
    StorageReference storageReference;
    private DatabaseReference usersDatabase;
    Boolean consent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        guestLogin = false;
        mEmail = findViewById(R.id.etUserEmail);
        mPassword = findViewById(R.id.etUserPassword);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.btn_login);
        forgotTextLink = findViewById(R.id.forgotPassword);

//        FirebaseApp.initializeApp(this);
//
//        database = FirebaseDatabase.getInstance("https://distractme-39056-default-rtdb.europe-west1.firebasedatabase.app/");
//        mDatabase = database.getReference().child("users");
//
//        mAuth = FirebaseAuth.getInstance();
//        mStore = FirebaseFirestore.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();
//        currentUserID = mAuth.getCurrentUser().getUid();
//        if(mAuth != null) {
//            currentUserID = user.getUid();
//        } else{
//            Log.e("User", "not found...");
//        }
//        usersDatabase = FirebaseDatabase.getInstance().getReference().child("users");
//
////        getConsent();
////        consent = false;
////        if(!consent) {
//////            FragmentManager fragmentManager = getFragmentManager();
//////            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//////            ConsentFragment fragmentconsent = new ConsentFragment();
//////            fragmentTransaction.add(R.id.fragment_consent, fragmentconsent, "Consent");
//////            fragmentTransaction.commit();
////        }


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            guestLogin = false;
//                            if(consent) {
                                Intent intent = new Intent();
                                intent.putExtra("guestLogin", guestLogin);
                                intent.setClass(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
//                            }
//                            else {
//                                Intent intent = new Intent();
//                                intent.setClass(getApplicationContext(), ConsentActivity.class);
//                                startActivity(intent);
//                            }
                        }else {
                            Toast.makeText(LoginActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginActivity.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();

            }
        });

    }

    // press login button
    public void login(View view) {
    }

    // Method to proceed as a guest
    public void proceed(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        // set title
        alertDialogBuilder.setTitle("Proceed as Guest");
        // set dialog message
        alertDialogBuilder
                .setMessage("Are You Sure You Want To Proceed as a Guest?")
                .setCancelable(false)
                .setPositiveButton( "Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        guestLogin = true;
                        dialog.cancel();
                        Intent intent = new Intent();
                        intent.putExtra("guestLogin", guestLogin);
                        intent.setClass(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "Please Select a Different Method.", Toast.LENGTH_LONG).show();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

//    public Boolean getConsent() {
//        mDatabase.child(currentUserID).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                consent = (Boolean) snapshot.child("CONSENT").getValue(consent);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                throw error.toException(); // never ignore errors
//            }
//        });
//
//        return this.consent;
//    }

    public void toRegister(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Register.class);
        startActivity(intent);

    }
}
