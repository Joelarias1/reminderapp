package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        tvRut.setText("Hola" + "" + rut);

    }


    private void referencias(){
        tvRut = findViewById(R.id.tvRut);
    }

}