package br.com.embalando.adapter.outbound.persistence;

import br.com.embalando.application.core.domain.Produto;
import br.com.embalando.application.core.port.out.ProdutoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProdutoPersistenceAdapter implements ProdutoRepositoryPort {

    private final ProdutoJpaRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoPersistenceAdapter(ProdutoJpaRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Produto save(Produto produto) {
        ProdutoEntity entity = repository.save(mapper.toEntity(produto));
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }
}
