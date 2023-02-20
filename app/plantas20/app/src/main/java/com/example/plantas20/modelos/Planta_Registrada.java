package com.example.plantas20.modelos;

public class Planta_Registrada {
    private int id_planta_registrada;
    private String nombre_planta_registrada;
    private String tipo_planta;
    private String humedad;

    public Planta_Registrada(int id_planta_registrada, String nombre_planta_registrada, String tipo_planta, String humedad) {
        this.id_planta_registrada = id_planta_registrada;
        this.nombre_planta_registrada = nombre_planta_registrada;
        this.tipo_planta = tipo_planta;
        this.humedad = humedad;
    }

    public Planta_Registrada() {
    }

    public int getId_planta_registrada() {
        return id_planta_registrada;
    }

    public void setId_planta_registrada(int id_planta_registrada) {
        this.id_planta_registrada = id_planta_registrada;
    }

    public String getNombre_planta_registrada() {
        return nombre_planta_registrada;
    }

    public void setNombre_planta_registrada(String nombre_planta_registrada) {
        this.nombre_planta_registrada = nombre_planta_registrada;
    }

    public String getTipo_planta() {
        return tipo_planta;
    }

    public void setTipo_planta(String tipo_planta) {
        this.tipo_planta = tipo_planta;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }
}

