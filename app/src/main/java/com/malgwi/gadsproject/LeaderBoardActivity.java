package com.malgwi.gadsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.malgwi.gadsproject.controls.ViewPagerAdapter;

public class LeaderBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmt;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        btnSubmt = findViewById(R.id.btnSubmit);
        btnSubmt.setOnClickListener(this);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.leaderboard);
        setSupportActionBar(toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubmit:
                startActivity(new Intent(LeaderBoardActivity.this, SubmitActivity.class));
                break;
        }
    }
}