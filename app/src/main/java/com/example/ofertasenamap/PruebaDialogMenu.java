package com.example.ofertasenamap;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PruebaDialogMenu extends AppCompatActivity {

    private Button btnDialog;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_dialog_menu);

        // Context = Donde estamos ejecutando el código
        dialog = new Dialog(PruebaDialogMenu.this);
        dialog.setContentView(R.layout.custom_dialog);
        //dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background2));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        // Declaramos los botones
        Button cancel = dialog.findViewById(R.id.btn_cancel);
        Button okay = dialog.findViewById(R.id.btn_okay);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PruebaDialogMenu.this, "Cancelado", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PruebaDialogMenu.this, "Correcto", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
            }
        });


    }

}