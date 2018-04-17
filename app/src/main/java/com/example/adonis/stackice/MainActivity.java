package com.example.adonis.stackice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        addSlide(new FragmentSlide.Builder()
               .fragment(R.layout.primeiro_slider)
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.segundo_slider)
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.terceiro_slider)
                .build());










    }
}
