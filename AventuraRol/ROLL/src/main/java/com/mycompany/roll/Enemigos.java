package com.mycompany.roll;

public class Enemigos {

    private String nombre;
    private int hp;
    private int ataque;
    private boolean cooldown = false; //se puede usar el ataque especial

    public Enemigos() { //Constructor aleatorio
        this.nombre=nombre();
        this.hp=vida();
    }
    
    public Enemigos(String nombre, int hp){ //constructor personalizado
        this.nombre=nombre;
        this.hp=hp;
    }
    
    public int restarVida(int ataque) { //Le resta vida al enemigo
        this.hp -= ataque;
        return this.hp;
    }

    public int curar(int cura) { //Le cura al enemigo
        this.hp += cura;
        return this.hp;
    }

    public String nombre() { //Genera el nombre del enemigo de forma aleatoria
        int enemigo = (int) (Math.random() * 4) + 1; //Genera un número aleatorio del  1 al 4
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
    
    public int vida(){  //genera la vida total que tendrá el enemigo entre 10 y 20
        this.hp=(int) (Math.random() * 11) + 10;
        return hp;
    }

    public int ataque() { //dependiendo del nombre del enemigo hacce un ataque u otro
        if (cooldown == false) { //primero revisa que pueda usar la habilidad fuerte
            int atacks = (int) (Math.random() * 20) + 1; // saca un número del 1 al 20
            if (atacks < 10) { //si saca menos de un 10 el modificador es de x0 (falla)
                atacks = 0;
            } else if (atacks >= 10 && atacks < 20) { //si saca entre 10 y 19 incluidos el modificador es de x1 (acierta)
                atacks = 1;
            } else { //si saca un 20, el modificador es de x2 (crítico)
                atacks = 2;
            }
            int atack = (int) (Math.random() * 2) + 1; //genera un número aleatorio entre 1 y 2
            switch (this.nombre) {
                case "Lobo":
                case "Goblin": //si es Goblin o Lobo tiene x ataques
                    if (atack == 2) { //el fuerte que pega 2 puntos de daño x el modificador
                        this.cooldown = true;
                        this.ataque = atack * atacks;
                    } else { //el debil, que pega 1 punto de daño x el modificador
                        this.ataque = atack * atacks;
                    }
                    break;
                case "Arpía":
                case "Slime": //si es Arpía o Slime tiene otros ataques
                    if (atack == 2) { //una cura que tiene cooldown
                        this.cooldown = true;
                        curar(1);
                        this.ataque=-1;
                    } else { //y el ataque normal x el modificador
                        this.ataque = atack * atacks;
                    }
            }
        } else { //si no puede usar la habilidad fuerte se "tira un dado de 20 caras"
            cooldown = false;
            int atacks = (int) (Math.random() * 20) + 1; //si saca menos de un 10 falla
            if (atacks < 10) {
                this.ataque = 0;
            } else if (atacks >= 10 && atacks < 20) { //si saca entre 10 y 19 incluidos acierta
                this.ataque = 1;
            } else { //si saca un 20 obtiene un golpe crítico
                this.ataque = 2;
            }
        }
        return this.ataque;
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
        return "[Enemigos] Nombre = " + nombre + " HP = " + hp + " Cooldown = " + cooldown;
    }
}
