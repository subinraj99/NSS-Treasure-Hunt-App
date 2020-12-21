package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CreateUser extends AppCompatActivity {
    Button createAccountBtn;
    TextInputEditText userNameText, collegeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        //initialization
        createAccountBtn = findViewById(R.id.createBtn);
        userNameText = findViewById(R.id.userNameText);
        collegeText = findViewById(R.id.collegeText);
        
        createAccountBtn.setOnClickListener(v -> {
            if(userNameText.getText().toString().isEmpty()){
                userNameText.setError("Require user name");
                return;
            }else if(collegeText.getText().toString().isEmpty()){
                collegeText.setError("Require college name");
                return;
            }
            UploadUserDetails(userNameText.getText().toString().trim(),collegeText.getText().toString().trim());
        });
    }

    private void UploadUserDetails(String userNameText, String collegeText) {
        //upload code here
    }
}