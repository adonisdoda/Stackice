package com.example.adonis.stackice.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.example.adonis.stackice.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;


public class LocalizacaoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ViewFlipper mySlider;

    String BannerArray[] =
                    {"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_hgM1tUQkLTmrjl4nZceqHmJijxvK-9Oa5VTBFTtw6Q2Vn-72DA",
                    "http://78.media.tumblr.com/8e9b3fd1f007ca5470d10c8e8de637ff/tumblr_nn82xvY8li1tv4hrso3_1280.jpg",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_hgM1tUQkLTmrjl4nZceqHmJijxvK-9Oa5VTBFTtw6Q2Vn-72DA",
                    "http://78.media.tumblr.com/8e9b3fd1f007ca5470d10c8e8de637ff/tumblr_nn82xvY8li1tv4hrso3_1280.jpg"};



    private OnFragmentInteractionListener mListener;

    public LocalizacaoFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_localizacao, container, false);

        mySlider = (ViewFlipper) view.findViewById(R.id.slider);

        for (int i=0; i< BannerArray.length ; i++)
        {
            setBannerSlide(BannerArray[i]);
        }






        return  view;


    }



    //BANNER SET
    public void setBannerSlide(String imgUrl){

        ImageView image = new ImageView(getActivity());

        image.setScaleType(ImageView.ScaleType.FIT_XY);

        Picasso.get().load(imgUrl).memoryPolicy(MemoryPolicy.NO_CACHE).into(image);

        mySlider.addView(image);
        mySlider.setFlipInterval(4500);
        mySlider.setAutoStart(true);
        mySlider.setInAnimation(getActivity(),R.anim.animacaoentradabanner);
        mySlider.setOutAnimation(getActivity(),R.anim.animacaosaidabanner);

    }




    //GERADOS PELO SISTEMA

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
