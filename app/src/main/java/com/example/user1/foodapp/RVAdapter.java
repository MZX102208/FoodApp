package com.example.user1.foodapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.GroupViewHolder>  {

    public static List<Group> groups;
    Context context;

    RecyclerView mRecyclerView;

    public RVAdapter(List<Group> groups, Context con){
        this.groups = groups;
        context = con;
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }


    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_card_layout, viewGroup, false);
        return new GroupViewHolder(viewGroup.getContext(), v);
    }

        @Override
    public void onBindViewHolder(GroupViewHolder groupViewHolder, final int i) {
        groupViewHolder.groupname.setText(groups.get(i).getName());
        String s = "";
        List<User> users = groups.get(i).getPeople();
        for(int j = 0; j<users.size();j++){
            s+= users.get(j);
            s+=" ,";
        }
        groupViewHolder.people.setText(s);
            DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy");
            int x = (int)(Math.random()*40);
            groupViewHolder.time.setText(x+" days ago");
        groupViewHolder.score.setText(groups.get(i).getScore()+"");

       Picasso.with(this.context).load("https://graph.facebook.com/"+groups.get(i).getPhoto()+"/picture?type=large").into(groupViewHolder.groupPhoto);

    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context mContext;
        CardView cv;
        TextView groupname;
        TextView people;
        TextView time;
        TextView score;
        ImageView groupPhoto;


        GroupViewHolder(Context context, View itemView) {
            super(itemView);
            mContext = context;
            cv = itemView.findViewById(R.id.cv);
            groupname = itemView.findViewById(R.id.group_name);
            time = itemView.findViewById(R.id.lasttimeate);
            people = itemView.findViewById(R.id.peopleingroup);
            score = itemView.findViewById(R.id.foodiescore);
            groupPhoto = itemView.findViewById(R.id.group_photo);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Group g = groups.get(position);
                Intent intent = new Intent(mContext,GroupInfoActivity.class);
                intent.putExtra("group",g);
                mContext.startActivity(intent);

            }
        }
    }


}
