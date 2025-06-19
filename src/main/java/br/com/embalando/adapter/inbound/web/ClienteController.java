package br.com.embalando.adapter.inbound.web;

import br.com.embalando.application.core.domain.Cliente;
import br.com.embalando.application.core.port.in.RegistrarClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final RegistrarClienteUseCase registrarCliente;

    public ClienteController(RegistrarClienteUseCase registrarCliente) {
        this.registrarCliente = registrarCliente;
    }

    @PostMapping
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
        Cliente salvo = registrarCliente.registrar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
