package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Pedido;
import br.com.trampuu.trampuu.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repoPedido;

    public Pedido gravarPedido(Pedido p) {
        try {
            return repoPedido.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gravar pedido");
        }
    }

    public List<Pedido> buscarTodosPedidos() {
        try {
            return repoPedido.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar todos os pedidos");
        }
    }

    public Pedido atualizarPedidos(Pedido p, Long id) {
        Optional<Pedido> pedido = repoPedido.findById(id);
        if (pedido.isPresent()) {
            p.setId_Pedido(Math.toIntExact(id));
            return repoPedido.save(p);
        }
        throw new RuntimeException("Pedido nao encontrado");
    }

    public void deletarPedido(
            Long id
    ) {
        Pedido pedido = repoPedido.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pedido nao encontrado" + id
                )
        );
    }
}
