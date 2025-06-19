package br.com.embalando.application.core.port.out;

import br.com.embalando.application.core.domain.Cliente;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
}
