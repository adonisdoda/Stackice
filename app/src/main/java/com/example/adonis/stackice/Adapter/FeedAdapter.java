package com.example.adonis.stackice.Adapter;


import android.content.Context;
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



public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder>{
    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;


    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cardviewistanoticiasmodelo,parent,false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.txtAuthor.setText(rssObject.getItems().get(position).getAuthor());
        holder.imgNoticias.setImageURI(Uri.parse(rssObject.getItems().get(position).getThumbnail()));





    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }



    class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        public TextView txtTitle,txtPubDate,txtAuthor;
        private ItemClickListener itemClickListener;
        public ImageView imgNoticias;

        public FeedViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView)itemView.findViewById(R.id.tituloNoticia);
            txtPubDate = (TextView)itemView.findViewById(R.id.textPubDate);
            txtAuthor = (TextView)itemView.findViewById(R.id.autorNoticia);
            imgNoticias = (ImageView)itemView.findViewById(R.id.imagemNoticia);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }


//Todas essas babozeira são códigos gerados automaticamente


        @Override
        public void onClick(View v) {

            itemClickListener.onClicl(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClicl(v,getAdapterPosition(),true);
            return true;
        }
    }

}
