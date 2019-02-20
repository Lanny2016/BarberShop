package com.exabarermple.latif.bookingapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class resiterActivity extends AppCompatActivity {
    EditText editTextNameText, editSurnameText, editDateTime, editTime, editTelText;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    int currentDay, currentMonth, currentYear, currentHour, currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_resiter );

        //TimePicker////////////////////////////////////////////

       final EditText editTime  = (EditText)findViewById ( R.id.ediTextTime);
        editTime.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog ( resiterActivity.this, new TimePickerDialog.OnTimeSetListener () {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                        editTime.setText(String.format("%d:%d", hourOfDay, minutes));

                    }
                }, currentHour,currentMinute,true );

                timePickerDialog.show ();
            }

        } );
        editDateTime = findViewById ( R.id.editTextdate );
        editDateTime.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance ();
                currentYear = cal.get ( Calendar.YEAR );
                currentMonth = cal.get ( Calendar.MONTH );
                currentDay = cal.get ( Calendar.DAY_OF_MONTH );

                DatePickerDialog datePickerDialog = new DatePickerDialog(resiterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                month += 1;

                                editDateTime.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();

            }

        });

    }
}
