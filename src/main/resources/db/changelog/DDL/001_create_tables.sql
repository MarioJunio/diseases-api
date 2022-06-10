--liquibase formatted sql
--changeset Mario:create-tables

CREATE TABLE symptom(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(40) UNIQUE
);

CREATE TABLE disease(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(80),
   description TEXT
);

CREATE TABLE disease_symptoms(
    disease_id INT,
    symptom_id INT,
    PRIMARY KEY (disease_id, symptom_id),
    FOREIGN KEY (disease_id) REFERENCES disease(id),
    FOREIGN KEY (symptom_id) REFERENCES symptom(id)
);