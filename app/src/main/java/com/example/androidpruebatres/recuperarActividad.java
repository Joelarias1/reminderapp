package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

public class recuperarActividad extends AppCompatActivity {
    private TextInputLayout tilToken, tilRut;
    private TextView tvMostrarPass;
    private Button btnRecuperarpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_actividad);

        referencias();
        eventos();
    }


    private void validarTokenYMostrarContrasena() {
        AdminBD DB = new AdminBD(recuperarActividad.this);
        String rut = tilRut.getEditText().getText().toString();
        String tokenIngresado = tilToken.getEditText().getText().toString();

        // Obtener el token del usuario a partir de su RUT
        String tokenObtenido = DB.getTokenFromRut(rut);

        if (tokenObtenido.equals(tokenIngresado)) {
            // Si el token es válido, obtener la contraseña del usuario
            String contrasena = DB.getPasswordFromRut(rut);
            tvMostrarPass.setText("Su contraseña es" + " " + contrasena);
        } else {
            // Si el token no es válido, mostrar mensaje de error
            tvMostrarPass.setText("Token Invalido");
        }
    }

    private void eventos(){
        btnRecuperarpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarTokenYMostrarContrasena();
            }
        });
    }

    private void referencias(){
        tilRut = findViewById(R.id.tilRutRecuperar);
        tilToken = findViewById(R.id.tilTokenRecuperar);

        tvMostrarPass = findViewById(R.id.tvMostrarPass);
        btnRecuperarpass = findViewById(R.id.btnRecuperarPass);
    }

}