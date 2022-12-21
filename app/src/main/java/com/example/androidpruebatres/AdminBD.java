package com.example.androidpruebatres;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NOMBRE = "BDUser.db";

    public AdminBD(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryUsers = "CREATE TABLE USERS (RUT TEXT PRIMARY KEY, NOMBRE TEXT, CONTRASENA TEXT, TOKEN TEXT)";
        String queryReminder = "CREATE TABLE REMINDER (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITULO TEXT, FECHA TEXT, IMPORTANCIA TEXT, OBSERVACION TEXT, LUGAR TEXT, FOREIGN KEY(RUT) REFERENCES USERS(RUT))";

        db.execSQL(queryUsers);
        db.execSQL(queryReminder);

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

    public void crearReminder(String RUT, String TITULO, String FECHA, String IMPORTANCIA, String OBSERVACION, String LUGAR){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put("RUT", RUT);
        data.put("TITULO", TITULO);
        data.put("FECHA", FECHA);
        data.put("IMPORTANCIA", IMPORTANCIA);
        data.put("OBSERVACION", OBSERVACION);
        data.put("LUGAR", LUGAR);

        long result= db.insert("REMINDER", null, data);
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}