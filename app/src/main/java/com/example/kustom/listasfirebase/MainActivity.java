package com.example.kustom.listasfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.kustom.listasfirebase.Album.Album;
import com.example.kustom.listasfirebase.Album.AlbumsListener;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MainActivity extends AppCompatActivity implements AlbumsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.albumRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        //options del adapter
        FirebaseRecyclerOptions<Album> options = new  FirebaseRecyclerOptions.Builder<Album>()
                .setQuery(new Nodes().albums(),Album.class)
                .setLifecycleOwner(this)
                .build();

        AlbumsAdapter adapter = new AlbumsAdapter(options);
        recyclerView.setAdapter(adapter);






    }



    @Override
    public void clicked(Album album) {
        Toast.makeText(this, album.getName(), Toast.LENGTH_SHORT).show();
    }
}
