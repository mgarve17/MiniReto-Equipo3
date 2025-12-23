package com.mycompany.roll;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int ataqueenem;
        int[] ataque = new int[2];
        String[] personajes = new String[2]; //Creamos un arrays para poder guardar los datos del menu
        String menup;
        int menu;
        Npc[] pjs = new Npc[2];
        String personaje = "";
        Enemigos[] enemigos = new Enemigos[3]; //y creamos a los enemigos de forma aleatoria
        enemigos[0] = new Enemigos();
        enemigos[1] = new Enemigos();
        enemigos[2] = new Enemigos();
        for (int i = 1; i <= 2; i++) { //con un for, creamos a los 2 personajes que usara el jugador
            do {
                System.out.println("Elije a tu " + i + "º personaje:" //le preguntamos que personaje quiere
                        + "\nMago\nClérigo\nBárbaro\nGuerrero");
                personaje = teclado.nextLine().replace('Á','a').replace('É','e').toLowerCase(); //y para evitar fallos lo pasamos todo a minusculas
                personaje.replace('á', 'a');//y remplazamos posibles tildes
                personaje.replace('é', 'e');
                switch (personaje) {//depende de lo que elija se mostrará una opción por pantalla que le dirá las estadisticas de cada personaje
                    case "mago":
                        do {
                            System.out.println("\nEL mago tiene 10 puntos de vida, pero con su ataque especial dañará a un enemigo con 5 puntos de daño"
                                    + "\n¿Estás seguro que quieres seleccionar este personaje? (Si/No)");
                            menup = teclado.nextLine().toLowerCase();
                            if (menup.equals("si")) {
                                personajes[i - 1] = personaje; //si lo elije se guardará el nombre del personaje en una posición del arrays anteriormente creado
                            } else if (menup.equals("no")) {
                                personaje = "";
                            } else {
                                System.err.println("\nError, elije una opción correcta"); //si elije una opción incorrecta saltara error y volvera a preguntar
                            }
                        } while (menup.equals("si") == false && menup.equals("no") == false); //lo repite hasta que la respuesta sea si o no
                        break;
                    case "clerigo": //lo mismo con todos
                        do {
                            System.out.println("\nEL clérigo tiene 15 puntos de vida y puede curar tanto a sus aliados como a si mismo"
                                    + "\n¿Estás seguro que quieres seleccionar este personaje? (Si/No)");
                            menup = teclado.nextLine().toLowerCase();
                            if (menup.equals("si")) {
                                personajes[i - 1] = personaje; //lo mismo con todos
                            } else if (menup.equals("no")) {
                                personaje = "";
                            } else {
                                System.err.println("\nError, elije una opción correcta");
                            }
                        } while (menup.equals("si") == false && menup.equals("no") == false);
                        break;
                    case "barbaro":
                        do {
                            System.out.println("\nEL bárbaro tiene 15 puntos de vida y puede dañar a los enemigos con 2 puntos de daño gracias a su ataque especial"
                                    + "\n¿Estás seguro que quieres seleccionar este personaje? (Si/No)");
                            menup = teclado.nextLine().toLowerCase();
                            if (menup.equals("si")) {
                                personajes[i - 1] = personaje;
                            } else if (menup.equals("no")) {
                                personaje = "";
                            } else {
                                System.err.println("\nError, elije una opción correcta");
                            }
                        } while (menup.equals("si") == false && menup.equals("no") == false);
                        break;
                    case "guerrero":
                        do {
                            System.out.println("\nEL guerrero tiene 20 puntos de vida y puede atraer los ataques de los enemigos hacia si mismo con su ataque especial"
                                    + "\n¿Estás seguro que quieres seleccionar este personaje? (Si/No)");
                            menup = teclado.nextLine().toLowerCase();
                            if (menup.equals("si")) {
                                personajes[i - 1] = personaje;
                            } else if (menup.equals("no")) {
                                personaje = "";
                            } else {
                                System.err.println("\nError, elije una opción correcta");
                            }
                        } while (menup.equals("si") == false && menup.equals("no") == false);
                    default:
                        System.err.println("\nEse personaje no existe,elije una opción correcta \n");
                }
            } while (personaje.equals("mago") == false && personaje.equals("clerigo") == false && personaje.equals("barbaro") == false && personaje.equals("guerrero") == false);
        }
        pjs[0] = new Npc(personajes[0]); //una vez fuera del menú, se crean ambos objetos de la clase Npc
        pjs[1] = new Npc(personajes[1]);
        do {
            for (int i = 0; i <= 1; i++) { //con un for elejimos los ataques de los personajes
                if (pjs[i].getVida() <= 0) {
                    System.out.println("\nEl " + pjs[i].getNombre() + " está fuera de combate"); //si el personaje está muerto, te dice que no esta disponible
                    ataque[i] = 0;
                } else {//si no, te muestra los enemigos y su vida
                    System.out.println("\n"+enemigos[0].dibujo()+enemigos[0].getNombre() + "(" + enemigos[0].getVida() + "HP)");
                    System.out.println(enemigos[1].dibujo()+enemigos[1].getNombre() + "(" + enemigos[1].getVida() + "HP)");
                    System.out.println(enemigos[2].dibujo()+enemigos[2].getNombre() + "(" + enemigos[2].getVida() + "HP)");
                    System.out.println("\nEs tu turno de atacar con el " + pjs[i].getNombre() + "(" + pjs[i].getVida() + " HP)"
                            + "\nQue ataque quieres usar?"
                            + "\n1.- Ataque debil \n2.- Habilidad especial" + (pjs[i].getCooldown() ? " (No se puede usar)" : " (Disponible)"));
                    ataque[i] = pjs[i].ataque(teclado.nextInt()); //guarda el ataque del personaje
                    teclado.nextLine();
                    switch (ataque[i]) {
                        case 0:
                        case 2:
                        case 4:
                        case 5:
                        case 8:
                        case 10:
                            do {
                                System.out.println("\n¿A que enemigo quieres atacar?" //si saca entre 0 y 6 elije atacante
                                        + "\n1.-" + enemigos[0].getNombre() + "(" + enemigos[0].getVida() + ")"
                                        + "\n2.-" + enemigos[1].getNombre() + "(" + enemigos[1].getVida() + ")"
                                        + "\n3.-" + enemigos[2].getNombre() + "(" + enemigos[2].getVida() + ")");
                                menu = teclado.nextInt();
                                teclado.nextLine();
                                if (menu != 1 && menu != 2 && menu != 3) { //si no es ni 1, 2 o 3 da error y repite la pregunta
                                    System.err.println("\nError, ese enemigo no existe");
                                }
                            } while (menu != 1 && menu != 2 && menu != 3);
                            if (ataque[i] == 0) { //si el ataque es 0 falla
                                System.out.println("\nHas fallado");
                            } else { //sino entra en un switch
                                switch (menu) {
                                    case 1:
                                        if (enemigos[0].getVida() > 0) { //si el enemigo sigue vivo ataca
                                            System.out.println("\nLe has hecho " + ataque[i] + " puntos de daño al " + enemigos[0].getNombre());
                                            enemigos[0].restarVida(ataque[i]);
                                        } else { //sino te dice que esta muerto
                                            System.err.println("\nEse enemigo ya está muerto");
                                        }
                                        break;
                                    case 2:
                                        if (enemigos[1].getVida() > 0) { //lo mismo
                                            System.out.println("\nLe has hecho " + ataque[i] + " puntos de daño al " + enemigos[1].getNombre());
                                            enemigos[1].restarVida(ataque[i]);
                                        } else {
                                            System.err.println("\nEse enemigo ya está muerto");
                                        }
                                        break;
                                    case 3:
                                        if (enemigos[2].getVida() > 0) {
                                            System.out.println("\nLe has hecho " + ataque[i] + " puntos de daño al " + enemigos[2].getNombre());
                                            enemigos[2].restarVida(ataque[i]);
                                        } else {
                                            System.err.println("\nEse enemigo ya está muerto");
                                        }
                                        break;
                                }
                            }
                            break;

                        case -1: //en caso de que el ataque sea -1 cura
                            do {
                                System.out.println("\n¿Quieres curar a tu aliado o a ti mismo? \n 1.-Aliado \n 2.-A ti mismo"); //pregunta a quien quiere curar
                                menu = teclado.nextInt();
                                teclado.nextLine();
                                switch (menu) {
                                    case 1:
                                        if (pjs[i] == pjs[0]) { //si es a otra persona, dependiendo de quien, la cura
                                            pjs[1].curar(2);
                                            System.out.println("\nHas curado 2 HP a tu aliado (" + pjs[1].getNombre() + " " + pjs[1].getVida() + " HP)");
                                        } else {
                                            pjs[0].curar(2);
                                            System.out.println("\nHas curado 2 HP a tu aliado (" + pjs[0].getNombre() + " " + pjs[0].getVida() + " HP)");
                                        }
                                        break;
                                    case 2: //sino a si mismo
                                        pjs[i].curar(2);
                                        System.out.println("\nTe has curado 2 HP a ti mismo (" + pjs[i].getNombre() + " " + pjs[i].getVida() + " HP)");
                                        break;

                                    default: //sino da error y se repite
                                        System.err.println("\nElija una opción correcta");
                                }
                            } while (menu != 1 && menu != 2);
                            break;
                        case -2:
                            System.out.println("\nEn el siguient turno, los enemigos atacarán solo al guerrero"); //si es -2, sale un mensaje
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (enemigos[i].getVida() <= 0) {//si el enemigo esta muerto no hace nada

                } else { //sino ataca
                    if (ataque[0] == -2) { //si se ha usado la habilidad del guerrero solo le ataca a él
                        ataqueenem = enemigos[i].ataque();
                        if (ataqueenem == -1) {//si es una cura se cura
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " se ha curado 1 HP");
                        } else { //sino golpea
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " ha atacado a tu " + pjs[0].getNombre());
                            pjs[0].restarVida(ataqueenem);
                            if (ataqueenem == 0) {
                                System.out.println("\nHa fallado");
                            } else {
                                System.out.println("\nLe ha hecho " + ataqueenem + " punto/s de daño");
                            }
                        }
                    } else if (ataque[1] == -2) { //lo mismo pero comprobando si el guerrero es el pj 2
                        ataqueenem = enemigos[i].ataque();
                        if (ataqueenem == -1) {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " se ha curado 1 HP");
                        } else {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " ha atacado a tu " + pjs[1].getNombre());
                            pjs[1].restarVida(ataqueenem);
                            if (ataqueenem == 0) {
                                System.out.println("\nHa fallado");
                            } else {
                                System.out.println("\nLe ha hecho " + ataqueenem + " punto/s de daño");
                            }
                        }
                    } else if (pjs[0].getVida() <= 0) { //si uno de los pj esta muerto ataca al otro automatiamente
                        ataqueenem = enemigos[i].ataque();
                        if (ataqueenem == -1) {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " se ha curado 1 HP");
                        } else {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " ha atacado a tu " + pjs[1].getNombre());
                            pjs[1].restarVida(ataqueenem);
                            if (ataqueenem == 0) {
                                System.out.println("\nHa fallado");
                            } else {
                                System.out.println("\nLe ha hecho " + ataqueenem + " punto/s de daño");
                            }
                        }
                    } else if (pjs[1].getVida() <= 0) { //lo mismo
                        ataqueenem = enemigos[i].ataque();
                        if (ataqueenem == -1) {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " se ha curado 1 HP");
                        } else {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " ha atacado a tu " + pjs[0].getNombre());
                            pjs[0].restarVida(ataqueenem);
                            if (ataqueenem == 0) {
                                System.out.println("\nHa fallado");
                            } else {
                                System.out.println("\nLe ha hecho " + ataqueenem + " punto/s de daño");
                            }
                        }
                    } else { //de cualquier otra forma, ataca a un personaje aleatorio
                        ataqueenem = enemigos[i].ataque();
                        if (ataqueenem == -1) {
                            System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " se ha curado 1 HP");
                        } else {
                            int atack = (int) (Math.random() * 2) + 1;
                            switch (atack) {
                                case 1:
                                    System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " ha atacado a tu " + pjs[0].getNombre());
                                    pjs[0].restarVida(ataqueenem);
                                    if (ataqueenem == 0) {
                                        System.out.println("\nHa fallado");
                                    } else {
                                        System.out.println("\nLe ha hecho " + ataqueenem + " punto/s de daño");
                                    }
                                    break;
                                case 2:
                                    System.out.println("\n"+enemigos[i].dibujo()+"El " + enemigos[i].getNombre() + " ha atacado a tu " + pjs[1].getNombre());
                                    pjs[1].restarVida(ataqueenem);
                                    if (ataqueenem == 0) {
                                        System.out.println("\nHa fallado");
                                    } else {
                                        System.out.println("\nLe ha hecho " + ataqueenem + " punto/s de daño");
                                    }
                            }
                        }
                    }
                }
            }
        } while ((enemigos[0].getVida() > 0 || enemigos[1].getVida() > 0 || enemigos[2].getVida() > 0) && (pjs[0].getVida() > 0) || pjs[1].getVida() > 0);
        if ((enemigos[0].getVida() > 0 || enemigos[1].getVida() > 0 || enemigos[2].getVida() > 0)) {
            System.err.println("Has perdido");
        } else {
            System.out.println("¡¡Enhorabuena, has ganado!!");
        }
    }
}