package com.example.plantas20.modelos;

public class Planta extends Usuario {
    private int id_planta;
    private String nombre_planta;
    private String tipo_planta;
    private String humedad;

    public Planta(String nombreUsuario, String userUsuario, String contraseñaUsuario, int id_planta, String nombre_planta, String tipo_planta, String humedad) {
        super(nombreUsuario, userUsuario, contraseñaUsuario);
        this.id_planta = id_planta;
        this.nombre_planta = nombre_planta;
        this.tipo_planta = tipo_planta;
        this.humedad = humedad;
    }

    public Planta() {
    }

    //getter and setter
    public int getId_planta() {
        return id_planta;
    }

    public void setId_planta(int id_planta) {
        this.id_planta = id_planta;
    }

    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
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

    @Override
    public String toString(){
        return nombre_planta;
    }
}

