package com.example.plantas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }
    //es para hacer que el menu se extienda hacia abajo
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // agregamos las funciones al menu para que cuando lo apretemos nos lleve a las distintas vistas
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.perfil){
            Toast.makeText(this, "Ya se encuentra en esta ventana", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.salir){
            finish();
        }else if(id == R.id.principal){
            Intent i = new Intent(this, Principal.class);
            finish();
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}