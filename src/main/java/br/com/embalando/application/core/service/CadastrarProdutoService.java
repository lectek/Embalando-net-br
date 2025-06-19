package br.com.embalando.application.core.service;

import br.com.embalando.application.core.domain.Produto;
import br.com.embalando.application.core.port.in.CadastrarProdutoUseCase;
import br.com.embalando.application.core.port.out.ProdutoRepositoryPort;

public class CadastrarProdutoService implements CadastrarProdutoUseCase {

    private final ProdutoRepositoryPort repository;

    public CadastrarProdutoService(ProdutoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return repository.save(produto);
    }
}
