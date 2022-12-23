package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import com.google.android.material.textfield.TextInputLayout;

public class opcionesActividad extends AppCompatActivity {
    private Button btnCambiarPass, btnEliminarUser;
    private TextInputLayout tilPassActual, tilPassNueva;
    private TextView tvMostrarNombre, tvMostrarRut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_actividad);

        eventos();
        referencias();
        mostrarDatos();
    }



    private void mostrarDatos(){
        Intent opcionesAct = getIntent();
        String rut = opcionesAct.getStringExtra("RUT");
        tvMostrarRut.setText("Rut de Usuario:" + " " + rut);
    }

    private void eventos(){
    }


    private void referencias(){
        btnCambiarPass = findViewById(R.id.btnCambiar);
        btnEliminarUser = findViewById(R.id.btnBorrarUser);

        tilPassActual = findViewById(R.id.tilPassActual);
        tilPassNueva = findViewById(R.id.tilNuevaPass);

        tvMostrarRut = findViewById(R.id.tvMostrarRut);
    }

}