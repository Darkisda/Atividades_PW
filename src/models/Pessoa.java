package models;

public class Pessoa {

    private String nome;
    private Integer idade;
    private String[] preferencias;

    public Pessoa() {
    }

    public Pessoa(String nome, String idade, String[] preferencias) {
        this.nome = nome;
        this.idade = Integer.parseInt(idade);
        this.preferencias = preferencias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String[] getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String[] preferencias) {
        this.preferencias = preferencias;
    }
}
