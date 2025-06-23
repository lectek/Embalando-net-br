package br.com.embalando.adapter.outbound.persistence.jpa;

import br.com.embalando.adapter.outbound.persistence.entity.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoJpaRepository extends JpaRepository<ItemPedidoEntity, Long> {
    // Ex: List<ItemPedidoEntity> findByPedidoId(Long pedidoId);
}
