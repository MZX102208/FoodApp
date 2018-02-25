package com.example.user1.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SriramHariharan on 2/25/18.
 */

public class HistoryAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<PastEvent> fbids;
    private static LayoutInflater inflater = null;


    public HistoryAdapter(Context context, List<PastEvent> per){
        this.context = context;
        this.fbids = per;

        inflater = (LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return fbids.size();
    }
    public Object getItem(int position) {
        return fbids.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView name;
        TextView date;
        TextView with;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.history_item, null);
        PastEvent event = fbids.get(position);
        holder.name = rowView.findViewById(R.id.eventname);
        holder.date = rowView.findViewById(R.id.eventdate);
        holder.with = rowView.findViewById(R.id.whowith);
        holder.name.setText(fbids.get(position).getName());
        DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
        holder.date.setText(fbids.get(position).getDate().toString(fmt));
        String s = "";
        List<User> users = fbids.get(position).getParicipants();
        for(int i = 0; i<users.size();i++){
            s+=users.get(i).getName();
            if(i !=users.size()-1){
                s+=", ";
            }
        }
        holder.with.setText(s);
        return rowView;
    }

    @Override
    public void onClick(View view) {

    }



}