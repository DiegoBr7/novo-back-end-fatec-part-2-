package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Model.Cliente;
import br.com.trampuu.trampuu.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService ;

    @GetMapping
    public ResponseEntity<?> buscarTodos(){
    try {
        List<Cliente> clientes =clienteService.buscarTodos();
        return ResponseEntity.ok(clientes);
    } catch (RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao processar a requisicao: " + e.getMessage());
    }
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir (@RequestBody Cliente a){
        return ResponseEntity.ok(clienteService.gravarCliente(a));
    }
}
