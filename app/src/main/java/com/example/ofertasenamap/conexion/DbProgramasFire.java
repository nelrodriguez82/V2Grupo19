package com.example.ofertasenamap.conexion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.Nullable;

import com.example.ofertasenamap.ListProgramas;

import java.util.ArrayList;
import java.util.List;

public class DbProgramasFire extends Senadb{

    Context context; // Variable global

    // Constructor
    public DbProgramasFire(@Nullable Context context){
        super(context);
        this.context = context;

    }

    public void agregarPrograma(String nombrep, String duracion) {
        ContentValues cv = new ContentValues(); // Instancia del objeto ContentValues
        cv.put("nombreprograma", nombrep);
        cv.put("duracion", duracion);

        this.getWritableDatabase().insert("programas", null, cv);
    }

    public void eliminarPrograma(String codigop) {
        this.getWritableDatabase().delete("programas", "idprograma = ?", new String[]{codigop.trim()});
    }

    public void actualizarPrograma(String codigop, String nombrePrograma, String duracion) {
        ContentValues cv = new ContentValues(); // Instancia
        cv.put("nombreprograma", nombrePrograma);
        cv.put("duracion", duracion);
        // trim = Es un método que se encarga de eliminar caracteres blancos iniciales y finales de una cadena de texto (String)
        this.getWritableDatabase().update("programas", cv, "idprograma = ?", new String[]{codigop.trim()});
    }

    public List<ListProgramas> consultarProgramas() {
        List<ListProgramas> listProgramas = new ArrayList<ListProgramas>(); // Instancia de un objeto tipo lista

        Cursor result = this.getWritableDatabase().query("programas", new String[]{"idprograma", "nombreprograma", "duracion"}, null, null, null, null, null);
        while (result.moveToNext()) {
            ListProgramas nuevoPrograma= new ListProgramas(
                    result.getInt((int) result.getColumnIndex("idprograma")),
                    result.getString((int) result.getColumnIndex("nombreprograma")),
                    result.getString((int) result.getColumnIndex("duracion"))
            );
            listProgramas.add(nuevoPrograma);
        }

        return listProgramas;
    }


}
