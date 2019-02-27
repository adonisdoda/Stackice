package com.example.adonis.stackice.Fragmentos;

import android.app.ProgressDialog;
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

    RecyclerView listaDeNoticias;
    private final String RSS_link="https://feed.rssunify.com/5aed2db6ad845/rss.xml";
    private final String RSS_to_Json_API =
            "https://api.rss2json.com/v1/api.json?count=50&api_key=fplawnxiyd7495iokuddbsoeqwdx7nqe5ba9vhaa&rss_url=";


    public static InicioFragment newInstance() {
        return new InicioFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        carregaRss();
        customizaLayoutNoticias(view);
        customizaSwipeRefresh(view);

        return view;
    }


    private void carregaRss(){
        AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>()
        {
            RSSObject rssObject;

            @Override
            protected void onPreExecute() {
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
                rssObject = new Gson().fromJson(s, RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject, getActivity());
                listaDeNoticias.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                //Log.i(TAG, "Size= "+rssObject.items.size());
            }
        };

        StringBuilder url_get_data = new StringBuilder(RSS_to_Json_API);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());
    }


    public void customizaSwipeRefresh(View view)
    {
        final SwipeRefreshLayout atualizarNoticias;

        atualizarNoticias = view.findViewById(R.id.menu_refresh);
        atualizarNoticias.setColorSchemeResources(R.color.colorPrimaryDetails,R.color.colorPrimary);

        atualizarNoticias.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carregaRss();
                new Thread(new Runnable() {
                    public void run() {
                        SystemClock.sleep(1000);
                        getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                atualizarNoticias.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });

    }

    public void customizaLayoutNoticias(View view)
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listaDeNoticias = view.findViewById(R.id.recyclerviewnoticias);
        listaDeNoticias.setLayoutManager(linearLayoutManager);
        listaDeNoticias.setHasFixedSize(false);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}