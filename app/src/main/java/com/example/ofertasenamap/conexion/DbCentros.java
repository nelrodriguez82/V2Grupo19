package com.example.ofertasenamap.conexion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.example.ofertasenamap.ListCentros;
import com.example.ofertasenamap.ListProgramas;

import java.util.ArrayList;
import java.util.List;

public class DbCentros extends Senadb{

    Context context; // Variable global

    // Constructor
    public DbCentros(@Nullable Context context){
        super(context);
        this.context = context;

    }

    public void agregarCentro(String nombrecentro) {
        ContentValues cv = new ContentValues(); // Instancia del objeto ContentValues
        cv.put("nombrecentro", nombrecentro);


        this.getWritableDatabase().insert("centrosformacion", null, cv);
    }

    public void eliminarCentro(String codigocentro) {
        this.getWritableDatabase().delete("centrosformacion", "idcentro = ?", new String[]{codigocentro.trim()});
    }

    public void actualizarCentro(String codigCentro, String nombreCentro) {
        ContentValues cv = new ContentValues(); // Instancia
        cv.put("nombrecentro", nombreCentro);

        // trim = Es un método que se encarga de eliminar caracteres blancos iniciales y finales de una cadena de texto (String)
        this.getWritableDatabase().update("centrosformacion", cv, "idcentro = ?", new String[]{codigCentro.trim()});
    }

    public List<ListCentros> consultarCentros() {
        List<ListCentros> listCentros = new ArrayList<ListCentros>(); // Instancia de un objeto tipo lista

        Cursor result = this.getWritableDatabase().query("centrosformacion", new String[]{"idcentro", "nombrecentro"}, null, null, null, null, null);
        while (result.moveToNext()) {
            ListCentros nuevoCentro= new ListCentros(
                    result.getInt((int) result.getColumnIndex("idcentro")),
                    result.getString((int) result.getColumnIndex("nombrecentro"))

            );
            listCentros.add(nuevoCentro);
        }

        return listCentros;
    }


}

