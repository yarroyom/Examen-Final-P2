package com.example.examenfinalp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.DbUsuarios;

public class UsuarioActivity2 extends AppCompatActivity {

    EditText txtusuario, txtpassword;
    Button btnGuardar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario2);

        txtusuario=findViewById(R.id.txtusuario);
        txtpassword=findViewById(R.id.txtPassword);
        btnGuardar=findViewById(R.id.btnGuarda);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsuarios dbUsuarios= new DbUsuarios(UsuarioActivity2.this);
                long id = dbUsuarios.insertarUsuario(txtpassword.getText().toString(), (txtusuario.getText().toString()));
                if(id >0){
                    Toast.makeText(UsuarioActivity2.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else{
                    Toast.makeText(UsuarioActivity2.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void limpiar(){
        txtusuario.setText("");
        txtpassword.setText("");

    }
}