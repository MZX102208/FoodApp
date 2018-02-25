package com.example.user1.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SriramHariharan on 2/25/18.
 */


public class GroupMemberAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private List<User> fbids;

    public GroupMemberAdapter(Context context, List<User> per){
        this.context = context;
        this.fbids = per;
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

    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_item, null);
        }
        ImageView im = convertView.findViewById(R.id.group_member);
       String id = fbids.get(position).getPhotoId();
        Picasso.with(convertView.getContext())
                .load("https://graph.facebook.com/"+id+"/picture?type=large")
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(im);
        return convertView;
    }
    @Override
    public void onClick(View view) {

    }



}
