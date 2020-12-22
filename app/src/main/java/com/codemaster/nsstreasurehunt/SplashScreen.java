package com.codemaster.nsstreasurehunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.codemaster.nsstreasurehunt.SharedPreference.SharedPreference;

public class SplashScreen extends AppCompatActivity {


    ImageView logoSplashScreen;
    Animation fadeAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);



        //initialization
        logoSplashScreen = findViewById(R.id.logo);

        fadeAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade);



        new Handler().postDelayed(() -> {
            Intent verifyIntent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(verifyIntent);
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
