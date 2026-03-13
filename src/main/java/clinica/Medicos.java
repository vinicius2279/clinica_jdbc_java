
//classe auxiliar, só para o caso de expansão de código com entrada de dados sobre médicos e consultas

package clinica;

public class Medicos {

    private int idMedico;
    private String nomeMedico;
    private int matricula;

    public Medicos(int idMedico, String nomeMedico, int matricula) {

        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.matricula = matricula;

    }

    public int getIdMedico() {

        return idMedico;
    }

    public String getNomeMedico() {

        return nomeMedico;
    }



    public int getMatricula() {

        return matricula;
    }

    public void setIdMedico(int idMedico) {


        this.idMedico = idMedico;
    }

    public void setNomeMedico(String nomeMedico) {

        this.nomeMedico = nomeMedico;
    }

    public void setMatricula(int matricula) {

        this.matricula = matricula;
    }


}





