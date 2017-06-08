package com.example.harsh.moziotestproject;

/**
 * Created by Harsh on 08-06-2017.
 */

public class PatientData {
    private String name;
    private String severityLevel;
    private String dateAndTime;

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


    public PatientData(String name, String severityLevel, String dateAndTime) {
        this.name = name;
        this.severityLevel = severityLevel;
        this.dateAndTime= dateAndTime;
    }

    public PatientData() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

}
