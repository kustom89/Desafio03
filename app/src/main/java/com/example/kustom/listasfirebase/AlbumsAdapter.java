package com.example.kustom.listasfirebase;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kustom.listasfirebase.Album.Album;
import com.example.kustom.listasfirebase.Album.AlbumsListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class AlbumsAdapter extends FirebaseRecyclerAdapter<Album, AlbumsAdapter.AlbumHolder> {
    private AlbumsListener listener;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AlbumsAdapter(@NonNull FirebaseRecyclerOptions<Album> options) {
        super(options);

    }


    @Override
    protected void onBindViewHolder(@NonNull final AlbumHolder holder, int position, @NonNull Album model) {
        holder.name.setText(model.getName());
        holder.band.setText(model.getBand());
        holder.release.setText(String.valueOf(model.getRelease()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Album auxAlbum=getItem(holder.getAdapterPosition());
                listener.clicked(auxAlbum );
            }
        });

    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_album,parent,false);
        return new AlbumsAdapter.AlbumHolder(view);
    }

    public  static class AlbumHolder extends RecyclerView.ViewHolder{

         private TextView name, band, release;


         public AlbumHolder(View itemView) {
             super(itemView);
             name=itemView.findViewById(R.id.nameTv);
             band=itemView.findViewById(R.id.bandTv);
             release=itemView.findViewById(R.id.releaseTv);
         }
     }
}
