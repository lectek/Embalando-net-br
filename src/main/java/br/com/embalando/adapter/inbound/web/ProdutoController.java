package br.com.embalando.adapter.inbound.web;

import br.com.embalando.application.core.domain.Produto;
import br.com.embalando.application.core.port.in.CadastrarProdutoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final CadastrarProdutoUseCase cadastrarProduto;

    public ProdutoController(CadastrarProdutoUseCase cadastrarProduto) {
        this.cadastrarProduto = cadastrarProduto;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto salvo = cadastrarProduto.cadastrar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
