package com.exabarermple.latif.bookingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sacTiras extends AppCompatActivity {

    Button book;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sac_tiras );

        book = (Button) findViewById ( R.id.reserve );
        cancel = (Button) findViewById ( R.id.cancel );

        book.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent registeractivity = new Intent(sacTiras.this, resiterActivity.class);
                startActivity(registeractivity);
            }
        } );
        cancel.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent client = new Intent(sacTiras.this, Client.class);
                startActivity(client);

            }
        } );
    }
}
