package com.example.dell.a18febwhatsapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.InsideHolder> {

    ArrayList<UserObject> userObjects;

    public UserListAdapter(ArrayList<UserObject> userObjects) {
        this.userObjects=userObjects;
    }

    @NonNull
    @Override
    public InsideHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout,viewGroup,false);

        //layout params

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);


        /////

        return new InsideHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull InsideHolder insideHolder, int i) {

        insideHolder.namee.setText(userObjects.get(i).getName());
        insideHolder.phonee.setText(userObjects.get(i).getPhone());


    }

    @Override
    public int getItemCount() {
        return userObjects.size();
    }


    //inside class
    public class InsideHolder extends RecyclerView.ViewHolder{

        public TextView namee,phonee;

        public InsideHolder(@NonNull View itemView) {
            super(itemView);

            namee = itemView.findViewById(R.id.textName);
            phonee = itemView.findViewById(R.id.textPhone);

        }
    }
}
