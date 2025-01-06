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

import com.google.android.material.textfield.TextInputEditText;

public class ProfileInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_input);

        TextInputEditText etName = findViewById(R.id.input_name);
        TextInputEditText etAge = findViewById(R.id.input_age);
        TextInputEditText etEmail = findViewById(R.id.input_email);
        Button btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String age = etAge.getText().toString();
            String email = etEmail.getText().toString();

            Intent intent = new Intent(ProfileInputActivity.this, ProfileDisplayActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("AGE", age);
            intent.putExtra("EMAIL", email);
//            overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            startActivity(intent);
        });
    }
}