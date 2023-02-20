package com.example.plantas20.modelos;

public class Tipo_Plantas {
    private int id_tipo_planta;
    private String nombre_tipo_planta;

    public Tipo_Plantas(int id_tipo_planta, String nombre_tipo_planta) {
        this.id_tipo_planta = id_tipo_planta;
        this.nombre_tipo_planta = nombre_tipo_planta;
    }

    public Tipo_Plantas() {
    }

    public int getId_tipo_planta() {
        return id_tipo_planta;
    }

    public void setId_tipo_planta(int id_tipo_planta) {
        this.id_tipo_planta = id_tipo_planta;
    }

    public String getNombre_tipo_planta() {
        return nombre_tipo_planta;
    }

    public void setNombre_tipo_planta(String nombre_tipo_planta) {
        this.nombre_tipo_planta = nombre_tipo_planta;
    }
}