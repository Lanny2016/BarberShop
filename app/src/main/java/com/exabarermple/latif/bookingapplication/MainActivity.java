package com.exabarermple.latif.bookingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private Button customer_Button;
    private Button barber_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customer_Button = (Button) findViewById(R.id.CustomerButton);
        barber_Button = (Button) findViewById(R.id.barberButton);
        customer_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customerWindow = new Intent(MainActivity.this, Client.class);
                startActivity(customerWindow);
            }
        });
        barber_Button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent barberWindow = new Intent(MainActivity.this, Barber.class);
                startActivity(barberWindow);
            }
        });
        }

}
