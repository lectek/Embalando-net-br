package br.com.embalando.adapter.outbound.persistence.jpa;

import br.com.embalando.adapter.outbound.persistence.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
    // Ex: métodos customizados podem ser adicionados aqui se necessário
}
