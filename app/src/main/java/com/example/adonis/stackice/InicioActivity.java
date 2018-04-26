package com.example.adonis.stackice;


import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adonis.stackice.Adapter.TabAdapter;
import com.example.adonis.stackice.Fragments.InicioFragment;
import com.example.adonis.stackice.Fragments.LocalizacaoFragment;
import com.example.adonis.stackice.helper.SlidingTabLayout;


public class InicioActivity extends AppCompatActivity
        implements InicioFragment.OnFragmentInteractionListener,LocalizacaoFragment.OnFragmentInteractionListener {


    private SlidingTabLayout slidingTabsLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Criando a tab e view layout

        slidingTabsLayout = findViewById(R.id.slidingTabsLayoutId);
        viewPager = findViewById(R.id.viewPagerId);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter );
        slidingTabsLayout.setViewPager(viewPager);


        //Bloco da tab e view layout



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
