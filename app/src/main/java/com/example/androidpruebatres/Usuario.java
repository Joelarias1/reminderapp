package com.example.androidpruebatres;

public class Usuario {
    private String nombre;
    private String rut;
    private String contrasena;
    private String token;

    public Usuario(String nombre, String rut, String contrasena, String token) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasena = contrasena;
        this.token = token;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contrasena;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken(){ return  token; }



}


