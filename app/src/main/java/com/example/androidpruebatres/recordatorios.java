package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class recordatorios extends AppCompatActivity {
    private TextView tvRut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);

        referencias();
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
            tvRut.setText(nombre);
        }

    }


    private void referencias(){
        tvRut = findViewById(R.id.tvRut);
    }

}