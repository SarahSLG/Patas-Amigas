package modelo;

import java.time.LocalDate;

/**
 * @author Sarah Guimarães
 */
public class Adotante extends Pessoa {
    private int idAdotante;
    private String preferencia;
    private String historicoAdocoes;
    private String status;

    public Adotante() {
        setFuncionario(true);
    }

    public Adotante(String nome, LocalDate dataNascimento, String genero, String cpf, String endereco, String telefone,
            String email, String senha, String hash, int idAdotante, String preferencia, String historicoAdocoes,
            String status) {
        super(nome, dataNascimento, genero, cpf, endereco, telefone, email, senha, hash);
        this.idAdotante = idAdotante;
        this.preferencia = preferencia;
        this.historicoAdocoes = historicoAdocoes;
        this.status = status;

        setFuncionario(true);
    }

    public Adotante(int idAdotante, String preferencia, String historicoAdocoes, String status) {
        this.idAdotante = idAdotante;
        this.preferencia = preferencia;
        this.historicoAdocoes = historicoAdocoes;
        this.status = status;

        setFuncionario(true);
    }

    @Override
    public String toString() {
        return "Adotante [idAdotante=" + idAdotante + ", preferencia=" + preferencia + ", historicoAdocoes="
                + historicoAdocoes + ", status=" + status + ", getClass()=" + getClass() + ", toString()="
                + super.toString() + ", getIdAdotante()=" + getIdAdotante() + ", getPreferencia()=" + getPreferencia()
                + ", getHistoricoAdocoes()=" + getHistoricoAdocoes() + ", getStatus()=" + getStatus() + ", getId()="
                + getId() + ", hashCode()=" + hashCode() + ", getNome()=" + getNome() + ", getDataNascimento()="
                + getDataNascimento() + ", getGenero()=" + getGenero() + ", getCpf()=" + getCpf() + ", getEndereco()="
                + getEndereco() + ", getTelefone()=" + getTelefone() + ", getEmail()=" + getEmail() + ", getSenha()="
                + getSenha() + ", getHash()=" + getHash() + ", podeAdotar()=" + podeAdotar() + ", podeDoar()="
                + podeDoar() + ", isFuncionario()=" + isFuncionario() + "]";
    }

    public void setIdAdotante(int idAdotante) {
        this.idAdotante = idAdotante;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public void setHistoricoAdocoes(String historicoAdocoes) {
        this.historicoAdocoes = historicoAdocoes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdAdotante() {
        return idAdotante;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public String getHistoricoAdocoes() {
        return historicoAdocoes;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public int getId() {
        return idAdotante;
    }
}
