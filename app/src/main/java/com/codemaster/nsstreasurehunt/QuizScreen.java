package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class QuizScreen extends AppCompatActivity {

    ImageView hintImg, hintRefreshImg;
    TextInputEditText answerText;
    Button submitBtn;
    TextView qnoText;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        //initialization
        hintImg = findViewById(R.id.hintImage);
        answerText = findViewById(R.id.answerText);
        submitBtn = findViewById(R.id.startBtn);
        qnoText = findViewById(R.id.questionNumber);
        hintRefreshImg = findViewById(R.id.hintRefresh);
        progressBar = findViewById(R.id.progressBar);

        // initial question fetch
        questionFetch();

        // on the press of submit answer check
        submitBtn.setOnClickListener(v -> {
            if(answerText.getText().toString().isEmpty()){
                answerText.setError("Enter a answer to submit");
                return;
            }
            progressBar.setVisibility(View.VISIBLE);
            checkAnswer();
        });

        //on hint fetch
        hintRefreshImg.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            hintFetch();
        });

    }

    //initial question fetch based on resume or start
    private void questionFetch() {
    }

    //hint fetch function
    private void hintFetch() {

    }

    //answer check function
    private void checkAnswer() {
    }
}