package com.codemaster.nsstreasurehunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.codemaster.nsstreasurehunt.SharedPreference.SharedPreference;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {
    ImageView logoSplashScreen;
    TextView welcomeText;
    Animation zoomAnimation, fadeAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //initialization
        logoSplashScreen = findViewById(R.id.logo);
        welcomeText = findViewById(R.id.welcome_text);

        zoomAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.zoom);
        logoSplashScreen.setAnimation(zoomAnimation);

        fadeAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade);

        new Handler().postDelayed(() -> {
            if (SharedPreference.getUserVerified(getApplicationContext())){
                Intent mainIntent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(mainIntent);
            }else {
                Intent verifyIntent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(verifyIntent);
            }
            finish();
        }, 1500);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPreference.getUserVerified(getApplicationContext())){
            Intent mainIntent = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(mainIntent);
            finish();
        }
    }
}