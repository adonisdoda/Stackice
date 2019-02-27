package com.example.adonis.stackice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class SlideActivity extends IntroActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Criação dos slides
        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(R.color.Background)
                .backgroundDark(R.color.colorPrimary)
                .fragment(R.layout.primeiro_slider)
                .build() ) ;

        addSlide(new FragmentSlide.Builder()
                .background(R.color.Background)
                .backgroundDark(R.color.colorPrimary)
                .fragment(R.layout.segundo_slider)
                .build() );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.Background)
                .backgroundDark(R.color.colorPrimary)
                .fragment(R.layout.terceiro_slider)
                .canGoForward(false)
                .build());


    }
    //Botão Avançar Tela
    public void avançar_tela(View view){
        startActivity(new Intent(this,SplashActivity.class));
        super.finish();
    }

}
