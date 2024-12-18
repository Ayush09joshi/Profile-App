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

        // Set up Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile Details"); // Set the title
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button
        }

        // Receiving data and adding fragment
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String age = intent.getStringExtra("AGE");
        String email = intent.getStringExtra("EMAIL");


        // Pass data to the fragment
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

    // Handle the back button in the Action Bar
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Close this activity and go back to the previous one
        return true;
    }
}