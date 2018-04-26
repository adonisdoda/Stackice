package com.example.adonis.stackice.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.adonis.stackice.Fragments.InicioFragment;
import com.example.adonis.stackice.Fragments.LocalizacaoFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private String [] titulosAbas = {"INÍCIO" , "LOCALIZAÇÃO"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0 :
                fragment = new InicioFragment();
                break;
            case 1 :
                fragment = new LocalizacaoFragment();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return titulosAbas.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titulosAbas[ position ];
    }
}