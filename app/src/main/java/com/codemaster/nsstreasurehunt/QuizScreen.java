package com.codemaster.nsstreasurehunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.lang.reflect.Member;

public class QuizScreen extends AppCompatActivity {

    ImageView hintImg;
    TextInputEditText answerText;
    Button submitBtn;

    DatabaseReference reff;
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
