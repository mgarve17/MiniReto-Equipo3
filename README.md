# **RETO: DESARROLLO DE JUEGOS BÁSICOS**

## Índice de contenido

-[**RETO: DESARROLLO DE JUEGOS BÁSICOS**](#reto-desarrollo-de-juegos-básicos)

-[Indice de contenido](#índice-de-contenido)

-[Introducción](#introducción)

-[Miembros del equipo](#miembros-del-equipo)

-[Implementación y despliegue](#implementación-y-despliegue)

-[Web](#web)

-[Base de datos](#base-de-datos)

-[Juego: hundir la flota](#juego-hundir-la-flota)

-[Juego: rol](#juego-rol)

-[Mejoras](#mejoras)


## Introducción

Documentación del desarrollo del software de juegos básicos. Este espacio contendrá los miembros que han participado en el proceso, el desarrollo de los juegos con su web complementaria, máquinas virtuales junto los manuales destinados a su compresión y uso, y ambas bases de datos con su esquema de entidad y relación.

## Miembros del equipo **Tinkiwinki**

- Maya García Velasco  
- Naya Ruiz Ruano  
- Isaac Mantu Nazila  
- Marcos Villanueva Campo  
- Manuel González Encinas 

## Implementación y despliegue

[📑 Despliegue en Windows 11 ](/MANUALES/ManualDeDespliegueW11.pdf) | [ 📑 Despliegue en Linux](/MANUALES/ManualDeDespliegueLinux.pdf)

Hemos desarrollando una máquina virtual de Windows 11 Pro y una segunda de Ubuntu 24.04. En los manuales se detalla todo el proceso desde la instalación hasta las instrucciones de uso.

## Web <!--AÑADIR FOTOS!!!-->

[WEB](/Lenguaje-de-marcas)

Web estática simple que tiene como finalidad recoger las reglas y puntuaciones de los juegos desarrollados. Cuenta con un apartado principal que redirige al usuario a la pestaña de normas o ranking según el juego seleccionado, y un login para futuros usuarios.


## Base de datos <!--AÑADIR FOTOS Y ARCVHIVOS-->

[🖼️ E/R Rol](/BASE%20DE%20DATOS/Mini-reto-ROL.drawio.png) | [Script Rol](/BASE%20DE%20DATOS/ROL.sql) | [🖼️ E/R hundir la flota](/BASE%20DE%20DATOS/TABLAS.png) | [Script hundir la flota](/BASE%20DE%20DATOS/Hundir_la_flota_BD.sql)

Esquema relacional de la base de datos para el juego de rol
![Rol](/BASE%20DE%20DATOS/Mini-reto-ROL.drawio.png)

Esquema relacional de la base de datos para el juego de hundir la flota
![FLota](/BASE%20DE%20DATOS/TABLAS.png)



##  🕹️ Juego: hundir la flota

[ Hundir la flota ](/HundirLaFlota)

Juego clásico de peleas navales para un único jugador. El usuario cuenta con una flota de 4 barcos que puede colocar libremente, y se enfrenta a la flota generada aleatoriamente por la máquina. 

**Clase principal:** cuenta con un menú de opciones, siendo la primera crear un tablero en la que el jugador coloca su flota a gusto, y cuando termina se genera otro aleatorio para la máquina. Tras eso el programa permite iniciar la partida en la que por turnos se deben introducen coordenadas para atacar hasta que uno de los jugadores pierda. Al terminar una partida se puede volvera crear otra o salir del juego.

**Clase Barco:** clase simple en la que se crea la flota de los jugadores.

**Clase Tablero:** Esta clase además de crear y mostrar el tablero de los jugadores, contiene todos los métodos para la colocación de barcos, ataque y los métodos de validación necesarios para asegurar que no se superponen barcos o marcar el tablero auxiliar con los movimientos realizados.





## 🕹️ Juego: rol

[Rol](/AventuraRol/ROLL)

Aventura de rol en la que lideras tu propio equipo en batallas contra diferentes criaturas.

**Clase principal:** Contiene el selector de personajes que va a utilizar el usuario durante el juego, y un complejo menú de opciones que gestiona los ataques y las curaciones del jugador y las de las contrarias.

**Clase NPC:** cuenta con un constructor para generar a los personajes, con estadísticas únicas dependiendo de su clase. En esta clase destaca el método que gestiona los ataques de los personajes, imitando el sistema de los juegos de rol tradicionales en el que el desempeño del ataque se decide con un dado.

**Clase enemigos:** semejante a la anterior, la clase de enemigos genera diferentes criaturas según su nombre, con estadísticas propias para cada uno, y el mismo método de ataque que contabiliza el daño según un número aleatorio. También incluye un diseño para cada enemigo que se muestra por pantalla en la pelea.

## Mejoras


**Hundir la flota:** añadir sistema de puntuaciones, contabilizar barcos hundidos, darle una interfaz.

**Juego de rol:** añadir opciones de cancelar ataques y añadir sistema de puntuaciones.

**Web:** animaciones en el ranking, inicio de sesión no simulado, y ranking no simulado.

**Base de datos:** nombres más descriptivos.

