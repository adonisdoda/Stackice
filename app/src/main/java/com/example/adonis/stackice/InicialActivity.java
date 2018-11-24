package com.example.adonis.stackice;


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

        FragmentPagerItemAdapter adaptador = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),FragmentPagerItems.with(this)
                .add(R.string.inicio, InicioFragment.class)
                .add(R.string.localizacao, LocalizacaoFragment.class)
        .create());


        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adaptador);

        SmartTabLayout viewPagerTab = findViewById(R.id.viewPagerTab);
        viewPagerTab.setViewPager(viewPager);
/*
        final LayoutInflater inflater = LayoutInflater.from(viewPagerTab.getContext());
        final Resources res = viewPagerTab.getContext().getResources();

        viewPagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                ImageView icon = (ImageView) inflater.inflate(R.layout.customtabicon, container,false);

                switch (position){
                    case 0:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_home_white_24dp));
                        break;
                    case 1:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_flash_on_white_24dp));
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }

                return icon;
            }
        });
*/

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
