package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.codemaster.nsstreasurehunt.SharedPreference.SharedPreference;
import com.codemaster.nsstreasurehunt.model.UserDetails;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateUser extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Button createAccountBtn;
    TextInputEditText userNameText, collegeText, emailText;
    String uid, userName, phoneNumberStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        //initialization
        createAccountBtn = findViewById(R.id.createBtn);
        userNameText = findViewById(R.id.userNameText);
        collegeText = findViewById(R.id.collegeText);
        emailText = findViewById(R.id.emailText);

        //get intent values
        phoneNumberStr = getIntent().getStringExtra("PhoneNumber");

        //Initialize Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();
        
        createAccountBtn.setOnClickListener(v -> {
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            if (currentFirebaseUser != null) {
                uid = currentFirebaseUser.getUid();
            }
            if(userNameText.getText().toString().isEmpty()){
                userNameText.setError("Require user name");
                return;
            }
            if(collegeText.getText().toString().isEmpty()){
                collegeText.setError("Require college name");
                return;
            }
            if(emailText.getText().toString().isEmpty()){
                collegeText.setError("Require email address");
                return;
            }
            UploadUserDetails(uid,userNameText.getText().toString().trim(),collegeText.getText().toString().trim(), emailText.getText().toString().trim());
        });
    }

    private void UploadUserDetails(String uid, String userStr, String collegeStr, String emailStr) {
        UserDetails user = new UserDetails(uid, userStr, collegeStr, emailStr, phoneNumberStr);
        mDatabase.child("users").child(uid).setValue(user).addOnSuccessListener(aVoid -> {
            SharedPreference.setUserVerified(getApplicationContext(), true);
            SharedPreference.setUserName(getApplicationContext(), userName);
            Intent mainIntent = new Intent(CreateUser.this, HomeScreen.class);
            startActivity(mainIntent);
            finish();
        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}