package br.com.embalando.application.core.service;

import br.com.embalando.application.core.domain.Pedido;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PedidoService {

    private final Map<Long, Pedido> pedidos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Pedido salvar(Pedido pedido) {
        long id = idGenerator.getAndIncrement();
        pedido.setId(id); // precisa do setter no domínio
        pedidos.put(id, pedido);
        return pedido;
    }

    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return Optional.ofNullable(pedidos.get(id));
    }

    public void deletar(Long id) {
        pedidos.remove(id);
    }
}
