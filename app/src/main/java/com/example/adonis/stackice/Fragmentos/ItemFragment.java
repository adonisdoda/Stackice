package com.example.adonis.stackice.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.adonis.stackice.InicialActivity;
import com.example.adonis.stackice.MensagemActivity;
import com.example.adonis.stackice.Model.Propaganda;
import com.example.adonis.stackice.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ItemFragment extends Fragment implements Serializable{

    private OnFragmentInteractionListener mListener;
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private static List<Propaganda> list = new ArrayList<>();
    DatabaseReference ReferenciaPropagandas = database.child("Propagandas");
    ViewFlipper mySlider;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_item, container, false);
        mySlider = view.findViewById(R.id.slider);

        RecebePropaganda();
        EventosDeClick(view);

        return  view;
    }

    public void RecebePropaganda(){
        Intent chamadaActivity = getActivity().getIntent();
        list = (List<Propaganda>) chamadaActivity.getSerializableExtra("Lista");

        if(list.size() > 0 )
        {
            for(int i=0; i < list.size(); i++)
            {
                setBannerSlide(list.get(i).getLink());
            }
        }
    }

    public void AtualizarPropagandas()
    {
        ReferenciaPropagandas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot: dataSnapshot.getChildren() ) {

                    Propaganda propaganda = new Propaganda(childDataSnapshot.getValue().toString());
                    list.add(propaganda);
                }

                if(list.size() > 0 )
                {
                    for(int i=0; i < list.size(); i++)
                    {
                        setBannerSlide(list.get(i).getLink());
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setBannerSlide(String imgUrl)
    {
        ImageView image = new ImageView(getActivity());
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.get().load(imgUrl).into(image);

        mySlider.addView(image);
        mySlider.setFlipInterval(4500);
        mySlider.setAutoStart(true);
        mySlider.setInAnimation(getActivity(),R.anim.animacaoentradabanner);
        mySlider.setOutAnimation(getActivity(),R.anim.animacaosaidabanner);
    }

    protected void EventosDeClick(View view)
    {
        ImageView cupomDeLocais;
        ImageView cupomDeDesconto;
        ImageView botaoFaleComaGente;

        cupomDeDesconto = view.findViewById(R.id.cupomdesconto);
        cupomDeLocais = view.findViewById(R.id.cupomlocais);
        botaoFaleComaGente = view.findViewById(R.id.botao_falecomagente);

        cupomDeLocais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomizarToast();
            }
        });

        cupomDeDesconto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomizarToast();
            }
        });

        botaoFaleComaGente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFragment = new Intent(getActivity().getApplicationContext(),MensagemActivity.class);
                startActivity(intentFragment);
            }
        });
    }

    public void CustomizarToast()
    {
        Toast toast = new Toast(getContext());
        toast.setDuration(Toast.LENGTH_SHORT);

        LayoutInflater inflaterToast = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View viewToast = inflaterToast.inflate(R.layout.toast_customizacao,null);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(viewToast);
        toast.show();

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        AtualizarPropagandas();

    }
}
