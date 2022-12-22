package com.example.androidpruebatres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;


public class recuperarpassActivity extends AppCompatActivity {
    private TextInputLayout rutRecuperar, tokenRecuperar, passRecuperar;
    private Button btnNuevaPass, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperarpass);

        referencias();
        eventos();
    }

    private void volver(){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    private void recuperarCuenta(){
        AdminBD DB = new AdminBD(recuperarpassActivity.this);
        String rut, token, nuevaPass;

        rut = rutRecuperar.getEditText().getText().toString();
        token = tokenRecuperar.getEditText().getText().toString();


    }


    private void eventos(){
        btnNuevaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarCuenta();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });



    }


    private void referencias(){
        rutRecuperar = findViewById(R.id.tilRutRecuperar);
        passRecuperar = findViewById(R.id.tilNuevaPass);
        tokenRecuperar = findViewById(R.id.tilTokenRecuperar);


        btnNuevaPass = findViewById(R.id.btnNuevaPass);
        btnVolver = findViewById(R.id.btnVolver);
    }

}