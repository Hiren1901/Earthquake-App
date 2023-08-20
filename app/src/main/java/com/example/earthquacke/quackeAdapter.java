package com.example.earthquacke;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class quackeAdapter extends ArrayAdapter {
    ArrayList<quackeinfo> b;

    public quackeAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, 0, (List) objects);
        this.b=objects;
    }

    @Nullable
    @Override
    public quackeinfo getItem(int position) {
        return b.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;

        view= LayoutInflater.from(getContext()).inflate(R.layout.m,parent,false);

        TextView t1=view.findViewById(R.id.textView);
        TextView t2=view.findViewById(R.id.textView2);
        TextView t3=view.findViewById(R.id.textView3);
        TextView t4=view.findViewById(R.id.textView10);
        TextView t5=view.findViewById(R.id.textView4);
        t1.setText(String.valueOf(getItem(position).getMagnitude()));
        t2.setText(getItem(position).getLocation());
        t5.setText(getItem(position).getLocation1());
        t3.setText(String.valueOf( getItem(position).getDate()));
        t4.setText(getItem(position).getTime());
        GradientDrawable magnitudeCircle = (GradientDrawable) t1.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(getItem(position).getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return  view;
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
