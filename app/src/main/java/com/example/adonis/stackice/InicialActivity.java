package com.example.adonis.stackice;


import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adonis.stackice.Adapter.ViewPagerAdapter;
import com.example.adonis.stackice.Fragmentos.InicioFragment;
import com.example.adonis.stackice.Fragmentos.LocalizacaoFragment;

public class InicialActivity extends AppCompatActivity implements InicioFragment.OnFragmentInteractionListener,LocalizacaoFragment.OnFragmentInteractionListener
{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        tabLayout =  findViewById(R.id.tablayout);
        viewPager =  findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new InicioFragment(),"");
        adapter.AddFragment(new LocalizacaoFragment(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icone_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.icone_menu);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
