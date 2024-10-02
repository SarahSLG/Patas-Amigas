package modelo;

import java.util.Date;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String idade;
    private String sexo;
    private String historicoMedico;
    private Date cadastro;
    private String statusAdocao;

    public Animal() {
    }

    public Animal(String nome, String especie, String raca, String idade, String sexo, String historicoMedico, Date cadastro, String statusAdocao) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.historicoMedico = historicoMedico;
        this.cadastro = cadastro;
        this.statusAdocao = statusAdocao;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", idade='" + idade + '\'' +
                ", sexo='" + sexo + '\'' +
                ", historicoMedico='" + historicoMedico + '\'' +
                ", cadastro=" + cadastro +
                ", statusAdocao='" + statusAdocao + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public void setStatusAdocao(String statusAdocao) {
        this.statusAdocao = statusAdocao;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public String getStatusAdocao() {
        return statusAdocao;
    }
}