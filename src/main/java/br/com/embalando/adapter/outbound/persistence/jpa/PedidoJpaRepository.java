package br.com.embalando.adapter.outbound.persistence.jpa;

import br.com.embalando.adapter.outbound.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {
    // Ex: List<PedidoEntity> findByClienteId(Long clienteId);
}
