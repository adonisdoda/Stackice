package com.example.adonis.stackice.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.adonis.stackice.Adapter.FeedAdapter;
import com.example.adonis.stackice.Commom.HTTPDataHandler;
import com.example.adonis.stackice.Model.RSSObject;
import com.example.adonis.stackice.R;
import com.google.gson.Gson;

import static android.content.ContentValues.TAG;


public class InicioFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewListaNoticias;

    RSSObject rssObject;

    private final String RSS_link="https://feed.rssunify.com/5aed2db6ad845/rss.xml";

    private final String RSS_to_Json_API = "https://api.rss2json.com/v1/api.json?count=50&api_key=fplawnxiyd7495iokuddbsoeqwdx7nqe5ba9vhaa&rss_url=";

    private OnFragmentInteractionListener mListener;

    SwipeRefreshLayout swipeLayout;


    public InicioFragment() {
    }

    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
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

        //Carrega os cardviews
        loadRSS();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        //Configurações RecyclerView
        recyclerViewListaNoticias = view.findViewById(R.id.recyclerviewnoticias);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewListaNoticias.setLayoutManager(linearLayoutManager);
        recyclerViewListaNoticias.setHasFixedSize(false);

        //Atualizar Página
        swipeLayout = view.findViewById(R.id.menu_refresh);
        swipeLayout.setColorScheme(android.R.color.holo_orange_light,android.R.color.holo_red_light);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadRSS();
                new Thread(new Runnable() {
                    public void run() {
                        SystemClock.sleep(1000);
                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                swipeLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });

        return view;
    }


    private void loadRSS(){
        AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {
            //ProgressDialog mDialog = new ProgressDialog(getActivity());
            @Override
            protected void onPreExecute() {
               // mDialog.setMessage("ISH...Est");
               // mDialog.setVisible(true);
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
               // mDialog.dismiss();
                rssObject = new Gson().fromJson(s, RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject, getActivity());
                recyclerViewListaNoticias.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Log.i(TAG, "Size= "+rssObject.items.size());
            }
        };

        StringBuilder url_get_data = new StringBuilder(RSS_to_Json_API);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_refresh)
            loadRSS();
        return true;
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