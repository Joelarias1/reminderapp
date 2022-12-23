package com.example.androidpruebatres;

public class Reminder {
    private int id;
    private String titulo;
    private String fecha;
    private String importancia;
    private String observacion;
    private String lugar;
    private String rut;

    // Constructor de la clase Reminder
    public Reminder() {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.importancia = importancia;
        this.observacion = observacion;
        this.lugar = lugar;
        this.rut = rut;
    }

    // Métodos get y set para cada propiedad de la clase Reminder
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
