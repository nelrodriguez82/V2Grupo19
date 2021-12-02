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

public class ActualizarCentro extends Fragment {

    ListCentros a;

    public ActualizarCentro(){
        // Constructor vacio
    }

    public ActualizarCentro(ListCentros a){
        this.a = a;

    }

    public static ActualizarCentro newInstance(){
        ActualizarCentro fragment = new ActualizarCentro(); // Instancia del objeto fragment que es de tipo ActualizarCentro
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

        View root = inflater.inflate(R.layout.fragment_actualizar_centro, container, false);


        TextInputEditText tfNombre = root.findViewById(R.id.tfNombre);


        Button btnActualizar = root.findViewById(R.id.btnActualizar);


        tfNombre.setText(a.getNombre());
        //tfNombre.setEnabled(false); // Nos permite realizar el proceso de habilitación o no de un componente



        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(tfNombre.getText().toString().trim())
                ) {

                    DbCentros db = new DbCentros(root.getContext());
                    db.actualizarCentro(Integer.toString(a.getCodigo()).trim(),tfNombre.getText().toString().trim());
                    Toast.makeText(getActivity(),"Actualizado: "+a.getNombre(),Toast.LENGTH_SHORT).show();
                    ((CentrosItems) getActivity()).switchWindow(new VerCentros());
                    db.close();

                } else {
                    Toast.makeText(root.getContext(), "Error, hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}






