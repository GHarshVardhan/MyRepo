package com.example.harsh.moziotestproject;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

class RecyclerRecordAdapter extends RecyclerView.Adapter<RecyclerRecordAdapter.MyViewHolder> {

    private List<PatientData> userList;
    private Context context;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView status,date,name;


        MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView11);
            date = (TextView) view.findViewById(R.id.textView12);
            status = (TextView) view.findViewById(R.id.textView13);


        }
    }


    public RecyclerRecordAdapter( List<PatientData> userList, Context context) {
        this.userList = userList;
        this.context = context;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.record_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PatientData user = userList.get(position);
        holder.date.setText(user.getSeverityLevel()+"%");
        holder.status.setText(user.getDateAndTime());
        holder.name.setText(user.getName());


    }



    @Override
    public int getItemCount() {
        return userList.size();
    }
}