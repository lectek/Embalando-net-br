package br.com.embalando.adapter.outbound.persistence;

import br.com.embalando.application.core.domain.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoEntity toEntity(Produto produto);
    Produto toDomain(ProdutoEntity entity);
}
