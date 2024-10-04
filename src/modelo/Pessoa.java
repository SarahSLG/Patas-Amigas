package modelo;

import java.util.Date;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String genero;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    private String hash;

    public Pessoa() {
    }

    public Pessoa(String nome, Date dataNascimento, String genero, String cpf, String endereco, String telefone, String email, String senha, String hash) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "modelo.Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", genero='" + genero + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getDataNascimento(), pessoa.getDataNascimento()) && Objects.equals(getGenero(), pessoa.getGenero()) && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getEndereco(), pessoa.getEndereco()) && Objects.equals(getTelefone(), pessoa.getTelefone()) && Objects.equals(getEmail(), pessoa.getEmail()) && Objects.equals(getSenha(), pessoa.getSenha()) && Objects.equals(getHash(), pessoa.getHash());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDataNascimento(), getGenero(), getCpf(), getEndereco(), getTelefone(), getEmail(), getSenha(), getHash());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getHash() {
        return hash;
    }
}