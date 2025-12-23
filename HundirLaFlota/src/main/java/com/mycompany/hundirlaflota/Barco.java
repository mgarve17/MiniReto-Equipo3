/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hundirlaflota;



/**
 *
 * @author DAM112
 */
public class Barco {

    private Tablero tablero;
    private String nombre;
    private int tamano;

    public Barco() {

    }

    public Barco(String nombre, int tamano) {

        this.nombre = nombre;
        this.tamano = tamano;
        this.tablero = new Tablero();
    }



    public String getNombre() {
        return nombre;
    }

    public int getTamano() {
        return tamano;
    }


}
