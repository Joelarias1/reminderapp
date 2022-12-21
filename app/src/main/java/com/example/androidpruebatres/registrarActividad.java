package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.database.Cursor;


import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class registrarActividad extends AppCompatActivity {
    private TextInputLayout tilRut, tilNombre, tilContra, tilToken;
    private Button btnNuevoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_actividad);

        referencias();
        eventos();
        poblar();


    }

    private void poblar(){
        AdminBD DB = new AdminBD(registrarActividad.this);
        DB.crearUser("2000", "joel", "3234","234235");
        DB.crearUser("2001240", "juan", "3453534","34235");
    }


    private void guardarUser(){
        AdminBD DB = new AdminBD(registrarActividad.this);
        String rut, nombre, contrasena, token;

        rut = tilRut.getEditText().getText().toString();
        nombre = tilNombre.getEditText().getText().toString();
        contrasena = tilContra.getEditText().getText().toString();
        token = tilToken.getEditText().getText().toString();

        if (nombre.isEmpty()){
            tilNombre.setError("No puede dejar el campo vacío");
        }

        if (rut.isEmpty()){
            tilRut.setError("No puede dejar el campo vacío");
        }

        if(contrasena.isEmpty()){
            tilContra.setError("No puede dejar el campo vacío");
        }

        if(token.isEmpty()){
            tilToken.setError("No puede dejar el campo vacío");
        }

        else{

            Boolean checkData = DB.crearUser(rut, nombre, contrasena, token);
            if (checkData== true){
                Toast.makeText(this, "User creado exitosamente", Toast.LENGTH_SHORT).show();
                Intent volverAct = new Intent(this, MainActivity.class);
                startActivity(volverAct);

            }else {
                Toast.makeText(this, "Rut ya existe", Toast.LENGTH_SHORT).show();
            }
        }
    }






    private void eventos(){
        btnNuevoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarUser();
            }
        });

    }

    private void referencias(){
        tilToken = findViewById(R.id.tilToken);
        tilNombre = findViewById(R.id.tilNombre);
        tilContra = findViewById(R.id.tilContra);
        tilRut = findViewById(R.id.tilRut);

        btnNuevoUser = findViewById(R.id.btnNuevouser);
    }





}