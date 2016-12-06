package com.example.adrie.organizer;

import android.app.Application;

import java.util.Date;


/**
 * Created by adrie on 05/12/2016.
 */

public class Class  {
    private String mName;
    private String mProfessor;
    private int mHour;
    private int mMin;
    private String mLocation;
    private String mWeekDay;

    public Class(String name, String weekDay, String location, int min, int hour, String professor) {
        mName = name;
        mWeekDay = weekDay;
        mLocation = location;
        this.mMin = min;
        mHour = hour;
        mProfessor = professor;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int hour) {
        mHour = hour;
    }

    public int getMmin() {
        return mMin;
    }

    public void setMmin(int mmin) {
        this.mMin = mmin;
    }

    public String getProfessor() {
        return mProfessor;
    }

    public void setProfessor(String professor) {
        mProfessor = professor;
    }

    public String getWeekDay() {
        return mWeekDay;
    }

    public void setWeekDay(String weekDay) {
        mWeekDay = weekDay;
    }
}
