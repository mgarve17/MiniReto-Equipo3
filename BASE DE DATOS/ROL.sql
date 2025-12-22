DROP DATABASE ROL;
CREATE DATABASE ROL;
USE ROL;

CREATE TABLE Jugador (
    id_jugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_registro DATE NOT NULL
);

CREATE TABLE Partida (
    id_partida INT AUTO_INCREMENT PRIMARY KEY,
    hora_inicio DATETIME NOT NULL,
    hora_final DATETIME,
    estado VARCHAR(30) NOT NULL
);

CREATE TABLE Jugador_Partida (
    id_jugador INT,
    id_partida INT,
    PRIMARY KEY (id_jugador, id_partida),
    FOREIGN KEY (id_jugador) 
		REFERENCES Jugador(id_jugador),
    FOREIGN KEY (id_partida) 
		REFERENCES Partida(id_partida)
);

CREATE TABLE Personajes (
    id_personaje INT AUTO_INCREMENT PRIMARY KEY,
    clase VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    puntos_hp INT NOT NULL,
    puntos_atk INT NOT NULL
);

CREATE TABLE Enemigo (
    id_enemigo INT AUTO_INCREMENT PRIMARY KEY,
    clase VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    puntos_hp INT NOT NULL,
    puntos_atk INT NOT NULL
);

CREATE TABLE Clase (
    id_personaje INT,
    id_enemigo INT,
    nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_personaje, id_enemigo),
    FOREIGN KEY (id_personaje) 
		REFERENCES Personajes(id_personaje),
    FOREIGN KEY (id_enemigo) 
		REFERENCES Enemigo(id_enemigo)
);

CREATE TABLE Ataque (
    id_ataque INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    daño INT NOT NULL,
    tipo VARCHAR(30) NOT NULL
);

CREATE TABLE Combate (
    id_personaje INT,
    id_enemigo INT,
    PRIMARY KEY (id_personaje, id_enemigo),
    FOREIGN KEY (id_personaje) 
		REFERENCES Personajes(id_personaje),
    FOREIGN KEY (id_enemigo)
		REFERENCES Enemigo(id_enemigo)
);


