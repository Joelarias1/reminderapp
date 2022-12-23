package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class creareventoActividad extends AppCompatActivity {
    private Button btnAgregar, btnAtras;
    private TextInputLayout tilTitulo, tilObs, tilFecha, tilLugar;
    private Spinner spnImportancia;

    //ArrayList
    private ArrayList<String> opciones = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearevento_actividad);

        referencias();
        eventos();
        spinnerOpciones();

    }

    private void spinnerOpciones(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        opciones.add("Normal");
        opciones.add("Importante");
        opciones.add("Muy importante");

        spnImportancia.setAdapter(adapter);
        spnImportancia.setSelection(0);
    }


    private void agregarEvento (){
        String rut, TITULO, FECHA, OBSERVACION, LUGAR, IMPORTANCIA;
        Intent creareventoAct = getIntent();
        rut = creareventoAct.getStringExtra("RUT");

        TITULO = tilTitulo.getEditText().getText().toString();
        FECHA = tilFecha.getEditText().getText().toString();
        OBSERVACION = tilObs.getEditText().getText().toString();
        LUGAR = tilLugar.getEditText().getText().toString();
        IMPORTANCIA = spnImportancia.getSelectedItem().toString();

        if (TITULO.isEmpty() || FECHA.isEmpty() || OBSERVACION.isEmpty() || LUGAR.isEmpty()){
            Toast.makeText(this, "Rellenar todos los campos" , Toast.LENGTH_SHORT).show();
        }else {
            AdminBD DB = new AdminBD(creareventoActividad.this);
            DB.createReminder(TITULO,FECHA,IMPORTANCIA, OBSERVACION, LUGAR, rut);
            DB.close();
            Toast.makeText(this, "Tarea creada" , Toast.LENGTH_SHORT).show();
        }
    }



    private void volver(){
        Intent volverMenu = new Intent(this, recordatorios.class);
        startActivity(volverMenu);
    }



    private void eventos(){
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarEvento();
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });


    }


    private void referencias(){
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAtras = findViewById(R.id.btnAtras);

        tilFecha = findViewById(R.id.tilFecha);
        tilLugar = findViewById(R.id.tilLugar);
        tilObs = findViewById(R.id.tilObs);
        tilTitulo = findViewById(R.id.tilTitulo);

        //Spinner
        spnImportancia = findViewById(R.id.spnImportancia);

    }

}