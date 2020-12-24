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
    Button btn;
    TextView timeSpace;
    Activity c;
    String messageStr;

    public WaitMessage(Activity a, String messageStr) {
        super(a);
        this.c = a;
        this.messageStr = messageStr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pleasewait);

        //initialization
        btn = findViewById(R.id.okBtn);
        timeSpace = findViewById(R.id.timeSpace);

        timeSpace.setText(messageStr);

        btn.setOnClickListener(v -> WaitMessage.this.dismiss());
    }


}
