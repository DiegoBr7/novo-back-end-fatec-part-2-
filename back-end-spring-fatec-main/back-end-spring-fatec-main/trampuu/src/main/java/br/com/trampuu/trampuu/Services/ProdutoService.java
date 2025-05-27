package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Produto;
import br.com.trampuu.trampuu.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repoProduto;

    public List<Produto> listarProdutos() {
        try {
            return  repoProduto.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar os produtos");
        }


    }

    public Produto enviarProduto(Produto produto) {
        try {
            return repoProduto.save(produto);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirProduto(Long id) {
        Produto produto = repoProduto.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto nao encontrado" + id
                )
                );
    }
}
