package com.example.adonis.stackice;


import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adonis.stackice.Fragmentos.InicioFragment;
import com.example.adonis.stackice.Fragmentos.LocalizacaoFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class InicialActivity extends AppCompatActivity
        implements InicioFragment.OnFragmentInteractionListener,LocalizacaoFragment.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);




//Início Criação de Abas
        FragmentPagerItemAdapter adaptador = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),FragmentPagerItems.with(this)
                .add(R.string.inicio, InicioFragment.class)
                .add(R.string.localizacao, LocalizacaoFragment.class)
                .create());

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adaptador);

        SmartTabLayout viewPagerTab = findViewById(R.id.viewPagerTab);
        viewPagerTab.setViewPager(viewPager);
//Término Bloco Criação de Abas


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
