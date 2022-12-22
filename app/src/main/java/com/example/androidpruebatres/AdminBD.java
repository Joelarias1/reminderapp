package com.example.androidpruebatres;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "BaseDatosAPP.db";


    public AdminBD(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (RUT TEXT PRIMARY KEY, NOMBRE TEXT, CONTRASENA TEXT, TOKEN TEXT)");
        db.execSQL("CREATE TABLE REMINDER (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITULO TEXT, FECHA TEXT, IMPORTANCIA TEXT, OBSERVACION TEXT, LUGAR TEXT, RUT TEXT, FOREIGN KEY(RUT) REFERENCES USERS(RUT))");
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
    }


    public String getPasswordFromRut(String rut) {
        SQLiteDatabase db = getReadableDatabase();
        String password = "";

        Cursor cursor = db.rawQuery("SELECT CONTRASENA FROM USERS WHERE rut = ?", new String[]{rut});
        if (cursor.moveToFirst()) {
            password = cursor.getString(0);
        }
        cursor.close();
        return password;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}