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

    public boolean validarCoordenadas(int x, int y, int z) {//validar que hay un hueco libre

        boolean validar = false;
        int contador = 0;

        if (z == 1) {//mover de izquierda a derecha y devolver true si está vacío
            if (tablero.validarEspacio(x, y + contador)) {
                validar = true;
                contador++;
            }
        } else if (z == 2) {//mover de arriba a abajo y devolver true si está vacío
            if (tablero.validarEspacio(x + contador, y)) {
                validar = true;
                contador++;
            }
        }

        //validar posicion
        return validar;

    }


    public String getNombre() {
        return nombre;
    }

    public int getTamano() {
        return tamano;
    }


}
