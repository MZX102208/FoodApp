package com.example.user1.foodapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by SriramHariharan on 2/24/18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.GroupViewHolder>  {

    ArrayList<Group> groups;
    Context context;
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int itemposition = mRecyclerView.getChildLayoutPosition(view);
            Toast.makeText(context,itemposition+"",Toast.LENGTH_SHORT);
        }
    };

    RecyclerView mRecyclerView;

    public RVAdapter(ArrayList<Group> groups, Context con){
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
        v.setOnClickListener(onClickListener);
        GroupViewHolder gv = new GroupViewHolder(v);
        return gv;
    }

        @Override
    public void onBindViewHolder(GroupViewHolder groupViewHolder, final int i) {
        groupViewHolder.groupname.setText(groups.get(i).getName());
        String s = "";
//        ArrayList<User> users = groups.get(i).getPeople();
//        for(User u : users){
//            s+= u.getName()+" ";
//        }
        //groupViewHolder.people.setText(s);
        //groupViewHolder.time.setText(groups.get(i).getEats().get(groups.get(i).getEats().size()).time());
        groupViewHolder.score.setText(groups.get(i).getScore()+"");

       Picasso.with(this.context).load("https://graph.facebook.com/"+groups.get(i).getPhoto()+"/picture?type=large").into(groupViewHolder.groupPhoto);

    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView groupname;
        TextView people;
        TextView time;
        TextView score;
        ImageView groupPhoto;


        GroupViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            groupname = (TextView) itemView.findViewById(R.id.group_name);
            time = (TextView) itemView.findViewById(R.id.lasttimeate);
            people = (TextView) itemView.findViewById(R.id.peopleingroup);
            score = (TextView) itemView.findViewById(R.id.foodiescore);
            groupPhoto = (ImageView) itemView.findViewById(R.id.group_photo);
        }

    }


}
