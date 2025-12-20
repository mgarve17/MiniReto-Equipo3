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

                case 1 -> { //colocar barcos

                    int contadorEspacios = 0;
                    //variables
                    int fila = 0;
                    int columna = 0;
                    int posicion = 0; //1- horizontal 2-vertical
                    char charColumna;
                    boolean siguiente = false;

                    //COLOCAR BARCOS JUGADOR 1
                    tablero1 = new Tablero();
                    System.out.println("\tTABLERO JUGADOR 1\n" + tablero1.mostrar());
                    for (int i = 0; i < flota.length; i++) {

                        do {
                            contadorEspacios = 0;
                            siguiente = false;

                            System.out.println("Colocar " + flota[i].getNombre());

                            do {//pedir orientacion
                                System.out.println("1. Horizontal");
                                System.out.println("2. Vertical");
                                posicion = new Scanner(System.in).nextInt();
                            } while (posicion < 1 || posicion > 2);

                            do {//pedir nº columna
                                System.out.println(" Desde columna (1-10): ");
                                columna = new Scanner(System.in).nextInt();
                            } while (columna < 1 || columna > 10);

                            do {//pedir letra de la fila
                                System.out.println("Desde fila (A-J): ");// hay añadir control de valores
                                charColumna = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
                                //devolver nº que corresponde con el char        
                                fila = elegirChar(charColumna);
                            } while (fila < 1 || fila > 10);

                            //comprobar si el barco cabe en el tablero
                            if (posicion == 1 && columna + flota[i].getTamano() - 1 > 10) {
                                System.out.println("El barco no cabe horizontalmente");
                            }

                            if (posicion == 2 && fila + flota[i].getTamano() - 1 > 10) {
                                System.out.println("El barco no cabe verticalmente");

                            }
                            contadorEspacios = 0;
                            for (int j = 0; j < flota[i].getTamano(); j++) {
                                if (tablero1.validarEspacio(fila, columna, posicion, j)) {
                                    contadorEspacios++;
                                }
                            }

                            if (contadorEspacios == flota[i].getTamano()) {
                                System.out.println("Posición validada");
                                tablero1.colocarBarco(fila, columna, posicion, flota[i].getTamano());
                                siguiente = true;
                            }

                        } while (!siguiente);

                        contadorEspacios = 0; //resetear contador

                        //mostrar tablero después de colocar el barco
                        System.out.println("\tTABLERO JUGADOR 1\n" + tablero1.mostrar());

                    }

                    //BARCOS ALEATORIOS DE LA IA
                    tablero2 = new Tablero();
                    System.out.println(tablero2.mostrar());

                    for (int i = 0; i < flota.length; i++) {

                        contadorEspacios = 0;
                        siguiente = false;

                        int posicionRandom;
                        int filaRandom;
                        int columnaRandom;

                        //System.out.println("Colocar " + flota[i].getNombre());

                        do {
                            contadorEspacios = 0;

                            // generar orientación y posición aleatoria
                            posicionRandom = random.nextInt(2) + 1;
                            filaRandom = random.nextInt(10) + 1;
                            columnaRandom = random.nextInt(10) + 1;

                            // comprobar si el barco cabe en el tablero
                            if ((posicionRandom == 1 && columnaRandom + flota[i].getTamano() - 1 > 10)
                                    || (posicionRandom == 2 && filaRandom + flota[i].getTamano() - 1 > 10)) {
                                continue; // o simplemente no hacer nada y repetir el ciclo
                            }

                            // validar espacios libres
                            for (int j = 0; j < flota[i].getTamano(); j++) {
                                if (tablero2.validarEspacio(filaRandom, columnaRandom, posicionRandom, j)) {
                                    contadorEspacios++;
                                }
                            }

                            // si todos los espacios están libres, colocar el barco
                            if (contadorEspacios == flota[i].getTamano()) {
                                //System.out.println("Posición validada");
                                tablero2.colocarBarco(filaRandom, columnaRandom, posicionRandom, flota[i].getTamano());
                                siguiente = true;
                            }

                        } while (!siguiente);

                    }

                    // BORRAR   mostrar tablero de la ia 
                    System.out.println("\tTABLERO IA\n" + tablero2.mostrar());

                }

                case 2 -> {//atacar flota contraria

                    int fila = 0;
                    int columna = 0;
                    char charFila;

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
                                charFila = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
                                //devolver nº que corresponde con el char        
                                fila = elegirChar(charFila);

                            } while (charFila != 'A' && charFila != 'B' && charFila != 'C' && charFila != 'D'
                                    && charFila != 'E' && charFila != 'F' && charFila != 'F' && charFila != 'G'
                                    && charFila != 'H' && charFila != 'I' && charFila != 'J');

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
                                charFila = new Scanner(System.in).nextLine().trim().toUpperCase().charAt(0);
                                //devolver nº que corresponde con el char        
                                fila = elegirChar(charFila);

                            } while (charFila != 'A' && charFila != 'B' && charFila != 'C' && charFila != 'D'
                                    && charFila != 'E' && charFila != 'F' && charFila != 'F' && charFila != 'G'
                                    && charFila != 'H' && charFila != 'I' && charFila != 'J');

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

    public static int elegirChar(char charFila) {

        int fila = 0;
        switch (charFila) {

            case 'A' -> {
                fila = 1;
            }
            case 'B' -> {
                fila = 2;
            }
            case 'C' -> {
                fila = 3;
            }
            case 'D' -> {
                fila = 4;
            }
            case 'E' -> {
                fila = 5;
            }
            case 'F' -> {
                fila = 6;
            }
            case 'G' -> {
                fila = 7;
            }
            case 'H' -> {
                fila = 8;
            }
            case 'I' -> {
                fila = 9;
            }
            case 'J' -> {
                fila = 10;
            }
            default -> {
                System.out.println("ERROR");
            }
        }

        return fila;
    }
}
