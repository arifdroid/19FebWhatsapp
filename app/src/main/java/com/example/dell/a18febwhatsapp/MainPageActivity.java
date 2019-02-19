package com.example.dell.a18febwhatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainPageActivity extends AppCompatActivity {

    Button buttonSignOut;

    Button findUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

    findUserButton = findViewById(R.id.findUserButton);
    buttonSignOut =findViewById(R.id.buttonSignOut);
    //textView1 = findViewById(R.id.tess);

    buttonSignOut.setText("sign out");

    buttonSignOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(),LogInActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }
    });

    findUserButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

    }
}
