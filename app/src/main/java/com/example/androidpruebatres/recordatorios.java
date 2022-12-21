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
        Intent actividadRecordatorio = getIntent();

        String rut = actividadRecordatorio.getStringExtra("RUT");
        String contrasena = actividadRecordatorio.getStringExtra("CONTRASENA");

        Toast.makeText(this, "Rut:" + rut, Toast.LENGTH_SHORT).show();

    }



}