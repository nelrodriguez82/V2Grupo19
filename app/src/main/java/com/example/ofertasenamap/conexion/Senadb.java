package com.example.ofertasenamap.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Senadb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="sena.db";
    private static final String TABLE_PROGRAMAS="programas";

    public Senadb(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_PROGRAMAS+"(idprograma INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombreprograma TEXT NOT NULL," +
                "duracion TEXT)");
        db.execSQL("CREATE TABLE regionales(idregional INTEGER PRIMARY KEY," +
                "nombreregional TEXT NOT NULL)");
        db.execSQL("CREATE TABLE centrosformacion(idcentro INTEGER PRIMARY KEY," +
                "nombrecentro TEXT NOT NULL," +
                "idregional INTEGER)");
        db.execSQL("CREATE TABLE centroprograma(idcentroprog INTEGER PRIMARY KEY," +
                "idcentro INTEGER," +
                "idprograma INTEGER)");
        db.execSQL("CREATE TABLE usuarios(idusuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "documento TEXT NOT NULL," +
                "nombre TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "correo TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "contrasena TEXT NOT NULL," +
                "estado TEXT)");
        db.execSQL(" CREATE TABLE productos ("+
                "codigop INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombrep TEXT NOT NULL,"+
                "precio DECIMAL NOT NULL,"+
                "descripcion TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TABLE_PROGRAMAS);
        onCreate(db);
    }
}
