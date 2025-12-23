DROP TABLE IF EXISTS hundir_la_flota;
CREATE DATABASE hundir_la_flota;
USE hundir_la_flota;
CREATE TABLE jugador (
    id_jugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_registro DATE NOT NULL
    );
 CREATE TABLE partida (
    id_partida INT AUTO_INCREMENT PRIMARY KEY,
    hora_inicio DATETIME NOT NULL,
    hora_fin DATETIME,
    estado BOOLEAN NOT NULL
);   
CREATE TABLE partida_jugador (
    id_partida INT,
    id_jugador INT,
    PRIMARY KEY (id_partida, id_jugador),
    FOREIGN KEY (id_partida) REFERENCES partida(id_partida)
        ON DELETE CASCADE,
    FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador)
        ON DELETE CASCADE
);
CREATE TABLE tablero (
    id_tablero INT AUTO_INCREMENT PRIMARY KEY,
    tamano INT NOT NULL,
    id_jugador INT NOT NULL,
    id_partida INT NOT NULL,
    FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador)
        ON DELETE CASCADE,
    FOREIGN KEY (id_partida) REFERENCES partida(id_partida)
        ON DELETE CASCADE
);
CREATE TABLE barco (
    id_barco INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(30) NOT NULL,
    tamano INT NOT NULL,
    id_tablero INT NOT NULL,
    FOREIGN KEY (id_tablero) REFERENCES tablero(id_tablero)
        ON DELETE CASCADE
);
CREATE TABLE barco_jugador (
    id_barco INT,
    id_jugador INT,
    PRIMARY KEY (id_barco, id_jugador),
    FOREIGN KEY (id_barco) REFERENCES barco(id_barco)
        ON DELETE CASCADE,
    FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador)
        ON DELETE CASCADE
);
CREATE TABLE disparo (
    id_disparo INT AUTO_INCREMENT PRIMARY KEY,
    resultado VARCHAR(10) NOT NULL, -- AGUA / TOCADO / HUNDIDO
    id_partida INT NOT NULL,
    id_jugador INT NOT NULL,
    FOREIGN KEY (id_partida) REFERENCES partida(id_partida)
        ON DELETE CASCADE,
    FOREIGN KEY (id_jugador) REFERENCES jugador(id_jugador)
        ON DELETE CASCADE
);
