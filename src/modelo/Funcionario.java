package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Sarah Guimarães
 */
public class Funcionario extends Pessoa {
    private int idFuncionario;
    private Date contratacao;
    private String cargo;
    private float salario;
    private String departamento;

    public Funcionario() {
        setFuncionario(true);
    }

    public Funcionario(int idFuncionario, Date contratacao, String cargo, float salario, String departamento) {
        this.idFuncionario = idFuncionario;
        this.contratacao = contratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;

        setFuncionario(true);
    }

    public Funcionario(String nome, LocalDate dataNascimento, String genero, String cpf, String endereco, String telefone,
            String email, String senha, String hash, int idFuncionario, Date contratacao, String cargo, float salario,
            String departamento) {
        super(nome, dataNascimento, genero, cpf, endereco, telefone, email, senha, hash);
        this.idFuncionario = idFuncionario;
        this.contratacao = contratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;

        setFuncionario(true);
    }

    @Override
    public String toString() {
        return "Funcionario [idFuncionario=" + idFuncionario + ", contratacao=" + contratacao + ", cargo=" + cargo
                + ", salario=" + salario + ", departamento=" + departamento + ", getClass()=" + getClass()
                + ", toString()=" + super.toString() + ", getIdFuncionario()=" + getIdFuncionario()
                + ", getContratacao()=" + getContratacao() + ", getCargo()=" + getCargo() + ", getSalario()="
                + getSalario() + ", getDepartamento()=" + getDepartamento() + ", getId()=" + getId() + ", hashCode()="
                + hashCode() + ", getNome()=" + getNome() + ", getDataNascimento()=" + getDataNascimento()
                + ", getGenero()=" + getGenero() + ", getCpf()=" + getCpf() + ", getEndereco()=" + getEndereco()
                + ", getTelefone()=" + getTelefone() + ", getEmail()=" + getEmail() + ", getSenha()=" + getSenha()
                + ", getHash()=" + getHash() + ", podeAdotar()=" + podeAdotar() + ", podeDoar()=" + podeDoar()
                + ", isFuncionario()=" + isFuncionario() + "]";
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setContratacao(Date contratacao) {
        this.contratacao = contratacao;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public Date getContratacao() {
        return contratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public float getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public int getId() {
        return idFuncionario;
    }
}
