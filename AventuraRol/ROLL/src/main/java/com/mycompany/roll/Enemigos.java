package com.mycompany.roll;

public class Enemigos {

    private String nombre;
    private int hp;
    private int ataque;
    private boolean cooldown = false; //se puede usar el ataque especial

    public Enemigos() {

    }

    public int restarVida(int ataque) {
        this.hp -= ataque;
        return this.hp;
    }

    public int curar(int cura) {
        this.hp += cura;
        return this.hp;
    }

    public String nombre() {
        int enemigo = (int) (Math.random() * 4) + 1;
        switch (enemigo) {
            case 1:
                this.nombre = "Goblin";
                break;
            case 2:
                this.nombre = "Slime";
                break;
            case 3:
                this.nombre = "Arpía";
                break;
            case 4:
                this.nombre = "Lobo";
        }
        return nombre;
    }

    public int ataque() {
        if (cooldown == false) {
            int atacks = (int) (Math.random() * 20) + 1;
            if (atacks < 10) {
                atacks = 0;
            } else if (atacks >= 10 && atacks < 20) {
                atacks = 1;
            } else {
                atacks = 2;
            }
            int atack = (int) (Math.random() * 2) + 1;
            switch (this.nombre) {
                case "Lobo":
                case "Goblin":
                    if (atack == 2) {
                        this.cooldown = true;
                        this.ataque = atack * atacks;
                    } else {
                        this.ataque = atack * atacks;
                    }
                    break;
                case "Arpía":
                case "Slime":
                    if (atack == 2) {
                        this.cooldown = true;
                        curar(1);
                    } else {
                        this.ataque = atack * atacks;
                    }
            }
        } else {
            cooldown = false;
            int atacks = (int) (Math.random() * 20) + 1;
            if (atacks < 10) {
                this.ataque = 0;
            } else if (atacks >= 10 && atacks < 20) {
                this.ataque = 1;
            } else {
                this.ataque = 2;
            }
        }
        return this.ataque;
    }
}
