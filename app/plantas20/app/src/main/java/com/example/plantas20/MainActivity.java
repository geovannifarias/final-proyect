package com.example.plantas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText enUsuario;
    private EditText enPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id de nombre, apellido ,contraseña
        enUsuario =findViewById(R.id.enUsuario);
        enPassword =findViewById(R.id.enPassword);
    }

    // boton que permite ingresar a la aplicacion con contraseña y usuario
    public void ingresar(View view){
        if(validar()){
            Intent i = new Intent(this, Principal.class);
            startActivity(i);
        }

    }

    //boton que permite registrar al usuario en la aplicacion
    public void registrar(View view){
        Intent i = new Intent(this, Registrar.class);
        startActivity(i);
    }





    //validacion
    public boolean validar ()
    {
        boolean retorno=true;

        String Usuario= enUsuario.getText().toString();
        String Password=enPassword.getText().toString();
        if(Usuario.isEmpty())
        {
            enUsuario.setError("Debes ingresar un Usuario");
            retorno=false;

        }
        if(Password.isEmpty())
        {
            enPassword.setError("Debes ingresar un Password");
            retorno=false;

        }

        return retorno;

    }
}