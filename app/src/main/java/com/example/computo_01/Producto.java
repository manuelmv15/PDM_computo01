package com.example.computo_01;

public class Producto {

    String nombre;

    public int cantidad;

    double precio;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString(){
        return nombre;
    }


    public double subTotal()
    {
        return  cantidad* precio;
    }
}
