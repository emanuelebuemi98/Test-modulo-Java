CREATE DATABASE esercizio_db;
USE esercizio_db;

CREATE TABLE IF NOT EXISTS utenti(
	id_u INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cognome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS categoria(
	id_ca INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome_categoria ENUM('Admin', 'Utente', 'Docente')
);

CREATE TABLE IF NOT EXISTS ruolo(
	id_r INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipologia ENUM('FrontEnd', 'BackEnd', 'FullStack', 'Cybersecurity')
);

CREATE TABLE IF NOT EXISTS corso(
	id_c INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome_corso VARCHAR(255) NOT NULL,
    descrizione_breve VARCHAR(255) NOT NULL,
    descrizione_completa TEXT NOT NULL,
    durata INT NOT NULL,
    fk_ca INT NOT NULL,
    FOREIGN KEY (fk_ca) REFERENCES categoria(id_ca)
);

CREATE TABLE IF NOT EXISTS utenti_corsi(
	fk_uc INT NOT NULL,
	fk_cu INT NOT NULL,
	PRIMARY KEY (fk_uc, fk_cu), 
	FOREIGN KEY (fk_uc) REFERENCES utenti(id_u),
	FOREIGN KEY (fk_cu) REFERENCES corso(id_c)
);

CREATE TABLE IF NOT EXISTS utente_ruolo(
	fk_r INT NOT NULL,
	fk_u INT NOT NULL,
	PRIMARY KEY (fk_r, fk_u), 
	FOREIGN KEY (fk_r) REFERENCES ruolo(id_r),
	FOREIGN KEY (fk_u) REFERENCES utenti(id_u)
);
