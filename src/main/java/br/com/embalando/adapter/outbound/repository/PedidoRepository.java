package br.com.embalando.adapter.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.embalando.application.core.domain.Pedido;

/**
 * Spring Data JPA repository for managing Pedido entities. Follows the hexagonal architecture: this is the outbound
 * adapter.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos básicos de CRUD e paginação são herdados de JpaRepository
}
