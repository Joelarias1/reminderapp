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
import java.util.List;


public class recordatorios extends AppCompatActivity {
    private TextView tvRut;
    private Button btnOpciones, btnNuevoEvento;
    private ListView ltvEvents;

    private ArrayAdapter<Reminder> adaptadorReminders;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);

        referencias();
        eventos();
        obtenerData();
        mostrarReminder();

    }

    private void obtenerData(){
        Intent actividadRecordatorio = getIntent();

        String rut = actividadRecordatorio.getStringExtra("RUT");
        String contrasena = actividadRecordatorio.getStringExtra("CONTRASENA");

        AdminBD DB = new AdminBD(recordatorios.this);
        String obtenerName = "SELECT * FROM USERS WHERE RUT = ?";
        Cursor cursor = DB.getWritableDatabase().rawQuery(obtenerName, new String[]{rut});

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("NOMBRE"));
            tvRut.setText("Bienvenido" + " " + nombre);
            DB.close();
        }

    }

    private void crearEventoActividad(){
        Intent actividadRecordatorio = getIntent();
        String rut = actividadRecordatorio.getStringExtra("RUT");

        if (rut != null){
            Intent creareventoAct = new Intent(this, creareventoActividad.class);
            creareventoAct.putExtra("RUT",rut);
            startActivity(creareventoAct);
        }else{
            Toast.makeText(this, "Error" +rut, Toast.LENGTH_SHORT).show();
            //Testing de RUT null por putExtra
        }

    }

    private void mostrarReminder(){
        Intent actividadRecordatorio = getIntent();
        String rut = actividadRecordatorio.getStringExtra("RUT");
        AdminBD db = new AdminBD(recordatorios.this);

        // Obtener la lista actualizada de recordatorios
        List<Reminder> listaReminders = db.getAllReminders(rut);

        // Crear un nuevo ArrayList con los títulos de los recordatorios
        ArrayList<String> listaTitulos = new ArrayList<>();
        for (Reminder reminder : listaReminders) {
            listaTitulos.add(reminder.getTitulo());
        }

        // Crear un nuevo ArrayAdapter con la lista actualizada de recordatorios
        ArrayAdapter<String> adaptadorEventos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTitulos);

        // Asignar el nuevo ArrayAdapter al ListView
        adaptadorEventos.notifyDataSetChanged();
        ltvEvents.setAdapter(adaptadorEventos);
        db.close();
    }




    private void irOpciones(){
        Intent actividadRecordatorio = getIntent();
        String rut = actividadRecordatorio.getStringExtra("RUT");

        if (rut != null){
            Intent opcionesAct = new Intent(this, opcionesActividad.class);
            opcionesAct.putExtra("RUT",rut);
            startActivity(opcionesAct);
        }else{
            Toast.makeText(this, "Error" +rut, Toast.LENGTH_SHORT).show();
            //Testing de RUT null por putExtra
        }

    }

    private void eventos(){
        btnNuevoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearEventoActividad();
            }
        });

        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irOpciones();
            }
        });

    }

    private void referencias(){
        tvRut = findViewById(R.id.tvRut);

        btnOpciones = findViewById(R.id.btnOpciones);
        btnNuevoEvento = findViewById(R.id.btnNuevoEvento);

        ltvEvents = findViewById(R.id.ltvEventos);
        ltvEvents.setAdapter(adaptadorReminders);

    }
}