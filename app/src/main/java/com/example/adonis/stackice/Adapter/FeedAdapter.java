package com.example.adonis.stackice.Adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.adonis.stackice.Interface.ItemClickListener;
import com.example.adonis.stackice.Model.RSSObject;
import com.example.adonis.stackice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public TextView txtTitle,txtAuthor;
    //public TextView txtPubDate;
    private ItemClickListener itemClickListener;
    public ImageView imgNoticia;


    public FeedViewHolder(View itemView) {
        super(itemView);

        txtTitle = (TextView) itemView.findViewById(R.id.tituloNoticia);
        //txtPubDate = (TextView) itemView.findViewById(R.id.textPubDate);
        txtAuthor = (TextView) itemView.findViewById(R.id.autorNoticia);
        imgNoticia = (ImageView) itemView.findViewById(R.id.imagemNoticia);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder>{

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;


    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = inflater.inflate(R.layout.cardviewistanoticiasmodelo,parent,false);
        return new FeedViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtAuthor.setText(rssObject.getItems().get(position).getAuthor());

        try {
            if (rssObject.getItems().get(position).getLink().contains("marica.rj.gov")) {

                Picasso.get().load(rssObject.getItems().get(position).getThumbnail()).into(holder.imgNoticia);

            } else if (rssObject.getItems().get(position).getLink().contains("leisecamarica")) {

                Picasso.get().load("https://leisecamarica.com.br/wp-content/uploads/2018/01/LSM-transp-VERM2.png").into(holder.imgNoticia);

            } else if (rssObject.getItems().get(position).getLink().contains("maricainfo")) {

                if (rssObject.getItems().get(position).getThumbnail() == "" )
                {
                    Picasso.get().load("http://maricainfo.com/wp-content/uploads/2017/06/logo-2017.png").placeholder(R.drawable.imagem1).into(holder.imgNoticia);

                }else
                {
                    Picasso.get().load(rssObject.getItems().get(position).getThumbnail()).into(holder.imgNoticia);
                }
            }
        }catch(Exception e)
        {
            try {
                throw new Exception("Ocorreu um erro ao exibir a imagem, erro tratado: ", e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }



        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(rssObject.getItems().get(position).getLink()));
                    mContext.startActivity(browserIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
