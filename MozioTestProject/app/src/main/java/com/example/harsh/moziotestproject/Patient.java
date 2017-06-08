package com.example.harsh.moziotestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient extends AppCompatActivity {
    Switch one, two, three, four;
    int severityLevel;
    private DatabaseReference mDatabase;
    Button done;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Patient's data");

        // find all switches and buttons

        one = (Switch) findViewById(R.id.switch1);
        two = (Switch) findViewById(R.id.switch2);
        three = (Switch) findViewById(R.id.switch3);
        four = (Switch) findViewById(R.id.switch4);
        done=(Button)findViewById(R.id.button);
        skip=(TextView)findViewById(R.id.textView13);
        // get bundle from user login detail

        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(getIntent());
        GoogleSignInAccount acct = result.getSignInAccount();
        final String personName = acct.getDisplayName();
        final String personEmail = acct.getEmail();
        final String id=acct.getId();


        //initialize severity level

        severityLevel = 0;
        // Attach listeners to all switches to get state

        one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    one.setText(R.string.yes);
                    severityLevel = severityLevel + 1;
                } else {
                    one.setText(R.string.no);
                    severityLevel = severityLevel - 1;
                }
            }
        });
        two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    two.setText(R.string.yes);
                    severityLevel = severityLevel + 1;
                } else {
                    two.setText(R.string.no);
                    severityLevel = severityLevel - 1;
                }
            }
        });
        three.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    three.setText(R.string.yes);
                    severityLevel = severityLevel + 1;
                } else {
                    three.setText(R.string.no);
                    severityLevel = severityLevel - 1;
                }
            }
        });
        four.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    four.setText(R.string.yes);
                    severityLevel = severityLevel + 1;
                } else {
                    four.setText(R.string.no);
                    severityLevel = severityLevel - 1;
                }
            }
        });
        //attach listeners to buttons

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
                String currentDateandTime = sdf.format(new Date());
                PatientData patientData=new PatientData(personName,""+(severityLevel*25),currentDateandTime) ;
                String userId = mDatabase.push().getKey();

                mDatabase.child(id).setValue(patientData);

                Intent intent=new Intent(Patient.this,PatientIndividualConditionActivity.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Patient.this,PatientIndividualConditionActivity.class);
                startActivity(intent);
            }
        });

    }
}
