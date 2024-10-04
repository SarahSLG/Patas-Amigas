package modelo;

import java.util.Date;


public class Funcionario extends Pessoa {
    private int idFuncionario;
    private Date contratacao;
    private String cargo;
    private float salario;
    private String departamento;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, Date contratacao, String cargo, float salario, String departamento) {
        this.idFuncionario = idFuncionario;
        this.contratacao = contratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }


    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", contratacao=" + contratacao +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
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
}
