package com.example.harsh.moziotestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AllPatientData extends AppCompatActivity {
    private RecyclerView record;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_patient_data);
        record = (RecyclerView) findViewById(R.id.record);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        record.setLayoutManager(mLayoutManager);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Patient's data");
        final ArrayList<PatientData> dataList = new ArrayList<>();
        final RecyclerRecordAdapter recyclerRecordAdapter = new RecyclerRecordAdapter(dataList, this);
        record.setAdapter(recyclerRecordAdapter);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    PatientData post = postSnapshot.getValue(PatientData.class);
                    dataList.add(post);

                }
                recyclerRecordAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
