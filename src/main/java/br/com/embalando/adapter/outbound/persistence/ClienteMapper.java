package br.com.embalando.adapter.outbound.persistence;

import br.com.embalando.application.core.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteEntity toEntity(Cliente cliente);
    Cliente toDomain(ClienteEntity entity);
}
