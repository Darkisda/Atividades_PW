package models;

public class Usuario {
    private Integer id;
    private String username;
    private String senha;
    private String email;

    public Usuario(Integer id, String username, String senha, String email) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
