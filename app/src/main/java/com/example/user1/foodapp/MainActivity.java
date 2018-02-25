package com.example.user1.foodapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements GroupFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener{


    public static User currentinfo;
    private View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UserProfileTask userProfileTask = new UserProfileTask("sghsri");

        try {
            userProfileTask.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
//                Intent intent = new Intent(getApplicationContext(),.class);
//                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static User getUser(){
        return currentinfo;
    }

    public class UserProfileTask extends AsyncTask<Void, Void, String> {

        String userid;
        User u;
        UserProfileTask(String s) {
            userid = s;
        }


        @Override
        protected String doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                u =ClientUtility.createGroup(userid,"Test Group","100005494119625");
                if(u != null){

                    Log.e("Success","Success");
                    return "success";
                }
                else{
                    return "fail";
                }

            } catch (Exception e) {
                Log.e("THE ERROR",e.toString());
                return "Exception";
            }

        }


        @Override
        protected void onPostExecute(final String success) {
            if (success.equals("success")) {
                currentinfo = u;
                Fragment fragment = null;
                Class Home = GroupFragment.class;

                try {
                    fragment = (Fragment) Home.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                BottomBar bar = findViewById(R.id.bottomBar);
                fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();
                bar.setOnTabSelectListener(new OnTabSelectListener() {
                    @Override
                    public void onTabSelected(@IdRes int tabId) {
                        Fragment fragment = null;
                        Class fragmentClass;
                        switch (tabId) {
                            case R.id.tab_group:
                                fragmentClass = GroupFragment.class;
                                break;
                            case R.id.tab_profile:
                                fragmentClass = ProfileFragment.class;
                                break;
                            default:
                                fragmentClass = GroupFragment.class;
                        }
                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();

                    }
                });

            } else if (success.equals("Exception")) {
                Log.e("login", "EXCEPTION");
            } else if (success.equals("fail")) {
                Log.e("login", "FAIL");
            }
        }

        @Override
        protected void onCancelled() {

        }

    }
}
