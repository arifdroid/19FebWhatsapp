package com.example.dell.a18febwhatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FindUserActivity extends AppCompatActivity {

    //initialize

    private RecyclerView mUserList;
    private RecyclerView.Adapter mUserListAdapter;
    private RecyclerView.LayoutManager mUserListLayoutManager;

    ArrayList<UserObject> userLists= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        populateData();

        initializeRecyclerView();



    }

    private void initializeRecyclerView() {

        mUserList = findViewById(R.id.recyclerViewId);
        mUserList.setNestedScrollingEnabled(false);
        mUserList.setHasFixedSize(false);
        mUserListLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayout.VERTICAL,false);
        mUserList.setLayoutManager(mUserListLayoutManager);

        mUserListAdapter = new UserListAdapter(userLists);   //this is something, class is RecyclerView, but

        mUserList.setAdapter(mUserListAdapter);


    }

    private void populateData(){

        userLists.add(new UserObject("arif","018"));
        userLists.add(new UserObject("arif2","018"));
        userLists.add(new UserObject("arif3","018"));
        userLists.add(new UserObject("arif4","018"));
        userLists.add(new UserObject("arif5","018"));
        userLists.add(new UserObject("arif6","018"));
        userLists.add(new UserObject("arif7","018"));
        userLists.add(new UserObject("arif8","018"));
        userLists.add(new UserObject("arif9","018"));
        userLists.add(new UserObject("arif10","018"));
        userLists.add(new UserObject("arif11","018"));
        userLists.add(new UserObject("arif12","018"));
        userLists.add(new UserObject("arif13","018"));
        userLists.add(new UserObject("arif14","018"));
        userLists.add(new UserObject("arif15","018"));
        userLists.add(new UserObject("arif16","018"));
        userLists.add(new UserObject("arif17","018"));
        userLists.add(new UserObject("arif18","018"));
        userLists.add(new UserObject("arif19","018"));
        userLists.add(new UserObject("arif20","018"));
        userLists.add(new UserObject("arif21","018"));
        userLists.add(new UserObject("arif22","018"));
        userLists.add(new UserObject("arif23","018"));
        userLists.add(new UserObject("arif24","018"));
        userLists.add(new UserObject("arif25","018"));

    }
}
