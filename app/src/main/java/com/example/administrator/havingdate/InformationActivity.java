package com.example.administrator.havingdate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/9/19 0019.
 */

public class InformationActivity extends AppCompatActivity{
    public static final String INFORMATION_NAME="information_name";

    public static final String INFORMATION_IMAGE_ID="information_image_id";

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_information);


    Intent intent =getIntent();
    String informationName = intent.getStringExtra(INFORMATION_NAME);
    int informationImageId = intent.getIntExtra(INFORMATION_IMAGE_ID,0);
    String articleImageUrl = intent.getStringExtra("image_url");

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)
            findViewById(R.id.collapsing_toolbar);
    ImageView informationImageView = (ImageView)findViewById(R.id.information_image_view);
    TextView informationContentText = (TextView) findViewById(R.id.information_content_text);
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if(actionBar !=null){
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    collapsingToolbar.setTitle(informationName);
    Glide.with(this).load(informationImageId).into(informationImageView);
    Glide.with(this).load(articleImageUrl).into(informationImageView);
    String informationContent = generateInformationContent(informationName);
    informationContentText.setText(informationContent);

    }

    private String generateInformationContent(String informationName){
        StringBuilder informationContent = new StringBuilder();
            switch (informationName){

                default:
                    informationContent.append(getIntent().getStringExtra("idiom_content"));

                    break;
            }

            return informationContent.toString();
    }


@Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

