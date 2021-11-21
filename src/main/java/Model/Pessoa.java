package Model;

public class Pessoa {
    private Long idPessoa;
    private String nomePessoa;
    private String sexoPessoa;

    public Pessoa() {
    }

    public Pessoa(String nomePessoa, String sexoPessoa) {
        this.nomePessoa = nomePessoa;
        this.sexoPessoa = sexoPessoa;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getSexoPessoa() {
        return sexoPessoa;
    }

    public void setSexoPessoa(String sexoPessoa) {
        this.sexoPessoa = sexoPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", sexoPessoa='" + sexoPessoa + '\'' +
                '}';
    }


}
