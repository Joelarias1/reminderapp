package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

        referencias();
        mostrarRut();
        mostrarNombre();
        eventos();
    }



    private void mostrarRut(){
        Intent opcionesAct = getIntent();
        String rut = opcionesAct.getStringExtra("RUT");
        tvMostrarRut.setText("Rut de Usuario:" + " " + rut);
    }

    private void mostrarNombre(){
        AdminBD DB = new AdminBD(opcionesActividad.this);

        Intent opcionesAct = getIntent();
        String rut = opcionesAct.getStringExtra("RUT");
        String nombreObt = DB.getNameFromRut(rut);

        tvMostrarNombre.setText("Nombre de usuario:" + " " + nombreObt);
    }

    private void cambiarPass(){
        AdminBD DB = new AdminBD(opcionesActividad.this);

        Intent opcionesAct = getIntent();
        String rut = opcionesAct.getStringExtra("RUT");

        String contraObtenida = DB.getPasswordFromRut(rut);
        String contraActual = tilPassActual.getEditText().getText().toString();
        String contraNueva = tilPassNueva.getEditText().getText().toString();

        if (!contraActual.equals(contraObtenida)) {
            Toast.makeText(this, "Contrase??a incorrecta", Toast.LENGTH_SHORT).show();
        } else {
            if (contraObtenida.equals(contraNueva)) {
                Toast.makeText(this, "No puede ser la misma contrase??a", Toast.LENGTH_SHORT).show();
            } else {
                DB.cambiarContrasena(rut, contraActual, contraNueva);
                Toast.makeText(this, "Contrase??a actualizada", Toast.LENGTH_SHORT).show();
                DB.close();
            }
        }
    }

    private void eliminarUser(){
        Intent opcionesAct = getIntent();
        String rut = opcionesAct.getStringExtra("RUT");

        new AlertDialog.Builder(this)
                .setTitle("Eliminar mi usuario")
                .setMessage("??Quieres borrar TU usuario?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdminBD DB = new AdminBD(opcionesActividad.this);
                        DB.deleteUser(rut);
                        DB.close();
                        volverInicio();

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    private void volverInicio(){
        Intent volverInicio = new Intent(this, MainActivity.class);
        startActivity(volverInicio);
    }


    private void eventos (){
        btnCambiarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarPass();
            }
        });
        btnEliminarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarUser();
            }
        });
    }


    private void referencias(){
        btnCambiarPass = findViewById(R.id.btnCambiar);
        btnEliminarUser = findViewById(R.id.btnBorrarUser);

        tilPassActual = findViewById(R.id.tilPassActual);
        tilPassNueva = findViewById(R.id.tilNuevaPass);

        tvMostrarRut = findViewById(R.id.tvMostrarRut);
        tvMostrarNombre = findViewById(R.id.tvMostrarNombre);
    }

}