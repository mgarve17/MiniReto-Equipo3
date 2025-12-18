/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hundirlaflota;

/**
 *
 * @author DAM112
 */
public class Tablero {

    private String[][] tablero;

    //constructor
    public Tablero() {

        tablero = new String[11][11];// 10x10 jugable + 1 fila y  1 columna de coordenadas

        //rellenar el tablero con *
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {

                tablero[i][j] = "*";

            }
        }

        //poner la posicion [0][0] en blanco
        tablero[0][0] = " ";

        //sustituir primera fila con nº del 1 al 10
        int contador = 1;
        for (int i = 1; i < tablero.length; i++) {

            tablero[0][i] = contador + "";//meter valor de contador
            contador++;
        }

        //sustitur la primera columna con letras de la A a la J
        char letra = 65;//ascii para A
        for (int i = 1; i < tablero.length; i++) {

            tablero[i][0] = letra + "";//meter valor de contador
            letra++;
        }
    }

    public boolean validarEspacio(int x, int y) {//validar si el hueco está ocupado

        boolean validar = false;

        if (tablero[x][y].contains("*")) {

            validar = true;
        }

        return validar;

    }

    //colocar el barco según coordenadas
    public void colocarBarco(int x, int y) {

        //char para el barco en ascii
        char barcoChar = 254;

        tablero[x][y] = barcoChar + "";
    }

    //mostrar tablero por pantalla
    public String mostrar() {

        String cadena = "";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {

                if (j == tablero.length - 1) {

                    cadena += tablero[i][j] + "\n";

                } else if (j < tablero.length) {
                    cadena += tablero[i][j] + " ";
                }

            }

        }

        return cadena;

    }

}
