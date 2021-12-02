package com.example.ofertasenamap;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.ofertasenamap.conexion.DbCentros;
import com.google.android.material.textfield.TextInputEditText;

public class CrearCentro extends Fragment {

    public CrearCentro() {
        // Required empty public constructor
    }

    public static CrearCentro newInstance() {
        CrearCentro fragment = new CrearCentro();
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
        View root = inflater.inflate(R.layout.fragment_crear_centro, container, false);

        TextInputEditText tfNombre = root.findViewById(R.id.tfNombre);


        Button btnAgregar = root.findViewById(R.id.btnAgregar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(tfNombre.getText().toString().trim())
                ) {

                    DbCentros db = new DbCentros(root.getContext());
                    db.agregarCentro(tfNombre.getText().toString().trim());
                    Toast.makeText(getActivity(), "Creado el Centro: " + tfNombre.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    ((com.example.ofertasenamap.CentrosItems) getActivity()).switchWindow(new com.example.ofertasenamap.VerCentros());
                    db.close();

                } else {
                    Toast.makeText(root.getContext(), "Error, hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return root;
    }
}
