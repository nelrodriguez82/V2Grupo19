package com.example.ofertasenamap;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ofertasenamap.conexion.DbCentros;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VerCentros extends Fragment {

    List<ListCentros> listCentros;
    RecyclerView recycler;

    public VerCentros() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ver_centro, container, false);

        FloatingActionButton btnCrear = root.findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(view -> ((com.example.ofertasenamap.CentrosItems) getActivity()).switchWindow(new CrearCentro()));

        DbCentros db = new DbCentros(root.getContext());
        listCentros = db.consultarCentros();

        recycler = root.findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        com.example.ofertasenamap.AdapterCentros adaptador = new com.example.ofertasenamap.AdapterCentros(listCentros, getActivity());
        recycler.setAdapter(adaptador);

        FloatingActionButton btnSalir = root.findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(view -> {
            ((com.example.ofertasenamap.CentrosItems) getActivity()).finish();
            System.exit(0);
        });

//        SearchView vBuscar = root.findViewById(R.id.vBuscar);
//        vBuscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if (TextUtils.isEmpty(s)) {
//                    recycler.setAdapter(new AdapterCentros(listCentros, getActivity()));
//                } else {
//                    ArrayList<ListCentros> lista2 = new ArrayList<ListCentros>();
//                    listCentros.stream().filter(listCentros -> listCentros.getDescripcion().startsWith(s) || Integer.toString(listCentros.getCodigo()).startsWith(s) ).forEach(listCentros -> lista2.add(listCentros));
//                    recycler.setAdapter(new AdapterCentros(lista2, getActivity()));
//                }
//                return false;
//            }
//        });

        return root;
    }
}

