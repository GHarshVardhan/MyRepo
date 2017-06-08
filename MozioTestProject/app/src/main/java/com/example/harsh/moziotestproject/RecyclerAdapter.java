package com.example.harsh.moziotestproject;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<PatientData> userList;
    private Context context;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView status,date;


        MyViewHolder(View view) {
            super(view);
            status = (TextView) view.findViewById(R.id.textView11);
            date = (TextView) view.findViewById(R.id.textView12);


        }
    }


    public RecyclerAdapter( ArrayList<PatientData> userList, Context context) {
        this.userList = userList;
        this.context = context;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PatientData user = userList.get(position);
        holder.date.setText(user.getSeverityLevel()+"%");
        holder.status.setText(user.getDateAndTime());


    }



    @Override
    public int getItemCount() {
        return userList.size();
    }
}
