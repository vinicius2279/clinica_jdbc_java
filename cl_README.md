\## Sistema de Cadastro de Pacientes (Java + MySQL)





## Descrição



Este projeto consiste em um sistema simples de cadastro de pacientes desenvolvido em Java.
O sistema permite realizar operações básicas de CRUD (Create, Read, Update, Delete) em um banco de dados MySQL utilizando JDBC.

A interface do sistema foi construída com swing, utilizando JOptionPane para a interação com o usuário e JTable para exibição dos
dados cadastrados.

## 

## Funcionalidades:

* Cadastrar pacientes
* Listar pacientes cadastrados
* Atualizar dados de pacientes
* Excluir pacientes
* Visualizar pacientes em tabela

## 

## Tecnologias utilizadas:

* Java
* JDBC
* MySQL
* Swing
* Maven



## Estrutura do Projeto

clinica

|-- Pacientes.java
|-- Medicos.java
|-- TabelaPacientes.java
|-- Main.java

clinicaDAO
|-- pacienteDAO.java





## Estrutura do Banco de Dados

idPaciente | INT (AUTO\_INCREMENT)
nomePaciente | VARCHAR
idade | INT
carteirinha | INT





## Como executar o projeto

1. Instalar Java JDK
2. Instalar MySQL
3. Criar o banco de dados:

CREATE DATABASE clinica\_1;

4. Criar a tabela

use clinica\_1;
DROP TABLE IF EXISTS pacientes;
CREATE TABLE IF NOT EXISTS pacientes (

idPaciente INT PRIMARY KEY AUTO\_INCREMENT,
nomePaciente VARCHAR(50) NOT NULL,
idade INT NULL,
carteirinha INT NOT NULL
);

5. Configurar usuário e senha no código:
jdbc:mysql://localhost:3306/clinica\_1

6.Executar a classe Main.java





## Autor: Vinícius Cabral

