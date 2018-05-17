package com.example.kustom.listasfirebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes {

    private DatabaseReference root= FirebaseDatabase.getInstance().getReference();

    public  DatabaseReference albums(){
        return root.child("albums");
    }



}
