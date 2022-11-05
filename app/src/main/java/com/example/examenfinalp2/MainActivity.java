package com.example.examenfinalp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenfinalp2.adaptadores.listausuarioAdapter;

import java.util.ArrayList;

import Entidades.usuarios;
import db.DbHelper;
import db.DbUsuarios;

public class MainActivity extends AppCompatActivity {

RecyclerView listausuarios;
ArrayList<usuarios> ListaArrayusuarios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listausuarios = (RecyclerView) findViewById(R.id.listausuario);
        listausuarios.setLayoutManager(new LinearLayoutManager(this));

        DbUsuarios dbUsuarios = new DbUsuarios(MainActivity.this);
        ListaArrayusuarios = new ArrayList<>();
       listausuarioAdapter adapter= new listausuarioAdapter(dbUsuarios.mostrarusuarios());
       listausuarios.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }
    public boolean  onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro () {
        Intent intent = new Intent(this, UsuarioActivity2.class);
        startActivity(intent);
    }
}

