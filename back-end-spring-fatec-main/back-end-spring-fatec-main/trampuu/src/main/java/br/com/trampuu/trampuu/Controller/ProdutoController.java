package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Model.Produto;
import br.com.trampuu.trampuu.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> listarProdutos(@RequestBody Produto p ){
        List<Produto> produtos = produtoService.listarProdutos();
        return  ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @PostMapping
    public ResponseEntity<?> enviarProduto(
            @RequestBody Produto produto
    ){
        Produto novoProduto = produtoService.enviarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(
            @PathVariable Long id
    ){
        try {
            produtoService.excluirProduto(id);
            return new ResponseEntity<>("Exclusao de produto com sucesso" , HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
