package br.com.embalando.application.core.port.in;

import br.com.embalando.application.core.domain.Cliente;

public interface RegistrarClienteUseCase {
    Cliente registrar(Cliente cliente);
}
