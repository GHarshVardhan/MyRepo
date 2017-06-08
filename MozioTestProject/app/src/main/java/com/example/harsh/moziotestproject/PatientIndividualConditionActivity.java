package com.example.harsh.moziotestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PatientIndividualConditionActivity extends AppCompatActivity {
    private RecyclerView condition;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_individual_condition);
        condition = (RecyclerView) findViewById(R.id.condition);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        condition.setLayoutManager(mLayoutManager);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Patient's data");
        final ArrayList<PatientData> dataList = new ArrayList<>();
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataList, this);
        condition.setAdapter(recyclerAdapter);
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    PatientData post = postSnapshot.getValue(PatientData.class);
                    dataList.add(post);

                }
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
