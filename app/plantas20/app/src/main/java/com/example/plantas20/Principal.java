package com.example.plantas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.plantas20.modelos.Planta;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    //lista
    private List<Planta> listPlant = new ArrayList<Planta>();
    ArrayAdapter<Planta> arrayAdapterPlant;

    ListView listaPlanta;
    //llamado de fire base
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //lista
        listaPlanta = findViewById(R.id.Dplanta);
        //fire base
        iniciarFireBase();
        // lista
        listarDatos();
    }

    //listar datos
    private void listarDatos(){
        databaseReference.child("Planta").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPlant.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Planta e = objSnaptshot.getValue(Planta.class);
                    listPlant.add(e);

                    arrayAdapterPlant = new ArrayAdapter<Planta>(Principal.this, android.R.layout.simple_list_item_1,listPlant);
                    listaPlanta.setAdapter(arrayAdapterPlant);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //inicio fire base
    private void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }













    //es para hacer que el menu se extienda hacia abajo
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }



    // agregamos las funciones al menu para que cuando lo apretemos nos lleve a las distintas vistas
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.perfil) {
            Intent i = new Intent(this, perfil.class);
            finish();
            startActivity(i);
        }else if(id == R.id.principal){
            Toast.makeText(this, "Ya se encuentra en esta ventana", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.salir){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    // boton que permite ir a agregar plantas
    public void agregar(View view){
        Intent i = new Intent(this, Agregar.class);
        finish();
        startActivity(i);
    }
    //boton que permite volver
    public void vol3(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void humedad(View view){
        Intent i = new Intent(this, Humedaad.class);
        finish();
        startActivity(i);
    }

}