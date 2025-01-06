package com.example.profileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class ProfileDisplayActivity extends AppCompatActivity {

    // Constants for passing data between activities
    public static final String KEY_NAME = "NAME";
    public static final String KEY_AGE = "AGE";
    public static final String KEY_EMAIL = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);

        // Set up Action Bar with a title and back button.
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile Details"); // Set the title
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button
        }

        // Receiving data and adding fragment using Intent.
        Intent intent = getIntent();
        String name = intent.getStringExtra(KEY_NAME);
        String age = intent.getStringExtra(KEY_AGE);
        String email = intent.getStringExtra(KEY_EMAIL);


        // Passing the data to a Fragment using a Bundle.
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        bundle.putString(KEY_AGE, age);
        bundle.putString(KEY_EMAIL, email);

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(bundle);

        // Dynamically loads the Fragment into the screen using FragmentManager
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit();

        // Add fragment with animation
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(
                R.anim.enter_from_left,  // Enter animation (slide in from the left)
                R.anim.exit_to_right     // Exit animation (slide out to the right)
        );
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }


    // Handle the back button in the Action Bar
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Close this activity and go back to the previous one
       return true;
 }
}