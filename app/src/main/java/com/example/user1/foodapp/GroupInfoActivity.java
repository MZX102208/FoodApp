package com.example.user1.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.lucasr.twowayview.TwoWayView;

public class GroupInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Group g = (Group)intent.getSerializableExtra("group");
        Log.e("HELLO",g.getName());
        TwoWayView lv = findViewById(R.id.listview);
        lv.setAdapter(new GroupMemberAdapter(getApplicationContext(),g.getPeople()));
    }
}
