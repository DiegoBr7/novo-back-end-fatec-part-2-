package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Item_Pedido;
import br.com.trampuu.trampuu.Repository.Item_PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Item_PedidoService {

    @Autowired
    private Item_PedidoRepository repoItem;

    public Item_Pedido salvarItem(Item_Pedido item) {
        try {
            return repoItem.save(item);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    ;

    public List<Item_Pedido> listarItem() {
        try {
            return repoItem.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public Item_Pedido updateItem(Item_Pedido item, Long id) {
        Optional<Item_Pedido> atualizarItem = repoItem.findById(id);
        if (atualizarItem.isPresent()) {
            item.setId_Item_Pedido(Math.toIntExact(id));
            return repoItem.save(item);
        } else throw new RuntimeException("Erro no service UpdateItem ");

    }

    public void excluirItem(
            @PathVariable Long id
    ) {
        Item_Pedido item = repoItem.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "item nao encontrado" + id)
        );
        repoItem.delete(item);
    }


}
