package com.example.ofertasenamap;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.example.ofertasenamap.conexion.DbProgramas;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrearPrograma#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrearPrograma extends Fragment {

    public CrearPrograma() {
        // Required empty public constructor
    }

    public static CrearPrograma newInstance() {
        CrearPrograma fragment = new CrearPrograma();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_crear_programa, container, false);

        TextInputEditText tfNombre = root.findViewById(R.id.tfNombre);
        TextInputEditText tfDuracion = root.findViewById(R.id.tfDuracion);

        Button btnAgregar = root.findViewById(R.id.btnAgregar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(tfNombre.getText().toString().trim()) &&
                        !TextUtils.isEmpty(tfDuracion.getText().toString().trim())
                       ) {

                    DbProgramas db = new DbProgramas(root.getContext());
                    db.agregarPrograma(tfNombre.getText().toString().trim(), tfDuracion.getText().toString().trim());
                    Toast.makeText(getActivity(), "Creado el Programa: " + tfNombre.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    ((com.example.ofertasenamap.CardsItems) getActivity()).switchWindow(new com.example.ofertasenamap.VerProgramas());
                    db.close();

                } else {
                    Toast.makeText(root.getContext(), "Error, hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return root;
    }
}