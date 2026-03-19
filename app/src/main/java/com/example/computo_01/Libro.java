package com.example.computo_01;

public class Libro {

    String nombreLibro;
    String nombreEstudainte;
    String categoria;
    String estado;
    int img;

    String sms;

    public Libro(){}

    public Libro(String nombreLibro, String nombreEstudainte, String estado, String categoria) {
        this.nombreLibro = nombreLibro;
        this.nombreEstudainte = nombreEstudainte;
        this.estado = estado;
        this.categoria = categoria;
    }
    public Libro(String nombreLibro, String nombreEstudainte, String estado, String categoria,int img) {
        this.nombreLibro = nombreLibro;
        this.nombreEstudainte = nombreEstudainte;
        this.estado = estado;
        this.categoria = categoria;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "categoria='" + categoria + '\'' +
                ", nombreLibro='" + nombreLibro + '\'' +
                ", nombreEstudainte='" + nombreEstudainte + '\'' +
                ", estado='" + estado + '\'' +
                ", sms='" + sms + '\'' +
                '}';
    }
}
