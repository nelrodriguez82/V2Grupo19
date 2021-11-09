package com.example.ofertasenamap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(Login.this, "Usuario correcto", Toast.LENGTH_SHORT).show();
                    centro(view);
                }else
                    Toast.makeText(Login.this,"Usuario no registrado", Toast.LENGTH_SHORT).show();

            }
        });
    }



    public void centro(View view){
        Intent vista1=new Intent(this, CentroFormacion.class);
        startActivity(vista1);
    }



}