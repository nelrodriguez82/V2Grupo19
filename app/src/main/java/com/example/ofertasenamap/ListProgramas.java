package com.example.ofertasenamap;

public class ListProgramas {

    private int codigo;
    private String nombre;
    private String duracion;



    // Construtor
    public ListProgramas(int codigo, String nombre, String duracion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;

    }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }


}
