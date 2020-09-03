package com.programmergwin.gadsproject;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialogFragment extends DialogFragment {

    private ImageView imgIcon;
    private TextView txtText;
    private ImageButton btnClose;

    public static MyDialogFragment newInstance(int i) {
        Bundle args = new Bundle();
        args.putInt("val", i);
        MyDialogFragment fragment = new MyDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            val = getArguments().getInt("val");
        }
    }

    int val=11;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_dialog, container, false);

        // Do all the stuff to initialize your custom view
        txtText=view.findViewById(R.id.dg_txtText);
        imgIcon = view.findViewById(R.id.dg_imgIcon);
        btnClose = view.findViewById(R.id.btnClose);

        if(val==-1){
            txtText.setText(R.string.submission_not_successful);
            imgIcon.setImageResource(R.drawable.not_success_icon);
        }else if(val==0){
            txtText.setText(R.string.submission_successful);
            imgIcon.setImageResource(R.drawable.success_icon);
        }

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment.this.dismiss();
            }
        });

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}