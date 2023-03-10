package com.example.androidpruebatres;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdminBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NOMBRE = "BaseDatosAPP.db";
    private List<Reminder> listaReminders;



    public AdminBD(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
        listaReminders = new ArrayList<>();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (RUT TEXT PRIMARY KEY, NOMBRE TEXT, CONTRASENA TEXT, TOKEN TEXT)");
        db.execSQL("CREATE TABLE REMINDER (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITULO TEXT, FECHA TEXT, IMPORTANCIA TEXT, OBSERVACION TEXT, LUGAR TEXT, RUT TEXT, FOREIGN KEY(RUT) REFERENCES USERS(RUT) ON DELETE CASCADE)");
    }


    public boolean crearUser(String RUT, String NOMBRE, String CONTRASENA, String TOKEN ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put("NOMBRE",NOMBRE);
        data.put("CONTRASENA", CONTRASENA);
        data.put("RUT", RUT);
        data.put("TOKEN", TOKEN);

        long result= db.insert("USERS",null,data);
        db.close();

        if(result==-1){
            return false;
            //Esto significa que no lo pudo insertar
        }else {
            return true;
            //Inserto el dato
        }
    }

    public void createReminder(String TITULO, String FECHA, String IMPORTANCIA, String OBSERVACION, String LUGAR, String RUT) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TITULO", TITULO);
        values.put("FECHA", FECHA);
        values.put("IMPORTANCIA", IMPORTANCIA);
        values.put("OBSERVACION", OBSERVACION);
        values.put("LUGAR", LUGAR);
        values.put("RUT", RUT);

        // Insertar la nueva fila en la tabla REMINDER
        db.insert("REMINDER", null, values);
        listaReminders = getAllReminders(RUT);

    }


    public String getPasswordFromRut(String rut) {
        SQLiteDatabase db = this.getReadableDatabase();
        String password = "";

        Cursor cursor = db.rawQuery("SELECT CONTRASENA FROM USERS WHERE rut = ?", new String[]{rut});
        if (cursor.moveToFirst()) {
            password = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return password;
    }


    @SuppressLint("Range")
    public String getTokenFromRut(String rut) {
        String token = "";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT token FROM users WHERE rut = ?", new String[]{rut});
        if (cursor.moveToFirst()) {
            token = cursor.getString(cursor.getColumnIndex("TOKEN"));
        }
        cursor.close();
        db.close();
        return token;
    }

    public void cambiarContrasena(String rut, String contrasenaActual, String nuevaContrasena) {
        SQLiteDatabase db = this.getWritableDatabase();
        String updateSql = "UPDATE " + "USERS" + " SET " + "CONTRASENA" + " = ? WHERE " + "RUT" + " = ? AND " + "CONTRASENA" + " = ?";
        db.execSQL(updateSql, new String[] {nuevaContrasena, rut, contrasenaActual});
        db.close();
    }


    @SuppressLint("Range")
    public String getNameFromRut(String rut) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + "NOMBRE" + " FROM " + "USERS" + " WHERE " + "RUT" + " = '" + rut + "'";
        Cursor cursor = db.rawQuery(query, null);

        String name = "";
        if (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndex("NOMBRE"));
        }
        cursor.close();
        db.close();
        return name;
    }


    public void deleteUser(String rut) {
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "RUT = ?";
        String[] selectionArgs = { rut };

        db.delete("USERS", selection, selectionArgs);
        listaReminders = getAllReminders(rut);
        db.close();
    }

    public List<Reminder> getAllReminders(String rut) {
        List<Reminder> listaReminders = new ArrayList<>();

        // Abre la base de datos en modo lectura
        SQLiteDatabase db = this.getReadableDatabase();

        // Define la consulta a realizar para obtener los eventos
        String query = "SELECT * FROM " + "REMINDER" + " WHERE " + "RUT" + " = ?";

        // Ejecuta la consulta y almacena el resultado en un cursor
        Cursor cursor = db.rawQuery(query, new String[] {rut});

        // Recorre el cursor y crea un evento para cada fila del resultado
        if (cursor.moveToFirst()) {
            do {
                Reminder reminder = new Reminder();
                reminder.setId(cursor.getInt(0));
                reminder.setTitulo(cursor.getString(1));
                reminder.setFecha(cursor.getString(2));
                reminder.setImportancia(cursor.getString(3));
                reminder.setObservacion(cursor.getString(4));
                reminder.setLugar(cursor.getString(5));
                reminder.setRut(cursor.getString(6));

                // Agrega el evento a la lista
                listaReminders.add(reminder);
            } while (cursor.moveToNext());
        }

        // Cierra el cursor y la base de datos
        cursor.close();
        db.close();

        // Devuelve la lista de eventos
        return listaReminders;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}