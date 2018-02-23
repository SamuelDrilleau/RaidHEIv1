CREATE DATABASE raidhei;
USE raidhei;

CREATE TABLE Photo(
  id int NOT NULL AUTO_INCREMENT,
  annee int NOT NULL,
  nom char(50),
  PRIMARY KEY (id));

CREATE TABLE Raid(
  id int NOT NULL,
  annee int NOT NULL);

CREATE TABLE Equipe(
	nom varchar(20) NOT NULL PRIMARY KEY,
	mdp varchar(64) NOT NULL,
	typeRaid varchar(20) NOT NULL);

CREATE TABLE Participant(
	mail varchar(50) NOT NULL PRIMARY KEY,
	mdp varchar(64) NOT NULL,
	nom varchar(20) NOT NULL,
	prenom varchar(20) NOT NULL,
	sexe varchar(20) NOT NULL,
	tel varchar(20) NOT NULL,
	statut varchar(20) NOT NULL,
	nomEnt varchar(20) NOT NULL,
	nomUrg varchar(20) NOT NULL,
	telUrg varchar(20) NOT NULL,
	bds varchar(10) NOT NULL,
	vtt varchar(10) NOT NULL,
	bus varchar(10) NOT NULL,
	tshirt varchar(1) NOT NULL,
	fftri varchar(10) NOT NULL,
	nomEquipe varchar(20) NOT NULL,
	certifMed varchar(10) NOT NULL,
	certifSco varchar(10) NOT NULL,
	attestation varchar (10) NOT NULL,
	FOREIGN KEY (nomEquipe) REFERENCES Equipe(nom));

INSERT INTO Equipe (nom,mdp,typeRaid) VALUES ("Indiv","solo","Aventure");