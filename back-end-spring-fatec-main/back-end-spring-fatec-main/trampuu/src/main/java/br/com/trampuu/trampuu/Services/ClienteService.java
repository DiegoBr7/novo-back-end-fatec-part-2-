package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Cliente;
import br.com.trampuu.trampuu.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
@Autowired
    private ClienteRepository repoCliente;

    @Autowired
    private ClienteRepository clienteRepository;

public Cliente gravarCliente (Cliente a) {
    try {
        return repoCliente.save(a);
    } catch (Exception e) {
        throw new RuntimeException("Não foi possivel enontrar o cliente");
    }
}
    public List<Cliente> buscarTodos() {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            // Log do erro (você pode usar Logger em produção)
            System.err.println("Erro ao buscar clientes: " + e.getMessage());

            // Retorna uma lista vazia em caso de erro
            return List.of();

            // Ou lança uma exceção personalizada:
            // throw new BusinessException("Não foi possível listar os clientes", e);
        }
    }


}
