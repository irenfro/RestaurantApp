package com.shireapps.ian.restaurantapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ian on 10/21/15.
 */
public class ListRestaurantAdapter extends ArrayAdapter<Restaurant> {
    private Activity activity;
    private ArrayList<Restaurant> r;
    private static LayoutInflater inflater = null;

    public ListRestaurantAdapter(Activity a, int textViewId, ArrayList<Restaurant> r) {
        super(a, textViewId, r);
        try {
            this.activity = a;
            this.r = r;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getCount() {
        return r.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return r.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.simple_list_item_3, null);
                holder = new ViewHolder();

                holder.name = (TextView) vi.findViewById(R.id.name);
                holder.dist = (TextView) vi.findViewById(R.id.distance);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.name.setText(r.get(position).getName());
            holder.dist.setText("" + r.get(position).getDist());


        } catch (Exception e) {


        }
        return vi;
    }
}
