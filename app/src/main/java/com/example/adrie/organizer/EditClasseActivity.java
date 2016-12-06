package com.example.adrie.organizer;

import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditClasseActivity extends Activity {
    @BindViews({R.id.txtV_className, R.id.txtV_teacher, R.id.txtV_location})
    List<TextView> myTxtViews;
    @BindView(R.id.spinner_className)
    Spinner mySpinners;
    @BindView(R.id.editT_location)
    EditText classLocation;
    @BindView(R.id.timePicker)
    TimePicker mTimePicker;
    @BindView(R.id.editT_teacherName)
    EditText teacherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_classe);
        ButterKnife.bind(this);
        Intent i = getIntent();

        if (i.getBooleanExtra("STATUS", true) == false) {
            setViewsVisibility(true);
            fillSpinners();
        }

        //  TimetableInformation classes = (TimetableInformation) getApplication();
        //  myTxtViews.get(0).setText(classes.listClasse.get(i.getIntExtra("BOATO", 0)).getName());

    }

    @OnClick(R.id.bt_addClasse)
    public void AddClass(View view) {

    }

    @OnClick(R.id.bt_Save)
    public void SaveClass(View view) {
        Intent i = getIntent();
        TimetableInformation mTimetableInformation = (TimetableInformation) getApplication();
        Class savedClass = new Class(
                mySpinners.getSelectedItem().toString(),
                i.getStringExtra("DAY"),
                classLocation.getText().toString(),
                mTimePicker.getCurrentMinute(),
                mTimePicker.getCurrentHour(),
                teacherName.getText().toString());
        mTimetableInformation.addClass(savedClass);
    }

    public void fillSpinners() {
        TimetableInformation mTimetableInformation = (TimetableInformation) getApplication();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mTimetableInformation.classes);
        mySpinners.setAdapter(adapter);

    }

    public void setViewsVisibility(boolean v) {
        if (v == true) {
            findViewById(R.id.show_classInformation).setVisibility(View.INVISIBLE);
            findViewById(R.id.add_edit_layout).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.show_classInformation).setVisibility(View.VISIBLE);
            findViewById(R.id.add_edit_layout).setVisibility(View.INVISIBLE);
        }

    }
}
