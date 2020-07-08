package models;

public class Produto {
    private Integer _id;
    private String nome;
    private String descricao;
    private Double preco;

    public Produto(){

    }

    public Produto(Integer _id, String nome, String descricao, Double preco) {
        this._id = _id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
