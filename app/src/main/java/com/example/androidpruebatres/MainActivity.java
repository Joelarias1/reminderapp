package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilRut, tilContra;
    private Button btnIngresar, btnRegistrar, btnRecuperar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
    }


    private void registrarAct(){
        Intent registrarAct = new Intent(this, registrarActividad.class);
        startActivity(registrarAct);
    }

    private void obtenerRut(){
        AdminBD DB = new AdminBD(MainActivity.this);
        String rut, contrasena;
        boolean found = false;

        rut = tilRut.getEditText().getText().toString();

        String query = "SELECT * FROM USERS WHERE RUT = ?";
        Cursor cursor = DB.getWritableDatabase().rawQuery(query, new String[]{rut});



        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String rutFromDb = cursor.getString(cursor.getColumnIndex("RUT"));
                if (rut.equals(rutFromDb)) {
                    found = true;
                    break;
                }
            } while (cursor.moveToNext());
        }

        if (found) {
            // Se encontró un registro con el rut ingresado por el usuario

            Toast.makeText(this, "usuario encontrado", Toast.LENGTH_SHORT).show();
        } else {
            // No se encontró ningún registro con el rut ingresado por el usuario

            Toast.makeText(this, "Rut no existe, registrarse", Toast.LENGTH_SHORT).show();
        }

    }





    private void eventos(){
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerRut();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarAct();
            }
        });
    }


    private void referencias() {
        tilContra = findViewById(R.id.tilContra);
        tilRut = findViewById(R.id.tilRut);

        btnRecuperar = findViewById(R.id.btnRecuperar);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }



}