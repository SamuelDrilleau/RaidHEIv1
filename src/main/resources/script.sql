CREATE DATABASE raidhei;
USE raidhei;

CREATE TABLE Raid(
  id int NOT NULL,
  debut DATE,
  fin DATE,
  contactMail varchar (50),
  contactTel varchar (20),
  lieu text,
  presentation text,
  prixCaution int,
  prixEtudiantE int,
  prixEtudiantL int,
  prixExterneE int,
  prixExterneL int,
  nomCom1 varchar (30),
  mailCom1 varchar (50),
  nomCom2 varchar (30),
  mailCom2 varchar (50),
  epreuveV1 varchar (50),
  epreuveV2 varchar (50),
  epreuveS1 varchar (50),
  epreuveS2 varchar (50),
  epreuveS3 varchar (50),
  epreuveD1 varchar (50),
  epreuveD2 varchar (50),
  equipeImg varchar (50),
  plaquetteImg varchar (50),
  ancienImg varchar (50));

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
	bds tinyint(1) NOT NULL,
	vtt tinyint(1) NOT NULL,
	bus tinyint(1) NOT NULL,
	tshirt varchar(1) NOT NULL,
	fftri tinyint(1) NOT NULL,
	nomEquipe varchar(20) NOT NULL,
	attestation tinyint(1) NOT NULL,
	certifMed tinyint(1) NOT NULL,
	certifSco tinyint(1) NOT NULL,
	caution tinyint(1) NOT NULL,
  paiement tinyint(1) NOT NULL ,
	FOREIGN KEY (nomEquipe) REFERENCES Equipe(nom));

INSERT INTO Equipe (nom,mdp,typeRaid) VALUES ("Indiv","solo","Aventure");