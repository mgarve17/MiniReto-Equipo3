/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hundirlaflota;

import java.util.Random;
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
        Random random = new Random();//decisiones aleatorias de la ia

        //tablero del jugador 1
        Tablero tablero1 = null;

        //tablero de jugador 2 
        Tablero tablero2 = null;

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
            System.out.println("1. Colocar barcos");
            System.out.println("2. Comenzar partida");
            System.out.println("3. salir");

            opcion = new Scanner(System.in).nextInt();

            switch (opcion) {

                case 1 -> {//colocar barcos
                    //contador para los espacios libres
                    int contadorEspacios = 0;

                    //variables
                    int fila = 0;
                    int columna = 0;
                    int posicion = 0; //1- horizontal 2-vertical
                    char charColumna;

                    //COLOCAR BARCOS JUGADOR 1
                    tablero1 = new Tablero();
                    System.out.println("\tTABLERO JUGADOR 1\n" + tablero1.mostrar());
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
                                contadorEspacios = 0;//resetear contador
                            }

                        } else {

                            System.out.println("No se puede colocar el barco en esas coordenadas");
                        }

                        //mostrar tablero después de colocar el barco
                        System.out.println("\tTABLERO JUGADOR 1\n" + tablero1.mostrar());

                    }

                    //BARCOS ALEATORIOS DE LA IA
                    tablero2 = new Tablero();
                    for (int i = 0; i < flota.length; i++) {

                        //variables 
                        int posicionRandom = random.nextInt(2) + 1;
                        int filaRandom = random.nextInt(10) + 1;
                        int columnaRandom = random.nextInt(10) + 1;

                        do {
                            for (int j = 0; j < flota[i].getTamano(); j++) {

                                if (flota[i].validarCoordenadas(filaRandom, columnaRandom, posicionRandom)) {
                                    contadorEspacios++;
                                }
                            }
                        } while (contadorEspacios != flota[i].getTamano());

                        if (contadorEspacios == flota[i].getTamano()) {

                            for (int j = 0; j < flota[i].getTamano(); j++) {

                                tablero2.colocarBarco(filaRandom, columnaRandom, posicionRandom, flota[i].getTamano());
                                contadorEspacios = 0;//resetear contador
                            }

                        } else {

                            System.out.println("No se puede colocar el barco en esas coordenadas");
                        }

                    }

                    // BORRAR   mostrar tablero de la ia 
                    System.out.println("\tTABLERO IA\n" + tablero2.mostrar());

                }

                case 2 -> {//atacar flota contraria

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

                                System.out.println("--BARCO TOCADO--");

                                //marcar ataque en el tablero del otro jugador
                                tablero2.ataque(fila, columna);
                                turno = true;

                                //si la vida llega a 0 se termina la partida
                                if (hpJ2 == 0) {

                                    System.out.println("FIN DE PARTIDA. \n JUGADOR 1 GANA");
                                    finPartida = true;

                                }

                            } else {//si hay agua

                                //marcar agua en el tablero auxiliar
                                tableroAux1.agua(fila, columna);
                                turno = false;

                                System.out.println("AGUA");
                                System.out.println("--FIN DE TURNO--");
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
                                //restar vida a J1
                                hpJ1 = tablero2.restarHP(hpJ1);

                                System.out.println("--BARCO TOCADO--");

                                //si la vida llega a 0 se termina la partida
                                if (hpJ1 == 0) {

                                    System.out.println("FIN DE PARTIDA. \n JUGADOR 2 GANA");
                                    finPartida = true;

                                }

                            } else {//si hay agua

                                //marcar agua en el tablero auxiliar
                                tableroAux2.agua(fila, columna);
                                turno = false;

                                System.out.println("AGUA");
                                System.out.println("--FIN DE TURNO--");

                            }

                        } while (turno);

                    } while (!finPartida);
                }

                case 3 -> {//salir

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
