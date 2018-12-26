package com.example.adonis.stackice.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.example.adonis.stackice.Model.Propaganda;
import com.example.adonis.stackice.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LocalizacaoFragment extends Fragment implements Serializable{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentInteractionListener mListener;
    private String mParam1;
    private String mParam2;
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference ReferenciaPropagandas = database.child("Propagandas");

    ViewFlipper mySlider;
    private static List<Propaganda> list = new ArrayList<>();


    public LocalizacaoFragment() {
        // Required empty public constructor
    }

    public static LocalizacaoFragment newInstance(String param1, String param2) {
        LocalizacaoFragment fragment = new LocalizacaoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_localizacao, container, false);
        Intent chamadaActivity = getActivity().getIntent();
        mySlider = view.findViewById(R.id.slider);
        list = (List<Propaganda>) chamadaActivity.getSerializableExtra("Lista");

        for(int i=0; i < list.size(); i++)
        {
            setBannerSlide(list.get(i).getLink());
        }
       // chamaLinkPropaganda();
        return  view;
    }

       // public void chamaLinkPropaganda(){
       //     Intent chamadaActivity = getActivity().getIntent();
       //     list = (List<Propaganda>) chamadaActivity.getSerializableExtra("Lista");
       //
       //     for(int i=0; i < list.size(); i++)
       //     {
       //         setBannerSlide(list.get(i).getLink());
       //     }
       //
       // }

    public void setBannerSlide(String imgUrl){

        ImageView image = new ImageView(getActivity());

        image.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.get().load(imgUrl).into(image);

        mySlider.addView(image);
        mySlider.setFlipInterval(4500);
        mySlider.setAutoStart(true);
        mySlider.setInAnimation(getActivity(),R.anim.animacaoentradabanner);
        mySlider.setOutAnimation(getActivity(),R.anim.animacaosaidabanner);
    }

    public void propagandasAtualizar()
    {

        ReferenciaPropagandas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot: dataSnapshot.getChildren() ) {

                    Propaganda propaganda = new Propaganda(childDataSnapshot.getValue().toString());

                    list.add(propaganda);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
