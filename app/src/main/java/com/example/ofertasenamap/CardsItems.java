package com.example.ofertasenamap;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CardsItems extends AppCompatActivity {


    private FloatingActionButton crearArticulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_items);
    }
    public void switchWindow(Fragment f){
        FragmentTransaction fTran = getSupportFragmentManager().beginTransaction();
        fTran.replace(R.id.fragmentContainerView,f);
        fTran.commit();
    }
}


