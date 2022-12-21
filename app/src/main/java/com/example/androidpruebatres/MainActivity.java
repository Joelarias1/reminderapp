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



    private void userValidado(){
        AdminBD DB = new AdminBD(MainActivity.this);
        String rut, contra;

        rut = tilRut.getEditText().getText().toString();
        contra = tilContra.getEditText().getText().toString();

        if(rut.isEmpty() || contra.isEmpty()){
            Toast.makeText(this, "Por favor rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            String query = "SELECT * FROM USERS WHERE RUT = ?";
            Cursor cursor = DB.getWritableDatabase().rawQuery(query, new String[]{rut});

            boolean contrasenaCorrecta = false;

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String rutFromDb = cursor.getString(cursor.getColumnIndex("RUT"));
                    @SuppressLint("Range") String contrasenaFromDb = cursor.getString(cursor.getColumnIndex("CONTRASENA"));
                    if (rut.equals(rutFromDb) && contra.equals(contrasenaFromDb)) {
                        contrasenaCorrecta = true;
                        break;
                    }

                } while (cursor.moveToNext());
            }

            if (contrasenaCorrecta == true) {
                // Iniciar sesión
                Toast.makeText(this, "La contraseña es correcta", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, recordatorios.class);
                intent.putExtra("RUT", rut);
                intent.putExtra("CONTRASEÑA", contra);

                startActivity(intent);

            } else {
                tilContra.setError("Contraseña incorrecta");
            }
        }
    }


    private void eventos(){
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userValidado();
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