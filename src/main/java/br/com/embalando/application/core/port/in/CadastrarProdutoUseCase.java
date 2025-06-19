package br.com.embalando.application.core.port.in;

import br.com.embalando.application.core.domain.Produto;

public interface CadastrarProdutoUseCase {
    Produto cadastrar(Produto produto);
}
