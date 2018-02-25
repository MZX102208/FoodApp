package com.example.user1.foodapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;




public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        User user = new User("random","Sriram");
        final ImageView background = findViewById(R.id.backgroundprofile);
        final ImageView profilePic = findViewById(R.id.profile_picture);
        //Configure target for
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                background.setImageBitmap(BlurImage.fastblur(bitmap, 1f, 10));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                background.setImageResource(R.mipmap.ic_launcher);

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };


        Picasso.with(getApplicationContext()).load("https://graph.facebook.com/100005494119625/picture?type=large").into(profilePic);
        background.setTag(target);
        Picasso.with(this)
                .load("https://graph.facebook.com/100005494119625/picture?type=large")
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(target);


    }
}
