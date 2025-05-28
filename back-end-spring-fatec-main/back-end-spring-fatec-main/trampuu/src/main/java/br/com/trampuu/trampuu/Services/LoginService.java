package br.com.trampuu.trampuu.Services;

import br.com.trampuu.trampuu.Model.Cliente;
import br.com.trampuu.trampuu.Repository.ClienteRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialExpiredException;
import java.util.Optional;


@Service
public class LoginService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente autenticar(@NotBlank String nome, @NotBlank String senha) throws CredentialExpiredException {

        Optional<Cliente> clienteOptional = clienteRepository.findByNome(nome);

        if (clienteOptional.isEmpty()) {
            throw new CredentialExpiredException("Cliene nao encontrado!");
        }
        Cliente cliente = clienteOptional.get();

        if (!cliente.getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta!");
        }

        return cliente;

    }
}