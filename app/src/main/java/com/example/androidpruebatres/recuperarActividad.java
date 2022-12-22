package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class recuperarActividad extends AppCompatActivity {
    private TextInputLayout tilToken, tilRut;
    private Button btnVolver, btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_actividad);

        eventos();
        referencias();
    }


    private void eventos(){

    }

    private void referencias(){
        tilRut = findViewById(R.id.tilRutRecuperar);
        tilToken = findViewById(R.id.tilTokenRecuperar);

        btnRecuperar = findViewById(R.id.btnRecuperarPass);
        btnVolver = findViewById(R.id.btnVolver);
    }

}