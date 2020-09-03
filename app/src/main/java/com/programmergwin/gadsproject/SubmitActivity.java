package com.programmergwin.gadsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SubmitActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnBack:
                goBack();

                break;
        }
    }

    private void goBack() {
        finish();
        return;
        // startActivity(new Intent(SubmitActivity.this, LeaderBoardActivity.class));
    }
}