package br.com.embalando.adapter.outbound.persistence;

import br.com.embalando.application.core.domain.Cliente;
import br.com.embalando.application.core.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class ClientePersistenceAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository repository;
    private final ClienteMapper mapper;

    public ClientePersistenceAdapter(ClienteJpaRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = repository.save(mapper.toEntity(cliente));
        return mapper.toDomain(entity);
    }
}
