package br.com.trampuu.trampuu.Controller;


import br.com.trampuu.trampuu.Model.Veiculo;
import br.com.trampuu.trampuu.Services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<?> listarVeiculos(Veiculo v) {
        try {
            List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();
            return ResponseEntity.ok().body(veiculos);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao listar rotas: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> enviarVeic(@RequestBody Veiculo v){
        try{
            Veiculo veiculo =  veiculoService.gravarVeiculos(v);
            return  ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Veiculo nao enviado no Controller" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deletarVeiculo(
            @PathVariable Long id
    ){
        try{
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.status(HttpStatus.OK).body("Veículo excluído com sucesso!");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(
            @PathVariable Long id,
            @RequestBody Veiculo v

    ){

        v =  veiculoService.alterarVeiculo(v ,id);
        return ResponseEntity.status(HttpStatus.OK).body(v);

    }
}
