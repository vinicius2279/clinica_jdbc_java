//aqui é a classe que lida com os pacientes, com a declaração de variáveis, construtores, getters e setters

package clinica;

public class Pacientes {

    private int idPaciente;
    private String nomePaciente;
    private int idade;
    private int carteirinha;

    public Pacientes(String nomePaciente, int idade, int carteirinha) {

        this.nomePaciente = nomePaciente;
        this.idade = idade;
        this.carteirinha = carteirinha;

    }

    public Pacientes(int idPaciente, String nomePaciente, int idade, int carteirinha) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.idade = idade;
        this.carteirinha = carteirinha;
    }

    public int getIdPaciente() {

        return idPaciente;

    }

    public String getNomePaciente() {


        return nomePaciente;
    }

    public int getIdade() {

        return idade;

    }

    public int getCarteirinha() {

        return carteirinha;

    }

    public void setidPaciente(int idPaciente) {

        this.idPaciente = idPaciente;

    }

    public void setNomePaciente(String nomePaciente) {

        this.nomePaciente = nomePaciente;
    }

    public void setIdade(int idade) {


        this.idade = idade;

    }

    public void setCarteirinha(int carteirinha) {

        this.carteirinha = carteirinha;
    }

}


