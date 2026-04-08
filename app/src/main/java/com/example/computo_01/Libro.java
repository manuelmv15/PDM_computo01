package com.example.computo_01;

public class Libro {
    int img;
    String nombre;
    String catgoria;


    public  Libro(){

    }

    public Libro( int img,String catgoria, String nombre) {
        this.img = img;
        this.catgoria = catgoria;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "catgoria='" + catgoria + '\'' +
                ", img=" + img +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
