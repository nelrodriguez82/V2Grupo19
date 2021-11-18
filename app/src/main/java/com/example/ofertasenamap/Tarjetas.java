package com.example.ofertasenamap;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Tarjetas extends AppCompatActivity {
    List<ListElement> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjetas);
        init();
    }

    public void init(){
        elements = new ArrayList<>();

        elements.add(new ListElement(R.drawable.csf, "Servicios Financieros", "Bogotá", "Activo"));
        elements.add(new ListElement(R.drawable.ceet, "Electricidad y Electronica", "Bogotá", "Activo"));
        elements.add(new ListElement(R.drawable.admin, "Administrativo", "Bogotá", "Activo"));
        elements.add(new ListElement(R.drawable.mlti, "Mercados y TI", "Bogotá", "Activo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

}