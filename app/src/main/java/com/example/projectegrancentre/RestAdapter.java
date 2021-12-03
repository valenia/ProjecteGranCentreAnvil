package com.example.projectegrancentre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RestAdapter extends ArrayAdapter<ClRestaurant>
{
    public RestAdapter(Context context, int resource, List<ClRestaurant> restList)
    {
        super(context,resource,restList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ClRestaurant restaurant = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rest_cell, parent, false);
        }

        TextView nameRest = (TextView) convertView.findViewById(R.id.rest_name);
        TextView descripRest = (TextView) convertView.findViewById(R.id.rest_descrip);
        ImageView imgRest = (ImageView) convertView.findViewById(R.id.rest_image);

        nameRest.setText(restaurant.getName());
        descripRest.setText(restaurant.getDescrip());
        imgRest.setImageResource(restaurant.getImg());

        return convertView;
    }
}
