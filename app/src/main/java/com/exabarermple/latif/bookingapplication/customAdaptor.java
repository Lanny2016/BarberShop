package com.exabarermple.latif.bookingapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdaptor extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] styles;
    private final int[] image;


    public customAdaptor(Activity context, int[]image, String[] styles) {
        super ( context, R.layout.customrow, styles );

        this.context = context;
        this.image = image;
        this.styles = styles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater ();
        View rowView = inflater.inflate ( R.layout.customrow, null, true );

        TextView txtTitle = (TextView) rowView.findViewById ( R.id.rowcontent );
        ImageView imageView = (ImageView) rowView.findViewById ( R.id.customImage );

        txtTitle.setText ( styles[position] );
        imageView.setImageResource ( image[position] );
        return rowView;
    };
}
