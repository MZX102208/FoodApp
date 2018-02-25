package com.example.user1.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Spinner spinner = findViewById(R.id.spinnerwithin);
        String[] dist = {"1 mi","5 mi","10 mi","20 mi","30 mi"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,dist);
        spinner.setAdapter(arrayAdapter);

        Spinner spinner2 = findViewById(R.id.restrictions);
        String[] restrictions = {"None","Vegetarian","Vegan","Halal","Kosher"};
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,restrictions);
        spinner2.setAdapter(arrayAdapter2);

        ListView lv = findViewById(R.id.preferenceslistview);
        lv.setAdapter(new PreferencesAdapter(getApplicationContext(),Cuisine.initCategories()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
