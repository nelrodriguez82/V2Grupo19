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

public class ActualizarPrograma extends Fragment {

    ListProgramas a;

    public ActualizarPrograma(){
        // Constructor vacio
    }

    public ActualizarPrograma(ListProgramas a){
        this.a = a;

    }

    public static ActualizarPrograma newInstance(){
        ActualizarPrograma fragment = new ActualizarPrograma(); // Instancia del objeto fragment que es de tipo ActualizarPrograma
        Bundle args = new Bundle(); // Es un formato de publicación que incluye los recursos y el código combinado de nuestras app. (APK)
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceStage){

        super.onCreate(saveInstanceStage);
    }
    // Inflater = Se utilizan para instanciar un archivo XML
    // Bundle saveInstanceStage = Sirve para no perder información previa, en un principio, guarda un valor null

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceStage){

        View root = inflater.inflate(R.layout.fragment_actualizar_programa, container, false);


        TextInputEditText tfNombre = root.findViewById(R.id.tfNombre);
        TextInputEditText tfDuracion = root.findViewById(R.id.tfDuracion);

        Button btnActualizar = root.findViewById(R.id.btnActualizar);


        tfNombre.setText(a.getNombre());
        //tfNombre.setEnabled(false); // Nos permite realizar el proceso de habilitación o no de un componente
        tfDuracion.setText(a.getDuracion());


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(tfNombre.getText().toString().trim()) &&
                        !TextUtils.isEmpty(tfDuracion.getText().toString().trim())
                        ) {

                    DbProgramas db = new DbProgramas(root.getContext());
                    db.actualizarPrograma(Integer.toString(a.getCodigo()).trim(),tfNombre.getText().toString().trim(), tfDuracion.getText().toString().trim());
                    Toast.makeText(getActivity(),"Actualizado: "+a.getNombre(),Toast.LENGTH_SHORT).show();
                    ((CardsItems) getActivity()).switchWindow(new VerProgramas());
                    db.close();

                } else {
                    Toast.makeText(root.getContext(), "Error, hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}






