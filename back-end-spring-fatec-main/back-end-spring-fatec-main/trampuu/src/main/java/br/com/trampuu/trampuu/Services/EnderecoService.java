//package br.com.trampuu.trampuu.Services;
//
//import br.com.trampuu.trampuu.Model.Endereco;
//import br.com.trampuu.trampuu.Repository.EnderecoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EnderecoService {
//
//    @Autowired
//    private EnderecoRepository repoEndereco;
//
//    public Endereco gravarEndereco(Endereco end) {
//        try {
//            return repoEndereco.save(end);
//        } catch (Exception e) {
//            throw new RuntimeException("Nao foi possivel salvar o endereco: " + e.getMessage());
//        }
//    }
//
//    public List<Endereco> buscarTodosEnderecos() {
//        try {
//            return repoEndereco.findAll();
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao buscar enderecos: " + e.getMessage());
//        }
//    }
//
//    public Endereco alterarEndereco(Endereco e, Long id) {
//        Optional<Endereco> end = repoEndereco.findById(id);
//        if (end.isPresent()) {
//            e.setId_Endereco(id);
//            return repoEndereco.save(e);
//        } else {
//            throw new RuntimeException("Endereco nao encontrado com ID: " + id);
//        }
//    }
//
//    public Endereco buscarEnderecoPorId(Long id) {
//        Optional<Endereco> end = repoEndereco.findById(id);
//        return end.orElseThrow(() -> new RuntimeException("Endereco nao encontrado com ID: " + id));
//    }
//
//    public void excluirEnderecoPorId(Long id) {
//        Endereco endereco = repoEndereco.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND,
//                        "Endereco nao encontrado com o ID: " + id
//                ));
//        repoEndereco.delete(endereco);
//    }
//}