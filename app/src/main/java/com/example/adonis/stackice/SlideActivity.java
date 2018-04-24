package com.example.adonis.stackice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class SlideActivity extends IntroActivity {

     private static final String ARQUIVO_PREERENCIA = "ARQUIVOPREFERENCIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_light)
                .backgroundDark(android.R.color.white)
                .fragment(R.layout.primeiro_slider)
                .build() );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_blue_light)
                .backgroundDark(android.R.color.white)
                .fragment(R.layout.segundo_slider)
                .build() );

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_orange_dark)
                .backgroundDark(android.R.color.white)
                .fragment(R.layout.teceiro_slider)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(android.R.color.holo_orange_dark)
                .backgroundDark(android.R.color.white)
                .fragment(R.layout.quarto_slider)
                .canGoForward(false)
                .build());


    }

}
