package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Model.Item_Pedido;
import br.com.trampuu.trampuu.Services.Item_PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/item")
public class itemPedidoController {

    @Autowired
    private Item_PedidoService itemPedidoService;

    @GetMapping
    public List<Item_Pedido> listarItem(Item_Pedido itemPedido){

        return itemPedidoService.listarItem();
    }

    @PostMapping
    public ResponseEntity<?> salvarItem(@RequestBody Item_Pedido item) {
        try {
            Item_Pedido novoItem = itemPedidoService.salvarItem(item);
            return ResponseEntity.ok(novoItem);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar item: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarItem(@RequestBody Item_Pedido item , @PathVariable Long id){
        try {
            item = itemPedidoService.updateItem(item ,id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro no Controller atualizarItem");
        }
        return ResponseEntity.
                status(HttpStatus.OK).body(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(
            @PathVariable Long id
    ){
        try {
            itemPedidoService.excluirItem(id);
            return new ResponseEntity<>("exclusao com sucesso", HttpStatus.OK);

        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }

    }


}