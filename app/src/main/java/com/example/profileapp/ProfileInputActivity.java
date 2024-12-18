package com.example.profileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);

        EditText etName = findViewById(R.id.et_name);
        EditText etAge = findViewById(R.id.et_age);
        EditText etEmail = findViewById(R.id.et_email);
        Button btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String age = etAge.getText().toString();
            String email = etEmail.getText().toString();

            Intent intent = new Intent(ProfileInputActivity.this, ProfileDisplayActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("AGE", age);
            intent.putExtra("EMAIL", email);
            startActivity(intent);
        });
    }
}