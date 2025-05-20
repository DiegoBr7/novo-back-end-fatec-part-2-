package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Model.Motorista;
import br.com.trampuu.trampuu.Services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            List<Motorista> motoristas = motoristaService.buscarTodosMotorista();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(motoristas);

        } catch (Exception e) {
            throw new RuntimeException("Nao foi possivel achar os dados do motorista");
        }
    }

    @PostMapping
    public ResponseEntity<Motorista> inserir(@RequestBody Motorista m) {
        try {
            return ResponseEntity.ok(motoristaService.gravarMotorista(m));
        } catch (RuntimeException e) {
            e.printStackTrace(); // loga o erro
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // ou pode retornar uma mensagem
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorista> atualizar(
            @PathVariable Long id,
            @RequestBody Motorista m
    ) {
        m = motoristaService.atualizarMotorista(m, id);
        return ResponseEntity.
                status(HttpStatus.OK).body(m);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(
            @PathVariable Long id
    ) {
        try {
            motoristaService.excluirPorId(id);
            return new ResponseEntity<>("exclusao com sucesso", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
        }

    }

}
