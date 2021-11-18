package com.example.ofertasenamap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgramaFormacion extends AppCompatActivity {
    Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_formacion);

    btnRegistro =  findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            lista(view);

        }
    });
}



    public void lista(View vi){
        Intent vista1=new Intent(this, Tarjetas.class);
        startActivity(vista1);
    }
}