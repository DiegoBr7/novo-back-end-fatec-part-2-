package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Veiculo;
import br.com.trampuu.trampuu.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repoVeiculo;

    public List<Veiculo> listarTodosVeiculos(

    ) {
        try {
            return repoVeiculo.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao realizar a lista de veiculos");
        }

    }

    public Veiculo gravarVeiculos(Veiculo v) {
        try {
            return repoVeiculo.save(v);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao enviar o veiculoService!");
        }
    }

    public void deletarVeiculo(Long id) {
        Veiculo veiculo = repoVeiculo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                                HttpStatus.NOT_FOUND + "Deletar veiculo nao realizado" + id
                        )
                );
        repoVeiculo.delete(veiculo);
    }

    public Veiculo alterarVeiculo(Veiculo v , Long id ) {
        Optional<Veiculo> veiculo = repoVeiculo.findById(id);
        if(veiculo.isPresent()) {
            v.setId_Veiculo(Math.toIntExact(id));
            return repoVeiculo.save(v);
        }
        throw new RuntimeException(HttpStatus.NOT_FOUND + "Veiculo nao atualizado no service");
    }

}
