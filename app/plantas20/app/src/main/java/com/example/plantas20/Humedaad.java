package com.example.plantas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Humedaad extends AppCompatActivity {
    Button CARGAR;
    TextView DATOS;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String URL = "https://green-health-c59bd-default-rtdb.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humedaad);
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance(URL);
        databaseReference = firebaseDatabase.getReference();

        CARGAR = findViewById(R.id.CARGAR);
        DATOS = findViewById(R.id.DATOS);

        //initFirebase();

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance(URL);
        databaseReference = firebaseDatabase.getReference();

        final Object[] O = {new Object()};

        CARGAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseDatabase.getReference().get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {

                        if (task.isSuccessful()) {
                            for (DataSnapshot ds : task.getResult().getChildren()) {
                                O[0] = task.getResult().getValue();

                                Log.d("TAG", O[0].toString());

                            }
                        }

                        List<?> lista;
                        lista = convertObjectToList(O);
                        String ar = lista.get(lista.size() - 1).toString();
                        DATOS.setText(ar);
                    }
                });
            }
        });

}
    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance(URL);
        databaseReference = firebaseDatabase.getReference();
    }
    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }
    //boton que permite volver
    public void volver1(View view){
        Intent i = new Intent(this,Principal.class);
        startActivity(i);
        finish();
    }

}