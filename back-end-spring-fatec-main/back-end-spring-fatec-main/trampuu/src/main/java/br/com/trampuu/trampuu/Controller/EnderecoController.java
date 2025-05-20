//package br.com.trampuu.trampuu.Controller;
//
//import br.com.trampuu.trampuu.Model.Endereco;
//import br.com.trampuu.trampuu.Services.EnderecoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/endereco")
//public class EnderecoController {
//
//    @Autowired
//    private EnderecoService enderecoService;
//
//    @GetMapping
//    public ResponseEntity<List<Endereco>> buscaTodosEndereco(){
//        try {
//            List<Endereco> enderecos = enderecoService.buscarTodosEnderecos();
//            return ResponseEntity.ok(enderecos);
//        } catch (RuntimeException e) {
//            return ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(null);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Endereco> inserir(@RequestBody Endereco e){
//        try {
//            return ResponseEntity.ok(enderecoService.gravarEndereco(e));
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Endereco> alterar(
//            @PathVariable Long id, @RequestBody Endereco e
//    ){
//        try {
//            Endereco enderecoAtualizado = enderecoService.alterarEndereco(e, id);
//            return ResponseEntity.ok(enderecoAtualizado);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        try {
//            enderecoService.excluirEnderecoPorId(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}