package com.example.plantas20.modelos;

import android.widget.EditText;

public class Usuario {

    public String nombreUsuario;
    public String userUsuario;
    public String contraseñaUsuario;

    public Usuario(String nombreUsuario, String userUsuario, String contraseñaUsuario){
        this.nombreUsuario = nombreUsuario;
        this.userUsuario = userUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }
    public Usuario(){}

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }
}
