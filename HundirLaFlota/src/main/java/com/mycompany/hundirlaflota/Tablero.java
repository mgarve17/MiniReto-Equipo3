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

    //comprobar si hay un barco
    public boolean validarAtaque(int x, int y) {

        boolean validar = false;
        //char para el barco en ascii
        char barcoChar = 79;

        if (tablero[x][y].contains(barcoChar + "")) {

            validar = true;
        }

        return validar;
    }

    //atacar segun las coordea
    public void ataque(int x, int y) {
        //ascii para el barco tocado
        char tocadoChar = 157;
        tablero[x][y] = tocadoChar + "";
    }

    public void agua(int x, int y) {

        //ascii para el agua
        char aguaChar = 126;

        tablero[x][y] = aguaChar + "";
    }

    //colocar el barco según coordenadas
    public void colocarBarco(int x, int y, int z, int tamano) {

        int contador = 0;
        //char para el barco en ascii
        char barcoChar = 79;

        do {
            if (z == 1) {//en horizontal
                tablero[x][y + contador] = barcoChar + "";
                contador++;

            } else if (z == 2) {//en vertical

                tablero[x + contador][y] = barcoChar + "";
                contador++;
            }
        } while (contador <= tamano);
    }
    
    //restar vida cuando se recibe un ataque
    public int restarHP(int hp){
    
        hp--; //restar una vida
        
        return hp;
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
