package com.example.harsh.moziotestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IdentificationActivity extends AppCompatActivity {

    Button patientButton, physicianButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        patientButton=(Button)findViewById(R.id.button3);
        physicianButton=(Button)findViewById(R.id.button2);

        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdentificationActivity.this,PatientLogin.class);
                startActivity(intent);
            }
        });
        physicianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdentificationActivity.this,AllPatientData.class);
                startActivity(intent);
            }
        });

    }
}
