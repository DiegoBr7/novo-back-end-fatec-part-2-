package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Rota;
import br.com.trampuu.trampuu.Repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {


    @Autowired
    private RotaRepository rotaRepository;


    public Rota gravarRota(Rota r) {
        try {
            return rotaRepository.save(r);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao salvar Rota");
        }
    }

    public List<Rota> listarTodasRotas() {
        try {
            return rotaRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao listar todas as rotas");
        }
    }

    public void deletarRota(Long id){
        Rota rota = rotaRepository.findById(id).orElseThrow( ()->
                new RuntimeException(HttpStatus.NOT_FOUND + "Pedido nao encontrado" + id)
                );
        rotaRepository.delete(rota);
    }

    public Rota alterarRota(Rota r , Long id){
        Optional<Rota> rota = rotaRepository.findById(id);
        if(rota.isPresent()){
            r.setId_Rota(Math.toIntExact(id));
            return rotaRepository.save(r);
        }
        throw  new RuntimeException(HttpStatus.NOT_FOUND + "Rota nao atualizada");

    }
}
