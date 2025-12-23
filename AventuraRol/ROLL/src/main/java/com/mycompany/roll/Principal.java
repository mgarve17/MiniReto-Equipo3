package com.mycompany.roll;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] personajes= new String[2];
        String menup;
        String personaje = "";
        Enemigos enemigo1 = new Enemigos();
        Enemigos enemigo2 = new Enemigos();
        Enemigos enemigo3 = new Enemigos();
        for (int i = 1; i <= 2; i++) {
            do {
                System.out.println("Elije a tu " + i + "º personaje:"
                        + "\nMago\nClérigo\nBárbaro\nGuerrero");
                personaje = teclado.nextLine().toLowerCase();
                personaje.replace('á', 'a');
                personaje.replace('é', 'e');
                switch (personaje) {
                    case "mago":
                        do{
                        System.out.println("EL mago tiene 8 puntos de vida, pero con su ataque especial dañará a un enemigo con 3 puntos de daño"
                                + "\n¿Estás seguro que quieres seleccionar este personaje? (Si/No)");
                                menup=teclado.nextLine().toLowerCase();
                                if(menup=="si"){
                                    Npc npc1= new Npc(personaje);
                                }else if(menup=="no"){
                                    personaje="";
                                }
                        }while(menup!="si" && menup!="no");
                }
            } while (personaje != "mago" && personaje != "clerigo" && personaje != "barbaro" && personaje != "guerrero");
        }

    }
}
