package com.exabarermple.latif.bookingapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class resiterActivity extends AppCompatActivity {
    EditText editTextName, editSurname, editDateTime, editTime, editTel;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    Api api;
    int currentDay, currentMonth, currentYear, currentHour, currentMinute;

    Button register, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_resiter );
        cancel = findViewById ( R.id.cancelbt);
        register = findViewById ( R.id.registerbt);
        register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                signUp();
            }
        } );
        cancel.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intentcancel = new Intent ( resiterActivity.this, Client.class );
                startActivity ( intentcancel );
            }
        } );

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
    public void signUp(){

        String name = editTextName.getText().toString().trim();
        String sur_name = editSurname.getText().toString().trim();
        String tel_phone = editTel.getText().toString().trim();
        String date =  editDateTime.getText().toString().trim();
        String time =  editTime.getText().toString().trim();



        Post contacts = new Post (name,sur_name,tel_phone,date,time,"2019-03-15T06:44:24.006Z",false);
        Call<Post> call = api.createOrder(contacts);

      call.enqueue ( new Callback<Post> () {
          @Override
          public void onResponse(Call<Post> call, Response<Post> response) {
              if (!response.isSuccessful()) {
                  Toast.makeText(resiterActivity.this, "Kayıt Başarsiz!!!", Toast.LENGTH_LONG).show();;;
                  return;
              }
              else if(response.isSuccessful ()){
                  Toast.makeText(resiterActivity.this, "Kayıt Başarlı!!!", Toast.LENGTH_LONG).show();;
              }
              Post postResponse = response.body();

              String content = "";
              content += "Code: " + response.code() + "\n";
              content += "name: " + postResponse.getName() + "\n";
              content += "surname: " + postResponse.getSurname () + "\n";
              content += "telephoneNumber: " + postResponse.getTelephoneNumber() + "\n";
              content += "date: " + postResponse.getDate() + "\n";
              content += "time: " + postResponse.getTime () + "\n";
              content += "rezervationDate: " + postResponse.getReservationDate () + "\n";
              content += "isActive: " + postResponse.isActive () + "\n\n";


          }

          @Override
          public void onFailure(Call<Post> call, Throwable t) {

              Toast.makeText(resiterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
          }

      } );

}
}
