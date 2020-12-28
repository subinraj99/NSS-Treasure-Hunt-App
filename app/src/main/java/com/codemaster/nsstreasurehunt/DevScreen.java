package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DevScreen extends AppCompatActivity {

    TextView devby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_screen);
        devby=findViewById(R.id.devby);

        devby.animate().translationYBy(350).setDuration(2000).setStartDelay(600);
        devby.animate().alphaBy(1).setDuration(500).setStartDelay(600);

        Intent DevScreenIntent = new Intent(DevScreen.this, LoginActivity.class);
        startActivity(DevScreenIntent);

        finish();
    }
}