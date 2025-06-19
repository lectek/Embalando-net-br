package br.com.embalando.application.core.domain;

import java.util.Objects;

/**
 * Entidade que representa um cliente cadastrado na loja.
 */
public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha; // hash/BCrypt — não armazene texto puro em produção

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String telefone, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
    }

    /* Getters & Setters */

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /* Regra de domínio simples */
    public void atualizarTelefone(String novoTelefone) {
        if (novoTelefone == null || novoTelefone.length() < 8) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        this.telefone = novoTelefone;
    }

    /* equals & hashCode por id */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Cliente))
            return false;
        Cliente c = (Cliente) o;
        return Objects.equals(id, c.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
