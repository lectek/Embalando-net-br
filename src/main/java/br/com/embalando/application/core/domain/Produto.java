package br.com.embalando.application.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entidade de domínio que representa um Produto do catálogo. (Não contém nenhuma anotação JPA; mapeamento ficará no
 * adapter/outbound.)
 */
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String imagem;
    private String categoria;

    /* -------------------- Construtores -------------------- */

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, String imagem, String categoria) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.categoria = categoria;
    }

    /* -------------------- Getters & Setters -------------------- */

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /* -------------------- Regras de domínio simples -------------------- */

    public void aplicarDesconto(BigDecimal percentual) {
        if (percentual == null || percentual.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Percentual de desconto inválido.");
        }
        BigDecimal fator = BigDecimal.ONE.subtract(percentual);
        this.preco = this.preco.multiply(fator);
    }

    /* -------------------- equals & hashCode por id -------------------- */

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Produto))
            return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
