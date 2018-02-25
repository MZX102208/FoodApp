package com.example.user1.foodapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import org.lucasr.twowayview.TwoWayView;

public class GroupInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        Group g = (Group)intent.getSerializableExtra("group");
        Log.e("HELLO",g.getName());
        TwoWayView lv = findViewById(R.id.listview);
        lv.setAdapter(new GroupMemberAdapter(getApplicationContext(),g.getPeople()));
        ListView listView = findViewById(R.id.grouphistorylist);
        listView.setAdapter(new HistoryAdapter(getApplicationContext(),g.getmHistory()));
        FloatingActionButton bt = findViewById(R.id.addeventbutton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
