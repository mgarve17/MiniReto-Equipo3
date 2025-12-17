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

        int opcion;//opcion del switch
        boolean salir = false;
        //Barco flota = null;
        Tablero prueba = new Tablero();

        
        
        do {

            System.out.println("1. empezar partida");   
            System.out.println("2. salir");
            
            opcion = new Scanner(System.in).nextInt();
            
            
            switch (opcion){
            
                case 1 -> {
                
                    
                }
                
                default -> {
                    System.out.println("ERROR");
                }
                
            }

        }while (!salir);

        //mostrar tablero para pruebas


        System.out.println(prueba.mostrar());
    }
}
