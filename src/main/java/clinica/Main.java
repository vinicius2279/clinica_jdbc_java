/*Projeto: Sistema de cadastro de pacientes
Autor: Vinícius Cabral
Tecnologias: Java, JDBC, MySQL, Swing
Implementa operações CRUD para gerenciamento de pacientes
*/

package clinica;

import clinicaDAO.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Main {


    public static void main(String[] args) {


        int contador = 1;

// Entendi que médicos não precisam de entrada contínua de dados pela rotatividade ser menor que de pacientes

        Medicos medico1 = new Medicos(1, "André de Souza", 110);
        Medicos medico2 = new Medicos(2, "Poliana Silveira", 33);
        Medicos medico3 = new Medicos(3, "Artur Oliveira", 52);


        /* aqui vai dar início o menu principal, onde dá pra adicionar, visualizar, remover e editar os pacientes
        registrados no banco de dados */

        PacienteDAO pdao = new PacienteDAO();

        Random random = new Random();
        boolean rodando = true;

        while (rodando) {
            try {
                Object[] opcoes = {"1 - Adicionar Paciente",
                        "\n2 - Abrir lista de pacientes",
                        "\n3 - Editar dados de paciente",
                        "\n4 - Deletar paciente", "\n5 - Sair"};

                int escolha = JOptionPane.showOptionDialog(
                        null,
                        "O que deseja fazer?",
                        "Sistema de cadastro da Clínica",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]
                );
                switch (escolha) {

                    case 0:
                        rodando = true;
                        int id = contador++;
                        String nome = JOptionPane.showInputDialog
                                (null, "Insira o nome do paciente");
                        int idade = Integer.parseInt(JOptionPane.showInputDialog
                                (null, "Insira a idade do paciente: "));
                        int carteirinha = random.nextInt(1000);

                        Pacientes paciente = new Pacientes(nome, idade, carteirinha);

                        pdao.inserir(paciente);
                        JOptionPane.showMessageDialog
                                (null, "Paciente cadastrado no sistema");

                        int fechar = JOptionPane.showConfirmDialog(null,
                                "Deseja fechar o sistema?",
                                "Confirmação", JOptionPane.YES_NO_OPTION);

                        if (fechar == JOptionPane.YES_OPTION) {
                            rodando = false;
                        }
                        break;

                    case 1:

                        TabelaPacientes.mostrarTabelaPacientes(pdao);

                        int fechar1 = JOptionPane.showConfirmDialog(null,
                                "Deseja fechar o sistema?",
                                "Confirmação", JOptionPane.YES_NO_OPTION);

                        if (fechar1 == JOptionPane.YES_OPTION) {
                            rodando = false;
                        }

                        break;

                    case 2:


                        int idPaciente = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "Digite o ID do paciente que deseja atualizar:"));

                        String nomePaciente = JOptionPane.showInputDialog(null,
                                "Digite nome novo do paciente: ");

                        idade = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "Digite a nova idade:"));
                        carteirinha = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Insira o número da nova carteirinha"));

                        Pacientes pacienteAtualizado =
                                new Pacientes(idPaciente, nomePaciente, idade, carteirinha);

                        pdao.atualizar(pacienteAtualizado);

                        int fechar2 = JOptionPane.showConfirmDialog(null,
                                "Deseja fechar o sistema?",
                                "Confirmação", JOptionPane.YES_NO_OPTION);

                        if (fechar2 == JOptionPane.YES_OPTION) {
                            rodando = false;
                        }
                        break;

                    case 3:

                        int idExcluir = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Insira a ID do paciente que quer deletar"));
                        pdao.deletar(idExcluir);

                        int fechar3 = JOptionPane.showConfirmDialog(null,
                                "Deseja fechar o sistema?",
                                "Confirmação", JOptionPane.YES_NO_OPTION);

                        if (fechar3 == JOptionPane.YES_OPTION) {
                            rodando = false;

                        }
                        break;
                    case 4:
                        rodando = false;
                        JOptionPane.showMessageDialog(null, "Programa encerrado");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Foi identificado o seguinte erro: " + e.getMessage());


            }

        }


    }
}
