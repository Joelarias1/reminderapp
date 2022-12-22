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
    private Button btnAgregar;
    private TextInputLayout tilTitulo, tilObs, tilFecha, tilLugar;
    private Spinner spnImportancia;

    //ArrayList
    ArrayList<String> opciones = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearevento_actividad);

        referencias();
        eventos();
        poblarOpciones();

    }

    private void poblarOpciones(){
        opciones.add("Normal");
        opciones.add("Importante");
        opciones.add("Muy importante");

    }


    private void agregarEvento (){
        String rut, TITULO, FECHA, OBSERVACION, LUGAR, IMPORTANCIA;
        Intent creareventoAct = getIntent();
        rut = creareventoAct.getStringExtra("RUT");

        TITULO = tilTitulo.getEditText().getText().toString();
        FECHA = tilFecha.getEditText().getText().toString();
        OBSERVACION = tilObs.getEditText().getText().toString();
        LUGAR = tilLugar.getEditText().getText().toString();
        //IMPORTANCIA = spnImportancia.getSelectedItem().toString();


        AdminBD DB = new AdminBD(creareventoActividad.this);
        DB.createReminder(TITULO,FECHA,"Normal", OBSERVACION, LUGAR, rut);
        Toast.makeText(this, " " +rut, Toast.LENGTH_SHORT).show();

    }



    private void eventos(){
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarEvento();
            }
        });


    }


    private void referencias(){
        btnAgregar = findViewById(R.id.btnAgregar);

        tilFecha = findViewById(R.id.tilFecha);
        tilLugar = findViewById(R.id.tilLugar);
        tilObs = findViewById(R.id.tilObs);
        tilTitulo = findViewById(R.id.tilTitulo);

        //Spinner
        spnImportancia = findViewById(R.id.spnImportancia);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spnImportancia.setAdapter(adapter);


    }

}