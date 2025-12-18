package com.mycompany.roll;

import java.util.Scanner;

public class Npc {

    private String nombre;
    private int hp;
    private int ataque;
    private boolean cooldown = false; //se puede usar el ataque especial

    public Npc() { //constructor vacío
    }

    public Npc(String nombre) { //constructor personalizado
        this.nombre = nombre;
        this.hp = vida();
    }

    public int restarVida(int ataque) { //Le resta vida al enemigo
        this.hp -= ataque;
        return this.hp;
    }

    public int curar(int cura) { //Le cura al enemigo
        this.hp += cura;
        return this.hp;
    }

    public int vida() {  //genera la vida total que tendrá el enemigo entre 10 y 20
        int vida = 0;
        switch (nombre) {
            case "mago":
                vida = 8;
                break;
            case "clerigo":
                vida = 15;
                break;
            case "barbaro":
                vida = 15;
                break;
            case "guerrero":
                vida = 20;
        }
        return vida;
    }

    public int ataque(int num) {
        Scanner teclado = new Scanner(System.in);
        int atacks = (int) (Math.random() * 20) + 1; // saca un número del 1 al 20
        if (atacks < 10) { //si saca menos de un 10 el modificador es de x0 (falla)
            atacks = 0;
        } else if (atacks >= 10 && atacks < 20) { //si saca entre 10 y 19 incluidos el modificador es de x1 (acierta)
            atacks = 1;
        } else { //si saca un 20, el modificador es de x2 (crítico)
            atacks = 2;
        }
        if (cooldown == true) {
            while (num != 1) {
                System.out.println("Esa habilidad está en cooldown, por favor, seleccione otra");
                num = teclado.nextInt();
            }
            cooldown = false;
            ataque = atacks;
        } else {
            if (num == 1) {
                ataque = atacks;
            } else {
                switch(nombre){
                    case "mago":
                        this.ataque= 3*atacks;
                        break;
                    case "clerigo":
                        this.ataque=-1; //cura a alguien 1 punto de vida, hay que hacerlo en el main
                        break;
                    case "barbaro":
                        this.ataque= 2*atacks;
                        break;
                    case "guerrero":
                        this.ataque= -2; //hará que el siguiente ataque de los enemigos le pegue a él
                }
            }
        }
        return ataque;
    }
    
    public String getNombre(){
        return nombre;
    }
    public int getVida(){
        return hp;
    }
    
    public boolean getCooldown(){
        return cooldown;
    }
    
    @Override
    public String toString(){
        return "[NPCs] Nombre = " + nombre + " HP = " + hp + " Cooldown = " + cooldown;
    }
}
