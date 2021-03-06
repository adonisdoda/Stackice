package com.example.adonis.stackice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VerificacaoPrimeiraVezActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacao);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("isfirstrun",true);

        if(isFirstRun)
        {
            Intent intentSlideActivity = new Intent(getApplicationContext(), SlideActivity.class );
            getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit().putBoolean("isfirstrun",false).commit();
            startActivity(intentSlideActivity);
            super.finish();
        }
        else
        {
            Intent intentSplashActivity = new Intent(getApplicationContext(), SplashActivity.class );
            startActivity(intentSplashActivity);
            super.finish();
        }
    }
}
