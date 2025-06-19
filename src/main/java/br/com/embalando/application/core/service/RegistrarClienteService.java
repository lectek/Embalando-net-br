package br.com.embalando.application.core.service;

import br.com.embalando.application.core.domain.Cliente;
import br.com.embalando.application.core.port.in.RegistrarClienteUseCase;
import br.com.embalando.application.core.port.out.ClienteRepositoryPort;

public class RegistrarClienteService implements RegistrarClienteUseCase {

    private final ClienteRepositoryPort repository;

    public RegistrarClienteService(ClienteRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Cliente registrar(Cliente cliente) {
        return repository.save(cliente);
    }
}
