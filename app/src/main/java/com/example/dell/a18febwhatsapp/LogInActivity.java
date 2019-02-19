package com.example.dell.a18febwhatsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LogInActivity extends AppCompatActivity {

    private Button mButtonSignIn;
    private EditText editTextPhoneNumber, editTextCode;

    private TextView textViewMessage;

    // string of code send by firebase

    private String codeReceivedFromFirebase;

    // callback triggered after we push button

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        FirebaseApp.initializeApp(this);

        mButtonSignIn = findViewById(R.id.signInButton);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextCode = findViewById(R.id.editTextCode);

        textViewMessage = findViewById(R.id.textViewMessage);

        userIsLoggedIn();

        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(codeReceivedFromFirebase!=null ) { //initially this is null, once we re

                    verifyPhoneWithCode(codeReceivedFromFirebase, editTextCode.getText().toString());

                }

                //start phone number verification process
                else {
                    startPhoneVerification();
                }
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                textViewMessage.setText("log in automatically..");

                signInWithPhoneCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

                textViewMessage.setText("failed to log in after callbacks..");
                //Log.i("checkkk", e.printStackTrace());
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                codeReceivedFromFirebase =s;
                mButtonSignIn.setText("Sign In");




            }
        };




    }

    //1st step

    private void startPhoneVerification() {

        textViewMessage.setVisibility(View.VISIBLE);
        textViewMessage.setText("requesting code...");

        PhoneAuthProvider.getInstance().verifyPhoneNumber(

                editTextPhoneNumber.getText().toString(),
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks

        );


    }


    //2nd credential

    private void signInWithPhoneCredential(PhoneAuthCredential phoneAuthCredential) {

        // add listener

        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    userIsLoggedIn();
                }
            }
        });






    }
    // 3rd
    private void userIsLoggedIn() {

        textViewMessage.setText("we are logged in now.!");

        FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();

        if(user!=null){

            //start new activity

            Intent intent = new Intent(LogInActivity.this,MainPageActivity.class);
            startActivity(intent);
            finish();
            return;



        }

    }


    private void verifyPhoneWithCode(String codeReceivedFromFirebase_here, String code){

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeReceivedFromFirebase_here, code);

        signInWithPhoneCredential(credential);


    }

}
