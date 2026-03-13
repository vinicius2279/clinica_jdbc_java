//tabela de exibição de pacientes em classe separada para que o código no Main fique mais limpo

package clinica;
import clinicaDAO.PacienteDAO;
import javax.swing.*;
import java.util.List;

public class TabelaPacientes {

    public static void mostrarTabelaPacientes(PacienteDAO pdao) {

        List<Pacientes> pacientes = pdao.listarPacientes();

        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
        String[] colunas = {"ID", "Nome", "Idade", "Carteirinha"};

        String[][] dados = new String[pacientes.size()][4];

        for (int i = 0; i < pacientes.size(); i++) {
            Pacientes p = pacientes.get(i);

            dados[i][0] = String.valueOf(p.getIdPaciente());
            dados[i][1] = p.getNomePaciente();
            dados[i][2] = String.valueOf(p.getIdade());
            dados[i][3] = String.valueOf(p.getCarteirinha());
        }

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);

        tabela.setEnabled(false);

        JOptionPane.showMessageDialog(
                null,
                scrollPane,
                "Lista de Pacientes",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
