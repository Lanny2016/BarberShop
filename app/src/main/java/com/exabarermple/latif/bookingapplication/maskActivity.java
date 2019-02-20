package com.exabarermple.latif.bookingapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class maskActivity extends AppCompatActivity {
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_mask2 );
        book = (Button) findViewById ( R.id.reserve );

        book.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent registeractivity = new Intent(maskActivity.this, resiterActivity.class);
                startActivity(registeractivity);
            }
        } );








    }
}








