package com.example.profileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String age = intent.getStringExtra("AGE");
        String email = intent.getStringExtra("EMAIL");

        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        bundle.putString("AGE", age);
        bundle.putString("EMAIL", email);

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}