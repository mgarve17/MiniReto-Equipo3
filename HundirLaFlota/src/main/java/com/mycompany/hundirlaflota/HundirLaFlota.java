/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hundirlaflota;

import java.util.Scanner;

/**
 *
 * @author DAM112
 */
public class HundirLaFlota {

    public static void main(String[] args) {

        //variables
        int opcion;//opcion del switch
        boolean salir = false;

        //mostrar tablero para pruebas
        Tablero prueba = new Tablero();
        System.out.println(prueba.mostrar());

        //crear flota
        Barco[] flota = new Barco[4];

        do {//MENU REPETITIVO

            //opciones temporales
            System.out.println("1. Comenzar partida");
            System.out.println("2. Colocar barcos");
            System.out.println("3. atacar");
            System.out.println("4. salir");

            opcion = new Scanner(System.in).nextInt();

            switch (opcion) {

                case 1 -> {//iniciar partida (crea la flota del jugador)

                    flota[0] = new Barco("Portaviones", 5);
                    flota[1] = new Barco("Acorazado", 4);
                    flota[2] = new Barco("Destructor", 3);
                    flota[3] = new Barco("submarino", 2);

                    System.out.println("FLOTA CREADA");
                    System.out.println("");
                }

                case 2 -> {//colocar barcos

                    for (int i = 0; i < flota.length; i++) {

                        System.out.println("Colocar " + flota[i].getNombre());
                        int fila = 0;
                        int columna = 0;
                        int posicion = 0; //1- horizontal 2-vertical

                        do {
                            System.out.println("1. Horizontal");
                            System.out.println("2. Vertical");
                            posicion = new Scanner(System.in).nextInt();

                        } while (posicion < 1 && posicion > 2);

                        do {
                            System.out.println(" Desde columna (1-10): ");
                            columna = new Scanner(System.in).nextInt();
                        } while (columna < 1 && columna > 10);

                        System.out.println("Desde fila (A-J): ");// añadir control de valores
                        char charColumna = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);

                        //devolver nº que corresponde con el char        
                        fila = flota[i].elegirChar(charColumna);

                        //contador para los espacios libres
                        int contadorEspacios = 0;

                        for (int j = 0; j < flota[i].getTamano(); j++) {

                            if (flota[i].validarCoordenadas(fila, columna, posicion)) {
                                contadorEspacios++;
                            }
                        }
                        
                        //si el contador de espacios vacios es igual al tamaño se puede colocar el barco
                        if (contadorEspacios==flota[i].getTamano()) {
         
                            //flota[i].colocar(fila, columna, posicion, flota[i].getTamano());
                            
                            for (int j = 0; j < flota[i].getTamano(); j++) {
                                flota[i].colocar(fila, columna, posicion);
                            }
                            
                        }

                     

                    }

                }

                case 3 -> {//atacar flota contraria

                }

                case 4 -> {//salir

                    salir = true;
                }
            }

        } while (!salir);

    }
}
