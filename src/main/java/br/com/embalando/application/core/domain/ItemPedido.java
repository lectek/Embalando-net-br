package br.com.embalando.application.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemPedido {

    private Long id;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal subtotal;

    public ItemPedido() {
    }

    public ItemPedido(Long id, Produto produto, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    /* Getters */
    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /* equals/hashCode por id */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ItemPedido))
            return false;
        return Objects.equals(id, ((ItemPedido) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
