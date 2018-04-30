package com.example.adonis.stackice;


import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adonis.stackice.Adapter.FeedAdapter;
import com.example.adonis.stackice.Commom.HTTPDataHandler;
import com.example.adonis.stackice.Fragmentos.InicioFragment;
import com.example.adonis.stackice.Fragmentos.LocalizacaoFragment;
import com.example.adonis.stackice.Model.RSSObject;
import com.google.gson.Gson;
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
