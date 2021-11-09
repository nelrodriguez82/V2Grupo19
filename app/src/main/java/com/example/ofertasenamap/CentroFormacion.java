package com.example.ofertasenamap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.GLES31;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class CentroFormacion extends AppCompatActivity {
    Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_formacion);

        btnRegistro =  findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                programa(view);

            }
            });
    }



    public void programa(View vi){
        Intent vista1=new Intent(this, ProgramaFormacion.class);
        startActivity(vista1);
    }



}