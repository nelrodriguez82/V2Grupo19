package com.example.ofertasenamap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CentrosItems extends AppCompatActivity {


    private FloatingActionButton crearCentro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros_items);
    }
    public void switchWindow(Fragment f){
        FragmentTransaction fTran = getSupportFragmentManager().beginTransaction();
        fTran.replace(R.id.fragmentContainerView,f);
        fTran.commit();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.opciones,menu);
        return true;
    }

    public  boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch (id){
            case R.id.itemProgramas:
                Intent iProgramas = new Intent(getApplicationContext(), CardsItems.class);
                startActivity(iProgramas);
                break;
            case R.id.itemRegistro:
                Intent iRegistro = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(iRegistro);
                break;
            case R.id.itemCentros:
                Intent iCentros = new Intent(getApplicationContext(), CentrosItems.class);
                startActivity(iCentros);
                break;
            case R.id.itemLogin:
                Intent iLogin = new Intent(getApplicationContext(), Login.class);
                startActivity(iLogin);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


