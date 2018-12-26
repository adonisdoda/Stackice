package com.example.adonis.stackice;


import android.app.Fragment;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adonis.stackice.Fragmentos.InicioFragment;
import com.example.adonis.stackice.Fragmentos.LocalizacaoFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class InicialActivity extends AppCompatActivity
        implements InicioFragment.OnFragmentInteractionListener,LocalizacaoFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ViewPager viewPager = findViewById(R.id.viewPager);
        SmartTabLayout viewPagerTab = findViewById(R.id.viewPagerTab);
        setContentView(R.layout.activity_inicial);

        super.onCreate(savedInstanceState);
        final FragmentPagerItemAdapter adaptador = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),FragmentPagerItems.with(this)
                .add(R.string.inicio, InicioFragment.class)
                .add(R.string.localizacao, LocalizacaoFragment.class)
        .create());



        viewPager.setAdapter(adaptador);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
