package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class QuizScreen extends AppCompatActivity {

    ImageView hintImg;
    TextInputEditText answerText;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        //initialization
        hintImg = findViewById(R.id.hintImage);
        answerText = findViewById(R.id.answerText);
        submitBtn = findViewById(R.id.startBtn);

    }
}