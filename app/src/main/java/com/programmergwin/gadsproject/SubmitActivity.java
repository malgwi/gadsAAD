package com.programmergwin.gadsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.programmergwin.gadsproject.controls.ApiEndpointInterface;
import com.programmergwin.gadsproject.controls.DialogListener;
import com.programmergwin.gadsproject.controls.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity implements View.OnClickListener, DialogListener {

    private ImageButton btnBack;
    private Button btnSub;
    private EditText edtFirstName, edtLastName, edtEmail, edtProjectLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);

        edtFirstName=findViewById(R.id.edtFirstName);
        edtLastName=findViewById(R.id.edtLastName);
        edtEmail=findViewById(R.id.edtEmailAddrs);
        edtProjectLink=findViewById(R.id.edtProjectLink);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnBack:
                goBack();
                break;
            case R.id.btnSub:
                PerformSubmission();
                break;
        }
    }

    private void PerformSubmission() {
        if(!NoFieldIsEmpty()){
            Toast.makeText(this, "One or more field(s) is empty.", Toast.LENGTH_SHORT).show();
        }
        else {
            showConfirmDialog();
        }
    }

    private boolean NoFieldIsEmpty() {
        boolean flag=true;
        if(edtFirstName.getText()==null || edtLastName.getText()==null || edtEmail.getText()==null || edtProjectLink.getText()==null)
            flag = false;
        else if(edtFirstName.getText().toString().equals("") || edtLastName.getText().toString().equals("") || edtEmail.getText().toString().equals("") || edtProjectLink.getText().toString().equals("") )
            flag = false;
        return flag;
    }

    private void SubmitToApi() {
        ApiEndpointInterface apiService = RetrofitClientInstance.getRetrofitInstance(2).create(ApiEndpointInterface.class);
        Call<Void> call = apiService.SubmitProject(edtFirstName.getText().toString(), edtLastName.getText().toString(), edtEmail.getText().toString(), edtProjectLink.getText().toString());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                showDialogmessage(0);
                assert response.body() != null;
                String res = response.body().toString();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                showDialogmessage(-1);
            }
        });
    }

    private void goBack() {
        finish();
        return;
        // startActivity(new Intent(SubmitActivity.this, LeaderBoardActivity.class));
    }

    @Override
    public void onFinishEditDialog() {
        //send project to api
       SubmitToApi();
    }

    private void showConfirmDialog() {
        FragmentManager fm = getSupportFragmentManager();
        ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment();
        dialogFragment.show(fm, "dialog_confirm");
    }

    private void showDialogmessage(int i) {
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment dialogFragment = MyDialogFragment.newInstance(i);
        dialogFragment.show(fm, "dialog");
    }

}