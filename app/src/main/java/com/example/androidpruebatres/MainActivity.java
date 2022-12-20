package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilRut, tilNombre, tilContra;
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





    private void eventos(){
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        tilNombre = findViewById(R.id.tilNombre);
        tilRut = findViewById(R.id.tilRut);

        btnRecuperar = findViewById(R.id.btnRecuperar);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }



}