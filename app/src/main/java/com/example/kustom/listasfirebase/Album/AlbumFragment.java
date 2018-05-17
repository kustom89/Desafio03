package com.example.kustom.listasfirebase.Album;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kustom.listasfirebase.R;

public class AlbumFragment extends Fragment {

    public AlbumFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_album,container,false);
    }
}
