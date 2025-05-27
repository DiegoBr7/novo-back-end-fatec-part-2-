package br.com.trampuu.trampuu.Controller;

import br.com.trampuu.trampuu.Model.Rota;
import br.com.trampuu.trampuu.Services.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/rota")
public class RotaController {

    @Autowired
    private RotaService rotaService;

    @PostMapping
    public ResponseEntity<?> enviarRota(@RequestBody Rota r) {
        try {
            Rota novaRota = rotaService.gravarRota(r);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaRota);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a rota: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodasRotas() {
        try {
            List<Rota> rotas = rotaService.listarTodasRotas();
            return ResponseEntity.ok(rotas);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao listar rotas: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarRota(
            @PathVariable Long id
    ){
        try {
            rotaService.deletarRota(id);
            return new ResponseEntity<>("Rota deletada",HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getMessage(),e.getStatusCode());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> atualizarRota(
            @PathVariable Long id,
            @RequestBody Rota r
    ){

            r = rotaService.alterarRota(r , id);
            return ResponseEntity.status(HttpStatus.OK).body(r);

    }
}
