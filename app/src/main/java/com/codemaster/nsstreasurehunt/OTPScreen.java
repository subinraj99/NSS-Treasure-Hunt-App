package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import com.chaos.view.PinView;

import java.util.concurrent.TimeUnit;

public class OTPScreen extends AppCompatActivity {

    String verificationCodeBySystem;
    String phoneNumberStr;
    Button verifyBtn;
    PinView OTPCodePinView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p_screen);

        //initialization
        verifyBtn = findViewById(R.id.verifyBtn);
        OTPCodePinView = findViewById(R.id.pinView);
        progressBar = findViewById(R.id.progressBar);

        //get intent values
        phoneNumberStr = getIntent().getStringExtra("PhoneNumber");

        sendVerificationCode(phoneNumberStr);
    }

    private void sendVerificationCode(String phoneNo) {

    }
}