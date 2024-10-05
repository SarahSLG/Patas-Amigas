package modelo;

import java.time.LocalDate;

/**
 * @author Sarah Guimarães
 */
public class Tutor extends Pessoa {
    private int idTutor;
    private int animaisCustodia;
    private String historico;
    private String status;

    public Tutor() {
        setPodeDoar(true);
    }

    public Tutor(String nome, LocalDate dataNascimento, String genero, String cpf, String endereco, String telefone,
            String email, String senha, String hash, int idTutor, int animaisCustodia, String historico,
            String status) {
        super(nome, dataNascimento, genero, cpf, endereco, telefone, email, senha, hash);
        this.idTutor = idTutor;
        this.animaisCustodia = animaisCustodia;
        this.historico = historico;
        this.status = status;

        setPodeDoar(true);
    }

    public Tutor(int idTutor, int animaisCustodia, String historico, String status) {
        this.idTutor = idTutor;
        this.animaisCustodia = animaisCustodia;
        this.historico = historico;
        this.status = status;

        setPodeDoar(true);
    }

    @Override
    public String toString() {
        return "Tutor [idTutor=" + idTutor + ", animaisCustodia=" + animaisCustodia + ", historico=" + historico
                + ", status=" + status + ", getIdTutor()=" + getIdTutor() + ", getClass()=" + getClass()
                + ", getAnimaisCustodia()=" + getAnimaisCustodia() + ", toString()=" + super.toString()
                + ", getHistorico()=" + getHistorico() + ", getStatus()=" + getStatus() + ", getId()=" + getId()
                + ", hashCode()=" + hashCode() + ", getNome()=" + getNome() + ", getDataNascimento()="
                + getDataNascimento() + ", getGenero()=" + getGenero() + ", getCpf()=" + getCpf() + ", getEndereco()="
                + getEndereco() + ", getTelefone()=" + getTelefone() + ", getEmail()=" + getEmail() + ", getSenha()="
                + getSenha() + ", getHash()=" + getHash() + ", podeAdotar()=" + podeAdotar() + ", podeDoar()="
                + podeDoar() + ", isFuncionario()=" + isFuncionario() + "]";
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

    @Override
    public int getId() {
        return idTutor;
    }
}