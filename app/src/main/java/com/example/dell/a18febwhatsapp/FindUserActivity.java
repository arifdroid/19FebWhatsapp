package com.example.dell.a18febwhatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class FindUserActivity extends AppCompatActivity {

    //initialize

    private RecyclerView mUserList;
    private RecyclerView.Adapter mUserListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        initializeRecyclerView();



    }

    private void initializeRecyclerView() {

        mUserList = findViewById(R.id.recyclerViewId);
        mUserList.setNestedScrollingEnabled(false);

    }
}
