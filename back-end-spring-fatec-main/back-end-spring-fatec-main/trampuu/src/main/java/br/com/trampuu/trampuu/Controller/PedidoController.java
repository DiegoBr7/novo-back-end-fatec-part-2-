package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Model.Pedido;
import br.com.trampuu.trampuu.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> enviarPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.gravarPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel enviar os dados do pedido");
        }
    }

    @GetMapping
    public ResponseEntity<?> listaPedidos() {
        try {
            List<Pedido> pedidos = pedidoService.buscarTodosPedidos();
            return ResponseEntity.status(HttpStatus.OK).body(pedidos);

        } catch (Exception e) {
            throw new RuntimeException("erro ao enviar o pedido");
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(
            @PathVariable Long id,
            @RequestBody Pedido p
    ) {
        p = pedidoService.atualizarPedidos(p, id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(
            @PathVariable Long id
            ) {
        try {
            pedidoService.deletarPedido(id);
            return  new ResponseEntity<>("Exclusao de pedido com sucesso" , HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getMessage(),e.getStatusCode());
        }
    }
}