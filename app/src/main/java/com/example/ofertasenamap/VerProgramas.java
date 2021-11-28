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

import com.example.ofertasenamap.conexion.DbProgramas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VerProgramas extends Fragment {

    List<ListProgramas> listProgramas;
    RecyclerView recycler;

    public VerProgramas() {
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

        View root = inflater.inflate(R.layout.fragment_ver_programa, container, false);

        FloatingActionButton btnCrear = root.findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(view -> ((com.example.ofertasenamap.CardsItems) getActivity()).switchWindow(new CrearPrograma()));

        DbProgramas db = new DbProgramas(root.getContext());
        listProgramas = db.consultarProgramas();

        recycler = root.findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        com.example.ofertasenamap.AdapterProgramas adaptador = new com.example.ofertasenamap.AdapterProgramas(listProgramas, getActivity());
        recycler.setAdapter(adaptador);

        FloatingActionButton btnSalir = root.findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(view -> {
            ((com.example.ofertasenamap.CardsItems) getActivity()).finish();
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
//                    recycler.setAdapter(new AdapterProgramas(listProgramas, getActivity()));
//                } else {
//                    ArrayList<ListProgramas> lista2 = new ArrayList<ListProgramas>();
//                    listProgramas.stream().filter(listProgramas -> listProgramas.getDescripcion().startsWith(s) || Integer.toString(listProgramas.getCodigo()).startsWith(s) ).forEach(listProgramas -> lista2.add(listProgramas));
//                    recycler.setAdapter(new AdapterProgramas(lista2, getActivity()));
//                }
//                return false;
//            }
//        });

        return root;
    }
}
