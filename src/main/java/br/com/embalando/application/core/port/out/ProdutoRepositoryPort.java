package br.com.embalando.application.core.port.out;

import br.com.embalando.application.core.domain.Produto;

import java.util.Optional;

public interface ProdutoRepositoryPort {
    Produto save(Produto produto);
    Optional<Produto> findById(Long id);
}
