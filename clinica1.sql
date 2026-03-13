use clinica_1;
DROP TABLE IF EXISTS pacientes;
CREATE TABLE IF NOT EXISTS pacientes (

idPaciente INT PRIMARY KEY AUTO_INCREMENT,
nomePaciente VARCHAR(50) NOT NULL,
idade INT NULL,
carteirinha INT NOT NULL
);
