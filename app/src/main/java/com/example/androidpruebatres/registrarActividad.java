package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class registrarActividad extends AppCompatActivity {
    private TextInputLayout tilRut, tilNombre, tilContra, tilToken;
    private Button btnNuevoUser;
    private ArrayList<Usuario> losUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_actividad);

        referencias();
        eventos();

    }

    private void guardarUser(){
        String rut = tilRut.getEditText().getText().toString();
        String nombre = tilNombre.getEditText().getText().toString();
        String contrasena = tilContra.getEditText().getText().toString();
        String token = tilToken.getEditText().getText().toString();

        Usuario usr = new Usuario(rut, nombre, contrasena, token);
        losUsuarios.add(usr);

        grabarBD(usr);

    }

    private void grabarBD(Usuario user){
        try{
            AdminBD adbd = new AdminBD(this,"BDAplicacion", null, 1);
            SQLiteDatabase miBD = adbd.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("rut", user.getRut());
            registro.put("nombre", user.getNombre());
            registro.put("contrasena", user.getContra());
            registro.put("token", user.getToken());

            miBD.insert("Usuario", null, registro);
            miBD.close();

        }catch (Exception ex){

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