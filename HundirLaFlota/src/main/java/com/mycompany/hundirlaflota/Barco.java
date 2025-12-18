/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author DAM112
 */
public class Barco {

    private Tablero tablero;
    private String nombre;
    private int tamano;
    private boolean estado;// hundido = true, tocado/no descubierto = false

    public Barco() {

    }

    public Barco(String nombre, int tamano) {

        this.nombre = nombre;
        this.tamano = tamano;
        this.tablero= new Tablero();
    }

    public void colocar(int x, int y, int z) {//colocar barco

        int contador = 0;
        
        do{
        if (z == 1) {//en horizontal
            
            tablero.colocarBarco(x , y + contador);
            contador++;
            
        } else if (z == 2){//en vertical
        
            tablero.colocarBarco(x + contador, y );
            contador++;
        }
        } while(contador <= tamano);
        
        System.out.println(tablero.mostrar());
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

    public int elegirChar(char charColumna) {

        int columna = 0;
        switch (charColumna) {

            case 'A' -> {
                columna = 1;
            }
            case 'B' -> {
                columna = 2;
            }
            case 'C' -> {
                columna = 3;
            }
            case 'D' -> {
                columna = 4;
            }
            case 'E' -> {
                columna = 5;
            }
            case 'F' -> {
                columna = 6;
            }
            case 'G' -> {
                columna = 7;
            }
            case 'H' -> {
                columna = 8;
            }
            case 'I' -> {
                columna = 9;
            }
            case 'J' -> {
                columna = 10;
            }
            default -> {
                System.out.println("ERROR");
            }

        }

        return columna;
    }

    public void atacar() {//meter una coordenada para atacar

    }

    public String getNombre() {
        return nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean isEstado() {
        return estado;
    }

}
