package com.example.computo_01;

public class Productos {

    int id;

    String nombre;

    double  precio;

    public Productos() {

    }

    public Productos(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }


    @Override
    public String toString() {
        return  nombre;
    }

    public String txt(){
        return "Nombre-> "+ nombre+" precio: "+precio;
    }



}
