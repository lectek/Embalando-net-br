package br.com.embalando.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private LocalDateTime data;
    private BigDecimal total;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private TipoPagamento tipoPagamento;

    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, LocalDateTime data, List<ItemPedido> itens, TipoPagamento tipoPagamento) {

        this.id = id;
        this.cliente = cliente;
        this.data = data != null ? data : LocalDateTime.now();
        this.itens = itens;
        this.tipoPagamento = tipoPagamento;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.total = calcularTotal(itens);
    }

    private BigDecimal calcularTotal(List<ItemPedido> itens) {
        return itens.stream().map(ItemPedido::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /* Regras de domínio */
    public void marcarPago() {
        if (status != StatusPedido.AGUARDANDO_PAGAMENTO)
            throw new IllegalStateException("Pedido não está aguardando pagamento.");
        status = StatusPedido.PAGO;
    }

    public void cancelar() {
        if (status == StatusPedido.ENVIADO || status == StatusPedido.ENTREGUE)
            throw new IllegalStateException("Pedido já enviado não pode ser cancelado.");
        status = StatusPedido.CANCELADO;
    }

    /* Getters */
    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    /* equals/hashCode por id */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pedido))
            return false;
        return Objects.equals(id, ((Pedido) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
