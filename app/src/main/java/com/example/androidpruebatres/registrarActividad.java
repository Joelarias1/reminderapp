package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        DB.crearUser("2001240", "joel", "3234","234235");
        DB.crearUser("2001230", "joel", "3234","234235");
        DB.crearUser("20231200", "joel", "3234","234235");
    }


    private void guardarUser(){
        String rut, nombre, contrasena, token;

        rut = tilRut.getEditText().getText().toString();
        nombre = tilNombre.getEditText().getText().toString();
        contrasena = tilContra.getEditText().getText().toString();
        token = tilToken.getEditText().getText().toString();

        AdminBD DB = new AdminBD(registrarActividad.this);


        Boolean checkData = DB.crearUser("2000", "joel", "3234","234235");

        if (checkData== true){
            Toast.makeText(this, "User creado exitosamente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Fallido", Toast.LENGTH_SHORT).show();
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