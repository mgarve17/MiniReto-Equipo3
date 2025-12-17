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
    }

    public void colocarIA() {//generación de barcos aleatoria

    }

    public void validarEspacio() {//colocar barco en el tablero

        int fila = 0;
        int columna = 0;
        int posicion = 0; //1- horizontal 2-vertical

        do {
            System.out.println("1. Horizontal");
            System.out.println("2. Vertical");
            System.out.println("Opcion: ");
            posicion = new Scanner(System.in).nextInt();

        } while (posicion != 1 && posicion != 2);

        System.out.println(" Desde fila (1-10): ");
        fila = new Scanner(System.in).nextInt();

        System.out.println("Desde columna (A-J): ");
        char charColumna = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);

        //asignar un valor numerico a la columna según la letra
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

        //validar posicion
//        if (tablero.validarEspacio(fila, columna, posicion)) {//si devuelve true coloca el barco TERMINAR
//            
//            tablero.colocarBarco(fila, columna, posicion);
//        }

    }

    public void atacar() {//meter una coordenada para atacar

        
    }

}
