package com.programmergwin.gadsproject.controls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.programmergwin.gadsproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<LearningUserModel> userModelsAll;

    public LearningRecyclerAdapter(Context context, ArrayList<LearningUserModel> userModelsAll) {
        this.context = context;
        this.userModelsAll = userModelsAll;
    }

    @NonNull
    @Override
    public LearningRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_learning_leaders, parent, false);
        return new ViewHolder(v);
    }

    String fulladdrs;
    LearningUserModel userModelOne;
    @Override
    public void onBindViewHolder(@NonNull LearningRecyclerAdapter.ViewHolder holder, int position) {
        userModelOne = userModelsAll.get(position);

        if(userModelOne.getHours()!=null){
            fulladdrs  = userModelOne.getHours() + " learning hours, " + userModelOne.country;
        }
        else if (userModelOne.getScore()!=null){
            fulladdrs = userModelOne.getScore() + " skill IQ Score, " + userModelOne.country;
        }

        holder.txtUserName.setText(userModelOne.getName());
        holder.txtUserAddress.setText(fulladdrs);
        Picasso.get().load(userModelOne.badgeUrl).into(holder.imgLogo);
    }

    @Override
    public int getItemCount() {
        return userModelsAll.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtUserName;
        public TextView txtUserAddress;
        public ImageView imgLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                txtUserName = itemView.findViewById(R.id.tv_learner_name);
                txtUserAddress = itemView.findViewById(R.id.tv_learner_address);
                imgLogo=itemView.findViewById(R.id.imgLogo);
        }
    }

}