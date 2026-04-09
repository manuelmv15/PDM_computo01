package com.example.computo_01;

public class Producto {

    int id , img, cantidad ;

    String  nombre, categoria;

    double precio;


    public Producto() {
    }

    public Producto(String categoria, int id, int img, String nombre, double precio) {
        this.categoria = categoria;
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.precio = precio;
    }
}
