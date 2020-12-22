package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //initialization
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(v -> {
        });
    }
}