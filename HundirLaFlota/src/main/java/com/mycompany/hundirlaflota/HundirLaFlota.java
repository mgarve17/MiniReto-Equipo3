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
        int hpJ1 = 0;//vidas de los jugadores

        //mostrar tablero para pruebas
        Tablero pruebas = new Tablero();
        pruebas.colocarBarco(1, 1, 1, 3);

        //tablero del jugador 1
        Tablero tablero1 = new Tablero();

        //tablero de jugador 2 
        Tablero tablero2 = new Tablero();

        //tableros auxiliares para visualizar los movimientos
        Tablero tableroAux1 = new Tablero();
        Tablero tableroAux2 = new Tablero();

        //crear flota
        Barco[] flota = new Barco[4];
        flota[0] = new Barco("Portaviones", 5);
        flota[1] = new Barco("Acorazado", 4);
        flota[2] = new Barco("Destructor", 3);
        flota[3] = new Barco("submarino", 2);
        
        //calcular vidas según el tamaño total de todos los barcos
        for (int i = 0; i < flota.length; i++) {
            
            hpJ1 += flota[i].getTamano();
        }
        
        
        int hpJ2 = hpJ1;//mismo valor para el jugador dos
        

        do {//MENU REPETITIVO

            //opciones temporales
            System.out.println("1. Comenzar partida (NO USAR)");
            System.out.println("2. Colocar barcos");
            System.out.println("3. atacar");
            System.out.println("4. salir");

            opcion = new Scanner(System.in).nextInt();

            switch (opcion) {

                case 1 -> {//elegir modo

                }

                case 2 -> {//colocar barcos
                    //contador para los espacios libres
                    int contadorEspacios = 0;

                    //variables
                    int fila = 0;
                    int columna = 0;
                    int posicion = 0; //1- horizontal 2-vertical
                    char charColumna;

                    for (int i = 0; i < flota.length; i++) {

                        do {
                            System.out.println("Colocar " + flota[i].getNombre());

                            do {//pedir orientacion
                                System.out.println("1. Horizontal");
                                System.out.println("2. Vertical");
                                posicion = new Scanner(System.in).nextInt();

                            } while (posicion < 1 && posicion > 2);

                            do {//pedir nº columna
                                System.out.println(" Desde columna (1-10): ");
                                columna = new Scanner(System.in).nextInt();
                            } while (columna < 1 && columna > 10);

                            do {//pedir letra de la fila

                                System.out.println("Desde fila (A-J): ");// hay añadir control de valores
                                charColumna = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
                                //devolver nº que corresponde con el char        
                                fila = elegirChar(charColumna);

                            } while (charColumna != 'A' && charColumna != 'B' && charColumna != 'C' && charColumna != 'D'
                                    && charColumna != 'E' && charColumna != 'F' && charColumna != 'F' && charColumna != 'G'
                                    && charColumna != 'H' && charColumna != 'I' && charColumna != 'J');

                            for (int j = 0; j < flota[i].getTamano(); j++) {

                                if (flota[i].validarCoordenadas(fila, columna, posicion)) {
                                    contadorEspacios++;
                                }
                            }
                        } while (contadorEspacios != flota[i].getTamano());

                        //si el contador de espacios vacios es igual al tamaño se puede colocar el barco
                        if (contadorEspacios == flota[i].getTamano()) {

                            for (int j = 0; j < flota[i].getTamano(); j++) {

                                tablero1.colocarBarco(fila, columna, posicion, flota[i].getTamano());
                            }

                        }

                        //mostrar tablero después de colocar el barco
                        System.out.println(tablero1.mostrar());

                    }

                }

                case 3 -> {//atacar flota contraria

                    int fila = 0;
                    int columna = 0;
                    char charColumna;
                    
                    boolean finPartida = false;

                    do {//repetir turnos hasta que se finPartida=true;
                        
                        boolean turno = true;
                        do {//TURNO J1 hacer una accion por turno de J1. turno = false si falla el ataque

                            do {//pedir nº columna
                                System.out.println(" Desde columna (1-10): ");
                                columna = new Scanner(System.in).nextInt();
                            } while (columna < 1 && columna > 10);

                            do {//pedir letra de la fila

                                System.out.println("Desde fila (A-J): ");// hay añadir control de valores
                                charColumna = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
                                //devolver nº que corresponde con el char        
                                fila = elegirChar(charColumna);

                            } while (charColumna != 'A' && charColumna != 'B' && charColumna != 'C' && charColumna != 'D'
                                    && charColumna != 'E' && charColumna != 'F' && charColumna != 'F' && charColumna != 'G'
                                    && charColumna != 'H' && charColumna != 'I' && charColumna != 'J');

                            //comprobar que hay en las coordenadas del tablero contrario
                            if (tablero2.validarAtaque(fila, columna)) {//si hay un barco

                                //marcar ataque en el tablero auxiliar
                                tableroAux1.ataque(fila, columna);
                                //restarle vida al J2
                                hpJ2 = tablero2.restarHP(hpJ2);
                                
                                System.out.println("BARCO TOCADO");
                                
                                

                                //marcar ataque en el tablero del otro jugador
                                tablero2.ataque(fila, columna);
                                turno = true;

                            } else {//si hay agua

                                //marcar agua en el tablero auxiliar
                                tableroAux1.agua(fila, columna);
                                turno = false;

                                System.out.println("AGUA");
                                System.out.println("FIN DE TURNO");
                            }

                        } while (turno);

                        //restaurar turno para J2
                        turno = true;

                        do {//TURNO J2

                            do {//pedir nº columna
                                System.out.println(" Desde columna (1-10): ");
                                columna = new Scanner(System.in).nextInt();
                            } while (columna < 1 && columna > 10);

                            do {//pedir letra de la fila

                                System.out.println("Desde fila (A-J): ");// hay añadir control de valores
                                charColumna = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
                                //devolver nº que corresponde con el char        
                                fila = elegirChar(charColumna);

                            } while (charColumna != 'A' && charColumna != 'B' && charColumna != 'C' && charColumna != 'D'
                                    && charColumna != 'E' && charColumna != 'F' && charColumna != 'F' && charColumna != 'G'
                                    && charColumna != 'H' && charColumna != 'I' && charColumna != 'J');

                            //comprobar que hay en las coordenadas del tablero contrario
                            if (tablero1.validarAtaque(fila, columna)) {//si hay un barco

                                //marcar ataque en el tablero auxiliar
                                tableroAux2.ataque(fila, columna);

                                //marcar ataque en el tablero del otro jugador
                                tablero1.ataque(fila, columna);
                                turno = true;

                            } else {//si hay agua

                                //marcar agua en el tablero auxiliar
                                tableroAux2.agua(fila, columna);
                                turno = false;

                            }

                        } while (turno);

                    } while (!finPartida);
                }

                case 4 -> {//salir

                    salir = true;
                }
            }

        } while (!salir);

    }

    public static int elegirChar(char charColumna) {

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
}
