package com.programmergwin.gadsproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.programmergwin.gadsproject.controls.ApiEndpointInterface;
import com.programmergwin.gadsproject.controls.LearningRecyclerAdapter;
import com.programmergwin.gadsproject.controls.LearningUserModel;
import com.programmergwin.gadsproject.controls.RetrofitClientInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    LearningRecyclerAdapter adapter;
    private ArrayList<LearningUserModel> arrayList;

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        recyclerView = view.findViewById(R.id.recyclerLearningLeaders);

        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        getContent();

        return view;
    }

    private void getContent() {
        ApiEndpointInterface apiService = RetrofitClientInstance.getRetrofitInstance(1).create(ApiEndpointInterface.class);
        Call<ArrayList<LearningUserModel>> callItem = apiService.getLearningUserList();
        callItem.enqueue(new Callback<ArrayList<LearningUserModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<LearningUserModel>> call, @NonNull Response<ArrayList<LearningUserModel>> response) {
                if( response.body() != null){
                    arrayList=response.body();
                    adapter = new LearningRecyclerAdapter(getContext(), arrayList);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<LearningUserModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}