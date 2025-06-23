package br.com.embalando.adapter.outbound.persistence.jpa;

import br.com.embalando.adapter.outbound.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {
    // Ex: Optional<ClienteEntity> findByEmail(String email);
}
