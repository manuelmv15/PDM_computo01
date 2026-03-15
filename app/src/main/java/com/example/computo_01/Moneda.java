package com.example.computo_01;

public class Moneda {

    String nombre;

    public double valor;

    public Moneda(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
