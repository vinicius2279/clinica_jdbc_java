//aqui é feito todo o processo de CRUD (Create, Read, Update, Delete) processado na classe Main

package clinicaDAO;
import clinica.Pacientes;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//método para reaproveitar a conexão com o banco para todo o processo de CRUD

public class PacienteDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica_1",
                "root", "admin");
    }


// método de inserção de dados no banco

    public void inserir(Pacientes paciente) {
        String sql = "INSERT INTO pacientes (nomePaciente, idade, carteirinha)" +
                " VALUES (?, ?, ?)";

        try {


            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, paciente.getNomePaciente());
            stmt.setInt(2, paciente.getIdade());
            stmt.setInt(3, paciente.getCarteirinha());

            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    ("Você não conseguiu devido ao seguinte erro: " + e.getMessage()));
        }

    }


    //método de exibição de pacientes cadastrados no banco de dados

    public List<Pacientes> listarPacientes() {

        List<Pacientes> lpacientes = new ArrayList<>();

        String sql = "SELECT * FROM pacientes";

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idPaciente = rs.getInt("idPaciente");
                String nomePaciente = rs.getString("nomePaciente");
                int idade = rs.getInt("idade");
                int carteirinha = rs.getInt("carteirinha");
                Pacientes paciente = new Pacientes(idPaciente, nomePaciente, idade, carteirinha);
                lpacientes.add(paciente);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível a leitura devido ao seguinte erro: " +
                            " " + e.getMessage());

        }
        return lpacientes;
    }


    //método de edição de pacientes

    public void atualizar(Pacientes paciente) {

        String sql = "UPDATE pacientes SET nomePaciente = ?, idade = ?, carteirinha = ? WHERE idPaciente = ?";

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);


            stmt.setString(1, paciente.getNomePaciente());
            stmt.setInt(2, paciente.getIdade());
            stmt.setInt(3, paciente.getCarteirinha());
            stmt.setInt(4, paciente.getIdPaciente());

            stmt.executeUpdate();
            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Dado atualizado com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível atualizar devido ao seguinte erro: " + e.getMessage());
        }
    }


    //método de exclusão de pacientes

    public void deletar(int idPaciente) {

        String sql = "DELETE FROM pacientes WHERE idPaciente = ?";

        try {
            Connection conn = getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idPaciente);

            stmt.executeUpdate();
            stmt.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível excluir devido ao seguinte erro: " + e.getMessage());
        }
    }

}

