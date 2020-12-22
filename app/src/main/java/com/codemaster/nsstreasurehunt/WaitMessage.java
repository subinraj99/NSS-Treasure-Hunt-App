package com.codemaster.nsstreasurehunt;

import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class WaitMessage extends Dialog {
    DatabaseReference df;
    Button btn;
    TextView timeSpace;
    Activity c;
    public WaitMessage(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pleasewait);

        //initialization
        btn = findViewById(R.id.okBtn);
        timeSpace=findViewById(R.id.timeSpace);

        df= FirebaseDatabase.getInstance().getReference();
        df.child("startTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    timeSpace.setText(snapshot.child("time").getValue().toString());
                    Log.i("here",snapshot.child("time").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn.setOnClickListener(v -> WaitMessage.this.dismiss());
    }


}
