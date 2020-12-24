package com.codemaster.nsstreasurehunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeScreen extends AppCompatActivity {
    FirebaseAuth mauth;
    DatabaseReference df;
    Button startBtn;
    WaitMessage waitMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mauth=FirebaseAuth.getInstance();
        df= FirebaseDatabase.getInstance().getReference();

        //initialization
        waitMessage=new WaitMessage(HomeScreen.this);
        startBtn = findViewById(R.id.startBtn);
        df.child("ongoing").child(mauth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    startBtn.setText("Resume");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //on start button click
        startBtn.setOnClickListener(v -> {
            df.child("start").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(!snapshot.exists()){
                        waitMessage.show();
                    }
                    else
                    {
                        Intent intent=new Intent(HomeScreen.this,QuizScreen.class);
                        startActivity(intent);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });


        });
    }
}