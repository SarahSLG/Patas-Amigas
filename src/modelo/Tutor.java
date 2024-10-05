package modelo;

import java.util.Date;

public class Tutor extends Pessoa {
    private int idTutor;
    private int animaisCustodia;
    private String historico;
    private String status;

    public Tutor() {
    }

    public Tutor(String nome, Date dataNascimento, String genero, String cpf, String endereco, String telefone,
            String email, String senha, String hash, int idTutor, int animaisCustodia, String historico,
            String status) {
        super(nome, dataNascimento, genero, cpf, endereco, telefone, email, senha, hash);
        this.idTutor = idTutor;
        this.animaisCustodia = animaisCustodia;
        this.historico = historico;
        this.status = status;
    }

    public Tutor(int idTutor, int animaisCustodia, String historico, String status) {
        this.idTutor = idTutor;
        this.animaisCustodia = animaisCustodia;
        this.historico = historico;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "idTutor=" + idTutor +
                ", animaisCustodia=" + animaisCustodia +
                ", historico='" + historico + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public void setAnimaisCustodia(int animaisCustodia) {
        this.animaisCustodia = animaisCustodia;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public int getAnimaisCustodia() {
        return animaisCustodia;
    }

    public String getHistorico() {
        return historico;
    }

    public String getStatus() {
        return status;
    }
}