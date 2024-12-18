package com.example.profileapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAge = view.findViewById(R.id.tv_age);
        TextView tvEmail = view.findViewById(R.id.tv_email);

        Bundle bundle = getArguments();
        if (bundle != null) {
            tvName.setText("Name: " + bundle.getString("NAME"));
            tvAge.setText("Age: " + bundle.getString("AGE"));
            tvEmail.setText("Email: " + bundle.getString("EMAIL"));
        }

        return view;
    }
}
