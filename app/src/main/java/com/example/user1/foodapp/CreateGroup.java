package com.example.user1.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.List;

public class CreateGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(this.getTitle());
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        EditText et = findViewById(R.id.restedit);
        TwoWayView lv = findViewById(R.id.twowaylistviewcreateevent);
        User users = new User("100002416901938");
        User user2 = new User("100005361492326");
        User user3 = new User("100000689692724");
        User user4 = new User("100001013126554");
        User user5 = new User("100004365584224");
        List<User> users1 = new ArrayList<>();
        users1.add(users);
        users1.add(user2);
        users1.add(user3);
        users1.add(user4);
        users1.add(user5);
        TextView tx = findViewById(R.id.thecode);
        tx.setText(MainActivity.getUser().hashCode()+"");
        lv.setAdapter(new GroupMemberAdapter(getApplicationContext(),users1));

    }
}
