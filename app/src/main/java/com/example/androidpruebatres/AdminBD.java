package com.example.androidpruebatres;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "BDD.db";

    public AdminBD(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table USERS(NOMBRE TEXT, RUT TEXT PRIMARY KEY, CONTRASENA TEXT, TOKEN TEXT)");

    }

    public boolean crearUser(String RUT, String NOMBRE, String CONTRASENA, String TOKEN ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put("NOMBRE",NOMBRE);
        data.put("CONTRASENA", CONTRASENA);
        data.put("RUT", RUT);
        data.put("TOKEN", TOKEN);

        long result= db.insert("USERS",null,data);

        if(result==-1){
            return false;
        }else {
            return true;

        }
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}