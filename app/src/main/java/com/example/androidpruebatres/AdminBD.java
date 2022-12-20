package com.example.androidpruebatres;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "bdapp.db";
    private static final String TABLE_USUARIOS = "t_usuarios";

    public AdminBD(registrarActividad registrarActividad, String dbPrueba, @Nullable Context context, int i) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_USUARIOS + "(" +
                "RUT TEXT PRIMARY KEY," +
                "NOMBRE TEXT NOT NULL," +
                "CONTRASENA TEXT NOT NULL," +
                "TOKEN INTEGER NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}