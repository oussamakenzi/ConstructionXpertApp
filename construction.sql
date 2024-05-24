CREATE DATABASE Constructionprojet;
USE Construction;

-- Création de la table Projet
CREATE TABLE Projet (
    IdProjet INT AUTO_INCREMENT PRIMARY KEY,
    NomProjet VARCHAR(255) NOT NULL,
    description TEXT,
    DteDebut DATE,
    DateFin DATE,
    Budget DOUBLE PRECISION
);

-- Création de la table Tache
CREATE TABLE Tache (
    IdTache INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT,
    dateDbTache DATE,
    dateFinTache DATE,
    IdProjet INT NOT NULL,
    FOREIGN KEY (IdProjet) REFERENCES Projet(IdProjet)  ON DELETE CASCADE ON UPDATE CASCADE
);

-- Création de la table Ressource
CREATE TABLE Ressource (
    idRessource INT AUTO_INCREMENT PRIMARY KEY,
    nomRessource VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    quantite INT,
    NomFournisseur VARCHAR(255),
    ContactFournisseur VARCHAR(255),
    Adresse VARCHAR(255),
    IdTache INT NOT NULL,
    FOREIGN KEY (IdTache) REFERENCES Tache(IdTache)  ON DELETE CASCADE ON UPDATE CASCADE
);
use Construction;
-- Insertion de projets dans la table Projet
INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget)
VALUES ('Construction Immeuble A', 'Construction d\'un immeuble résidentiel de 10 étages', '2024-06-01', '2025-12-31', 5000000);

INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget)
VALUES ('Rénovation Maison B', 'Rénovation complète d\'une maison de ville', '2024-07-15', '2024-12-15', 150000);

INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget)
VALUES ('Extension Usine C', 'Extension de l\'usine de production de 2000m² supplémentaires', '2024-08-01', '2025-05-01', 3000000);

INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget)
VALUES ('Aménagement Parc D', 'Création d\'un parc public avec des aires de jeux et des espaces verts', '2024-09-01', '2025-03-01', 800000);

INSERT INTO Projet (NomProjet, description, DteDebut, DateFin, Budget)
VALUES ('Construction Bureau E', 'Construction d\'un immeuble de bureaux de 15 étages', '2024-10-01', '2026-01-31', 10000000);

select * from projet; 