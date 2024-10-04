package modelo;

public class Adotante extends Pessoa {
    private int idAdotante;
    private String preferencia;
    private String historicoAdocoes;
    private String status;

    public Adotante() {
    }

    public Adotante(int idAdotante, String preferencia, String historicoAdocoes, String status) {
        this.idAdotante = idAdotante;
        this.preferencia = preferencia;
        this.historicoAdocoes = historicoAdocoes;
        this.status = status;
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
}
