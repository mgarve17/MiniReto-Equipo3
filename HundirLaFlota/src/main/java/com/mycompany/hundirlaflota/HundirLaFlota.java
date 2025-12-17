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

        //crear flota
        Barco[] flota = new Barco[4];

        do {

            System.out.println("1. Comenzar partida");
            System.out.println("2. Colocar barcos");
            System.out.println("3. atacar");

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

                }

                case 3 -> {//atacar flota contraria

                }
                
                case 4 -> {//salir
                
                    salir = true;
                } 
            }

        } while (!salir);

        //mostrar tablero para pruebas
        Tablero prueba = new Tablero();
        System.out.println(prueba.mostrar());
    }
}
