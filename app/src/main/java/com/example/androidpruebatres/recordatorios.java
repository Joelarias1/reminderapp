package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class recordatorios extends AppCompatActivity {
    private TextView tvRut;
    private Button btnCambiarPass, btnNuevoEvento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);

        referencias();
        eventos();
        obtenerData();

    }

    private void obtenerData(){
        Intent actividadRecordatorio = getIntent();

        String rut = actividadRecordatorio.getStringExtra("RUT");
        String contrasena = actividadRecordatorio.getStringExtra("CONTRASENA");

        AdminBD DB = new AdminBD(recordatorios.this);
        String obtenerName = "SELECT * FROM USERS WHERE RUT = ?";
        Cursor cursor = DB.getWritableDatabase().rawQuery(obtenerName, new String[]{rut});

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("NOMBRE"));
            tvRut.setText("Bienvenido" + " " + nombre);
        }

    }

    private void crearEvento(){
        Intent actividadRecordatorio = getIntent();

        AdminBD DB = new AdminBD(recordatorios.this);
        String rut = actividadRecordatorio.getStringExtra("RUT");
        DB.createReminder("Titulo del recordatorio", "2022-12-21", "Alta", "Observaciones del recordatorio", "Lugar del recordatorio", rut);

    }

    private void eventos(){
        btnNuevoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearEvento();
            }
        });
    }

    private void referencias(){
        tvRut = findViewById(R.id.tvRut);

        btnCambiarPass = findViewById(R.id.btnNuevaPass);
        btnNuevoEvento = findViewById(R.id.btnNuevoEvento);


    }

}