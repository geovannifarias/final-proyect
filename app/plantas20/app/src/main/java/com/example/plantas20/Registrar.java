package com.example.plantas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.plantas20.modelos.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrar extends AppCompatActivity {
    EditText nombre,
             nombre_usuario,
             contraseña,
             confirmar_contraseña;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nombre = findViewById(R.id.caja_text_nombre);
        nombre_usuario = findViewById(R.id.caja_text_nombre_usuario);
        contraseña = findViewById(R.id.caja_text_contraseña);
        confirmar_contraseña = findViewById(R.id.caja_text_confirmar_contraseña);
        iniciarFireBase();
        
    }
    private void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    // esto es para mandar la informacion
    public void sendData(View view){
        String nom = nombre.getText().toString();
        String user = nombre_usuario.getText().toString();
        String contra = contraseña.getText().toString();
        String confirmar = confirmar_contraseña.getText().toString();

        if(nom.equals("") || user.equals("") || contra.equals("") || confirmar.equals("")){
            validacion();
        }else if(contra.equals(confirmar)){
            Usuario u = new Usuario();
            u.setNombreUsuario(nom);
            u.setUserUsuario(user);
            u.setContraseñaUsuario(contra);

            Toast.makeText(this, "El usuario "+u.userUsuario + " ha sido agregado", Toast.LENGTH_SHORT).show();

            databaseReference.child("Usuario").child(u.getUserUsuario()).setValue(u);
            limpiarCajas();
        }else{
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();

        }


    }
    //boton que permite volver
    public void volver(View view){
        finish();
    }

    private void limpiarCajas(){
        nombre.setText("");
        nombre_usuario.setText("");
        contraseña.setText("");
        confirmar_contraseña.setText("");
    }
    private void validacion() {

        String nnombre = nombre.getText().toString();
        String nusuario = nombre_usuario.getText().toString();
        String ncontraseña = contraseña.getText().toString();
        String nconfirmar = confirmar_contraseña.getText().toString();

        if (nnombre.equals("")) {
            nombre.setError("Required");
        } else if (nusuario.equals("")) {
            nombre_usuario.setError("Required");
        } else if (ncontraseña.equals("")) {
            contraseña.setError("Required");
        } else if (nconfirmar.equals("")) {
            confirmar_contraseña.setError("Required");
        }
    }
}