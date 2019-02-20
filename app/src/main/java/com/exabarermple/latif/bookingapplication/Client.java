package com.exabarermple.latif.bookingapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Client extends Activity {
    ListView list;
    ImageView callIcon;
    ImageView messageIcon;
    ImageView likeIcon;
    ImageView locationIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
// Array of strings...
        String[] styles = {"Sakal tıraş","Saç tıraş","Saç yıkama", "Maske","Kulak Ağda"};
        int[]image = {R.drawable.beard,R.drawable.hair,R.drawable.hairwash,R.drawable.mask,
        R.drawable.earwaxing};

        customAdaptor adapter = new customAdaptor(this,image,styles);
        list=(ListView)findViewById ( R.id.listView );
        list.setAdapter ( adapter );

        list.setOnItemClickListener (
                new AdapterView.OnItemClickListener () {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if (position==3){
                            Intent maskIntent = new Intent ( view.getContext (), maskActivity.class);
                            startActivity(maskIntent);

                        }
                    }
                }
        );

///////////// calling by icon////////

        callIcon = (ImageView) findViewById(R.id.call);
        callIcon.setOnClickListener ( new View.OnClickListener () {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData( Uri.parse("tel:054229698"));
                startActivity(callIntent);
            }
        } );

        ///////////// send message by icon ////////

        messageIcon = (ImageView) findViewById ( R.id.message );
        messageIcon.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("sms:054229698"));
                smsIntent.putExtra("sms_body", "Hello");
                startActivity(smsIntent);
            }
        } );

        ///////////// loving by icon ////////
          
        likeIcon = (ImageView) findViewById ( R.id.favorite );
        likeIcon.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        } );

    }
}