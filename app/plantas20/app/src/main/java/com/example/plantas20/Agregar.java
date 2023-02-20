package com.example.plantas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.plantas20.modelos.Planta;
import com.example.plantas20.modelos.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;

public class Agregar extends AppCompatActivity {
    //lista
    private List<Planta> listPlant = new ArrayList<Planta>();
    ArrayAdapter<Planta> arrayAdapterPlant;

    EditText planta, Tipo;
    ListView listaPlanta;

    //llamado de fire base
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    // actualizar
    Planta plantaSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        planta = findViewById(R.id.caja_text_Planta);
        Tipo = findViewById(R.id.caja_text_Tipo);
        //lista
        listaPlanta = findViewById(R.id.Dplanta);
        //fire base
        iniciarFireBase();
        // lista
        listarDatos();


        //metodo actualizar
        listaPlanta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                plantaSelected = (Planta) parent.getItemAtPosition(position);
                planta.setText(plantaSelected.getNombre_planta());
                Tipo.setText(plantaSelected.getTipo_planta());

            }
        });

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

                    arrayAdapterPlant = new ArrayAdapter<Planta>(Agregar.this, android.R.layout.simple_list_item_1,listPlant);
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


    //----Menu para Crud-------
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //parte del menu
    public boolean onOptionsItemSelected(MenuItem item){
        String nplanta =planta.getText().toString();
        String ntipo =Tipo.getText().toString();

        switch(item.getItemId()){
            case R.id.icon_add:
                if(nplanta.equals("") || ntipo.equals("")){
                    validacion();
                }else{
                    //metodo de agregar a fire base
                    Planta e = new Planta();
                    e.setNombre_planta(nplanta);
                    e.setTipo_planta(ntipo);
                    databaseReference.child("Planta").child(e.getNombre_planta()).setValue(e);
                    Toast.makeText(this,"Agregado",Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            case R.id.icon_save:
                //actualizar
                
                Planta o = new Planta();
                o.setNombre_planta(plantaSelected.getNombre_planta());
                o.setTipo_planta(Tipo.getText().toString().trim());
                databaseReference.child("Planta").child(o.getNombre_planta()).setValue(o);

                Toast.makeText(this,"Actualizado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.icon_delete:
                Planta Y= new Planta();
                Y.setNombre_planta(plantaSelected.getNombre_planta());
                databaseReference.child("Planta").child(Y.getNombre_planta()).removeValue();
                Toast.makeText(this,"Eliminado",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }

        return true;

    }
    private void limpiarCajas(){
        planta.setText("");
        Tipo.setText("");
    }

    private void validacion(){

        String nplanta =planta.getText().toString();
        String ntipo =Tipo.getText().toString();

        if(nplanta.equals("")){
            planta.setError("Required");
        }else if (ntipo.equals("")){
            Tipo.setError("Required");
        }
    }
    //-----termino de menu-------

















    //boton que permite volver
    public void volver1(View view){
        Intent i = new Intent(this,Principal.class);
        startActivity(i);
        finish();
    }


    // boton que permite ir a agregar plantas
    public void etPlanta(View view){
        Intent i = new Intent(this,Humedaad.class);
        startActivity(i);
        finish();
    }






}