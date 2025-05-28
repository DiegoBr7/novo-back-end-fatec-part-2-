package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Cliente;
import br.com.trampuu.trampuu.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repoCliente;

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente gravarCliente(Cliente a) {
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


    public Cliente alterarCliente(Cliente c, Long id) {
        Optional<Cliente> cl = repoCliente.findById(id);
        if (cl.isPresent()) {
            c.setId((long) Math.toIntExact(id));
            return repoCliente.save(c);
        } else throw new RuntimeException("Nao encontrado");

    }

    private Cliente buscarPorId(Long id) {

        Optional<Cliente> cl = repoCliente.findById(id);

        return cl.orElseThrow(()->
            new  RuntimeException("Nao encontrado!")
        );
    }



    public Cliente excluirPorId(Long id) {
        Cliente cliente = repoCliente.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente nao encontrado com o ID:" + id
                ));
       repoCliente.delete(cliente);
       return null;
    }

}
